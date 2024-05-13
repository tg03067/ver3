package com.green.greengramver3.feed;

import com.green.greengramver3.common.CustomFileUtils;
import com.green.greengramver3.common.GlobalConst;
import com.green.greengramver3.feed.model.*;
import com.green.greengramver3.feedComment.model.FeedCommentSelRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;
    private final CustomFileUtils customFileUtils;

    @Transactional
    public FeedInsRes insFeed(List<MultipartFile> pics, FeedInsReq p){
        int result = mapper.insFeed(p);
        log.info(String.format("%d",result));
        FeedPicInsDto picDto = FeedPicInsDto.builder().feedId(p.getFeedId()).build();
        try{
            String path = String.format("feed/%d", p.getFeedId());
            customFileUtils.makeRandomFileName(path);
            for(MultipartFile pic : pics){
                String saveFileName = customFileUtils.makeRandomFileName(pic);
                picDto.getFileNames().add(saveFileName);
                String target = String.format("%s/%s", path, saveFileName);
                customFileUtils.transferTo(pic, target);
            }
            int affectedRowsPics = mapper.insFeedPics(picDto);
            log.info("affectedRowsPics: {}", affectedRowsPics);
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Feed 등록 오류");
        }
        return FeedInsRes.builder().
                feedId(p.getFeedId()).
                pics(picDto.getFileNames()).
                build();
    }
    public List<FeedSelRes> selFeed(FeedSelReq p){
        List<FeedSelRes> list = mapper.selFeed(p);
        if(list.isEmpty()){
            return Collections.emptyList();
        }
        for(FeedSelRes res : list){
            List<String> pics = mapper.selFeedPicsByFeedId(res.getFeedId());
            res.setPics(pics);

            List<FeedCommentSelRes> comments = mapper.selFeedCommentTopBy4ByFeedId(res.getFeedId());
            boolean hasMoreComment = comments.size() == GlobalConst.COMMENT_SIZE_PER_FEED;
            res.setIsMoreComment( hasMoreComment ? 1 : 0 );
            if(hasMoreComment){
                comments.remove(comments.size() - 1);
            }
            res.setComments(comments);
        }
        return list ;
    }


}

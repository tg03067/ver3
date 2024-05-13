package com.green.greengramver3.feedComment;

import com.green.greengramver3.feedComment.model.FeedCommentDeleteReq;
import com.green.greengramver3.feedComment.model.FeedCommentInsReq;
import com.green.greengramver3.feedComment.model.FeedCommentSelRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedCommentService {
    private final FeedCommentMapper mapper;

    public long intFeedComment(FeedCommentInsReq p){
        int affectedRows = mapper.intFeedComment(p);
        return p.getFeedCommentId();
    }
    public int delFeedComment(FeedCommentDeleteReq p){
        return mapper.delFeedComment(p);
    }
    public List<FeedCommentSelRes> selFeedComment(Long feedId){
        return mapper.selFeedComment(feedId);
    }
}

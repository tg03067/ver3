package com.green.greengramver3.feedComment;

import com.green.greengramver3.common.model.ResultDto;
import com.green.greengramver3.feedComment.model.FeedCommentDeleteReq;
import com.green.greengramver3.feedComment.model.FeedCommentInsReq;
import com.green.greengramver3.feedComment.model.FeedCommentSelRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/feed/comment")
@Slf4j
@Tag(name = "Feed 댓글", description = "댓글관련")
public class FeedCommentController {
    private final FeedCommentService service;

    @PostMapping
    @Operation(summary = "댓글쓰기")
    public ResultDto<Long> insFeedComment(@RequestBody FeedCommentInsReq p){
        long result = service.intFeedComment(p);

        return ResultDto.<Long>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).
                build();
    }
    @DeleteMapping
    @Operation(summary = "댓글지우기")
    public ResultDto<Integer> delFeedComment(FeedCommentDeleteReq p){
        int result = service.delFeedComment(p);

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(result == 0 ? "댓글 삭제를 할 수 없습니다." : "댓글을 삭제하였습니다.").
                resultData(result).
                build();
    }
    @GetMapping
    @Operation(summary = "댓글가져오기")
    public ResultDto<List<FeedCommentSelRes>> selFeedComment(@RequestParam(name = "feed_id") Long feedId){
        List<FeedCommentSelRes> list = service.selFeedComment(feedId);

        return ResultDto.<List<FeedCommentSelRes>>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(String.format("rows: %,d", list.size())).
                resultData(list).
                build();
    }
}

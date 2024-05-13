package com.green.greengramver3.feedComment;

import com.green.greengramver3.feedComment.model.FeedCommentDeleteReq;
import com.green.greengramver3.feedComment.model.FeedCommentInsReq;
import com.green.greengramver3.feedComment.model.FeedCommentSelRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedCommentMapper {
    int intFeedComment(FeedCommentInsReq p);
    int delFeedComment(FeedCommentDeleteReq p);
    List<FeedCommentSelRes> selFeedComment(Long feedId);
}

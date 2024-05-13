package com.green.greengramver3.feed;

import com.green.greengramver3.feed.model.FeedInsReq;
import com.green.greengramver3.feed.model.FeedPicInsDto;
import com.green.greengramver3.feed.model.*;
import com.green.greengramver3.feed.model.FeedSelRes;
import com.green.greengramver3.feedComment.model.FeedCommentSelRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int insFeed(FeedInsReq p);
    int insFeedPics(FeedPicInsDto p);
    List<FeedSelRes> selFeed(FeedSelReq p);
    List<String> selFeedPicsByFeedId(long feedId);
    List<FeedCommentSelRes> selFeedCommentTopBy4ByFeedId(Long feedId);
}

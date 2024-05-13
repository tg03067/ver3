package com.green.greengramver3.feedFavorite;

import com.green.greengramver3.feedFavorite.model.FeedFavoriteToggleReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedFavoriteMapper {
    int insFeedFavorite(FeedFavoriteToggleReq p);
    int delFeedFavorite(FeedFavoriteToggleReq p);
}

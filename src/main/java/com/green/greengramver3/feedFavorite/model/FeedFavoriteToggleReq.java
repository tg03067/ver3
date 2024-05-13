package com.green.greengramver3.feedFavorite.model;

import lombok.Data;

@Data
public class FeedFavoriteToggleReq {
    private Long feedId;
    private Long userId;
}

package com.green.greengramver3.feedFavorite;

import com.green.greengramver3.feedFavorite.model.FeedFavoriteToggleReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedFavoriteService {
    private final FeedFavoriteMapper mapper;

    public int insFeedFavorite(FeedFavoriteToggleReq p){
        return mapper.insFeedFavorite(p);
    }
    public int toggleFavorite(FeedFavoriteToggleReq p){
        int result = mapper.delFeedFavorite(p);
        if(result == 1){
            return 0;
        }
        return mapper.insFeedFavorite(p);
    }
}

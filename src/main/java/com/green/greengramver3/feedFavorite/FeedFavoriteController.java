package com.green.greengramver3.feedFavorite;

import com.green.greengramver3.common.model.ResultDto;
import com.green.greengramver3.feedFavorite.model.FeedFavoriteToggleReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/feed/favorite")
@RequiredArgsConstructor
@Tag(name = "좋아요 표시", description = "좋아요를 위한 Swagger")
public class FeedFavoriteController {
    private final FeedFavoriteService service;

    @GetMapping
    @Operation(summary = "좋아요", description = "Toggle 처리")
    public ResultDto<Integer> toggleFavorite(@ModelAttribute FeedFavoriteToggleReq p){
        int result = service.toggleFavorite(p);

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(result == 1 ? "좋아요 처리" : "좋아요 취소").
                resultData(result).
                build();
    }
}

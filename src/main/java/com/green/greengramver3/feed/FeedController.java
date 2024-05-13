package com.green.greengramver3.feed;

import com.green.greengramver3.common.model.ResultDto;
import com.green.greengramver3.feed.model.FeedInsReq;
import com.green.greengramver3.feed.model.FeedInsRes;
import com.green.greengramver3.feed.model.*;
import com.green.greengramver3.feed.model.FeedSelRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RequestMapping("api/feed")
@RequiredArgsConstructor
@RestController
@Tag(name = "Feed 등록", description = "Feed CRUD")
public class FeedController {
    private final FeedService service;

    @PostMapping
    @Operation(summary = "Feed 등록")
    public ResultDto<FeedInsRes> insFeed(@RequestPart List<MultipartFile> pics, @RequestPart FeedInsReq p){
        FeedInsRes res = service.insFeed(pics, p);

        return ResultDto.<FeedInsRes>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(res).
                build();

    }
    @GetMapping
    @Operation(summary = "Feed 리스트", description = "loginUserId는 로그인한 사용자의 PK")
    public ResultDto<List<FeedSelRes>> selFeed(@ParameterObject @ModelAttribute FeedSelReq p){
        List<FeedSelRes> list = service.selFeed(p);

        return ResultDto.<List<FeedSelRes>>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(list).build();
    }
}

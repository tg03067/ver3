package com.green.greengramver3.feed.model;

import com.green.greengramver3.feedComment.model.FeedCommentSelRes;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.BindParam;

import java.util.List;

@Data
public class FeedSelRes {
    private long feedId;
    private long writerId;
    private String writerNm;
    private String writerPic;
    private String contents;
    private String location;
    private String createdAt;
    private int isFav;

    private List<String> pics;
    private List<FeedCommentSelRes> comments;
    private int isMoreComment;
}

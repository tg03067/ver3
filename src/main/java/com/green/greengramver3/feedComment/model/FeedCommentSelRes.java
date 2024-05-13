package com.green.greengramver3.feedComment.model;

import lombok.Data;
import org.springframework.web.bind.annotation.DeleteMapping;

@Data
public class FeedCommentSelRes {
    private long feedCommentId;
    private String comment;
    private String createdAt;
    private long writerId;
    private String writerNm;
    private String writerPic;
}

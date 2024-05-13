package com.green.greengramver3.feedComment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FeedCommentInsReq {
    @JsonIgnore
    private long feedCommentId;
    @Schema(example = "1")
    private long feedId;
    @Schema(example = "8")
    private long userId;
    private String comment;
}

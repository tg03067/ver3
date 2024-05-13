package com.green.greengramver3.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class FeedInsReq {
    @JsonIgnore
    private Long feedId;

    private long userId;
    private String contents;
    private String location;
}

package com.green.greengramver3.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class InsUserReq {
    @JsonIgnore
    private Long userId;

    private String uid;
    private String upw;
    private String nm;
    private String pic;
}

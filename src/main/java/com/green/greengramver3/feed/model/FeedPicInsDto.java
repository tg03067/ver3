package com.green.greengramver3.feed.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class FeedPicInsDto {
    private Long feedId;
    @Builder.Default
    private List<String> fileNames = new ArrayList<>();
}

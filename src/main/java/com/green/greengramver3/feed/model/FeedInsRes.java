package com.green.greengramver3.feed.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedInsRes {
    private Long feedId;
    private List<String> pics;
}

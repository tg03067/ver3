package com.green.greengramver3.common.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ResultDto<T> {
    private HttpStatus httpStatus;
    private String resultMsg;
    private T resultData;
}

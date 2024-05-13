package com.green.greengramver3.feed.model;

import com.green.greengramver3.common.GlobalConst;
import com.green.greengramver3.common.model.Paging;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.web.bind.annotation.BindParam;

@Getter
@Setter
public class FeedSelReq extends Paging {
    @Schema(name = "signed_user_id")
    private Long signedUserId;

    public FeedSelReq(Integer page, Integer size,@BindParam("signed_user_id") Long signedUserId){
        super(page, size == null || size == 0 ? 0 : GlobalConst.FEED_PAGING_SIZE);
        this.signedUserId= signedUserId;
    }
}

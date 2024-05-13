package com.green.greengramver3.user;

import com.green.greengramver3.user.model.InsUserReq;
import com.green.greengramver3.user.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(InsUserReq p);
    User selUserById(String uid);
}

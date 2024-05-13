package com.green.greengramver3.user;

import com.green.greengramver3.common.model.ResultDto;
import com.green.greengramver3.user.model.InsUserReq;
import com.green.greengramver3.user.model.SignInPostReq;
import com.green.greengramver3.user.model.SignInRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@RequestMapping("api/user")
@RequiredArgsConstructor
@Tag(name = "유저 컨트롤러", description = "유저 CRUD, sign-up, sign-in")
public class UserController {
    private final UserService service;

    @PostMapping("sign-up")
    @Operation(summary = "회원가입", description = "프로필 사진은 필수가 아닙니다.")
    public ResultDto<Integer> insUser(@RequestPart(required = false) MultipartFile pic,
                                      @RequestPart InsUserReq p){
        log.info("pic: {}", pic);
        log.info("p: {}", p);
        int result = service.insUser(pic, p);

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg("회원가입 성공").
                resultData(result).build();
    }
    @PostMapping("sign-in")
    @Operation(summary = "로그인")
    public ResultDto<SignInRes> selUserById(@RequestBody SignInPostReq p){
        log.info("p: {}", p);
        SignInRes result = service.selUserById(p);

        return ResultDto.<SignInRes>builder().
                httpStatus(HttpStatus.OK).
                resultMsg("로그인 성공").
                resultData(result).build();
    }
}

package com.green.greengramver3.user;

import com.green.greengramver3.common.CustomFileUtils;
import com.green.greengramver3.user.model.InsUserReq;
import com.green.greengramver3.user.model.SignInPostReq;
import com.green.greengramver3.user.model.SignInRes;
import com.green.greengramver3.user.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final CustomFileUtils customFileUtils ;

    public int insUser(MultipartFile pic, InsUserReq p){
        String saveFile = customFileUtils.makeRandomFileName(pic);
        p.setPic(saveFile);
        String hashPassword = BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());
        p.setUpw(hashPassword);

        int result = mapper.insUser(p);
        if(pic.isEmpty()){
            return result;
        }
        try{
            String path = String.format("user/%d", p.getUserId());
            customFileUtils.makeRandomFileName(path);
            String target = String.format("%s%s",path, saveFile);
            customFileUtils.transferTo(pic, target);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("파일오류");
        }
        return result;
    }
    public SignInRes selUserById(SignInPostReq p){
        User user = mapper.selUserById(p.getUid());
        if(Objects.isNull(user)){
            throw new RuntimeException("아이디를 확인해 주세요");
        } else if (!BCrypt.checkpw(p.getUpw(), user.getUpw())){
            throw new RuntimeException("비밀번호를 확인해 주세요");
        }

        return SignInRes.builder().
                userId(user.getUserId()).
                nm(user.getNm()).
                pic(user.getPic()).
                build();
    }
}

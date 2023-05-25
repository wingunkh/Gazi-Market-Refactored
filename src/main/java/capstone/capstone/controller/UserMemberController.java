package capstone.capstone.controller;

import capstone.capstone.domain.Post;
import capstone.capstone.domain.User_Member;
import capstone.capstone.service.UserMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://52.78.130.186")
@RestController
@RequestMapping("/api")
public class UserMemberController {
    @Autowired
    private UserMemberService userMemberService;

    @GetMapping("/user/{user_num}")
    public String showProfileImage(@PathVariable Integer user_num) {
        return userMemberService.showProfileImage(user_num);
    }

    @PostMapping("/user/update")
    public void updateProfileImage(
            @RequestPart(value = "user_num")
            Integer user_num,
            @RequestPart(value = "file")
            List<MultipartFile> file
    ) throws Exception {
        userMemberService.updateProfileImage(user_num, file);
    }

    //유저정보 반환
    @GetMapping("/user/info/{user_num}")
    public User_Member userInfo(@PathVariable Integer user_num){
        return userMemberService.findNum(user_num);
    }

    @GetMapping("/user/info")
    public List<User_Member> allUser(){
        return userMemberService.findAll();
    }
}

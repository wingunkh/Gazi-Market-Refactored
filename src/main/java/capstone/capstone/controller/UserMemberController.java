package capstone.capstone.controller;

import capstone.capstone.domain.Post;
import capstone.capstone.service.UserMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
        userMemberService.showProfileImage(user_num);
        return null;
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
}

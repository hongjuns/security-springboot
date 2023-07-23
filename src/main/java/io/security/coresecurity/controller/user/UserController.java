package io.security.coresecurity.controller.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping(value="/mypage")
    public String mypage(){
        return "user/mypage";
    }
}

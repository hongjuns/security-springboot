package io.security.coresecurity.controller.user;

import org.springframework.web.bind.annotation.GetMapping;

public class MessageController {
    @GetMapping(value="/messages")
    public String mypage() throws Exception {

        return "user/messages";
    }
}

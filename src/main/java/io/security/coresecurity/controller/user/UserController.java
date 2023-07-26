package io.security.coresecurity.controller.user;


import io.security.coresecurity.dto.AccountDto;
import io.security.coresecurity.model.AccountEntity;
import io.security.coresecurity.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping(value="/users")
    public String createUser()  {

        return "user/login/register";
    }

    @PostMapping("/users")
    public String createUser(AccountDto accountDto) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        AccountEntity accountEntity = modelMapper.map(accountDto, AccountEntity.class);
        accountEntity.setPassword(passwordEncoder.encode(accountEntity.getPassword()));

        userService.create(accountEntity);

        return "redirect:/";
    }

    @GetMapping(value="/mypage")
    public String mypage(){
        return "user/mypage";
    }


}

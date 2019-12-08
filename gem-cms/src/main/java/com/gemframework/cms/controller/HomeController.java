package com.gemframework.cms.controller;

import com.gemframework.cms.model.vo.UserVo;
import com.gemframework.cms.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
@Slf4j
public class HomeController {

    @Autowired
    private final UserService userService;

    @GetMapping({"/", "/index", "/home"})
    public String root(){

        log.info("=========主页");
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        log.info("=========自定义登录");
        return "login";
    }

    @GetMapping("/getuser")
    public String ster(){

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User)userDetails;
        log.info(user.getUsername());
        log.info(user.getAuthorities().toString());
        return "register";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(UserVo vo){
        // 此处省略校验逻辑
        userService.add(vo);
        return "redirect:register?success";
    }

}

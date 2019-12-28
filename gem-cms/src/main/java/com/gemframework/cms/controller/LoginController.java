package com.gemframework.cms.controller;

import com.gemframework.cms.common.security.scheme.GemMetadataSourceService;
import com.gemframework.cms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Title: LoginController.java
 * @Package: com.gemframework.gembasic.controller
 * @Date: 2019/11/28 18:03
 * @Version: v1.0
 * @Description: 这里写描述
 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */

@Slf4j
@Controller
public class LoginController {


    @Autowired
    GemMetadataSourceService gemMetadataSourceService;
//
//    @Autowired
//    SessionRegistry sessionRegistry;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/error")
    public String error(Model model){
        model.addAttribute("code","cc");
        return "error";
    }

    @GetMapping("/403")
    public String denied(){
        return "403";
    }

    @GetMapping("/404")
    public String notFound(){
        gemMetadataSourceService.loadResourceDefine();
        return "404";
    }

    @GetMapping({"/index"})
    public String index(){
        return "index";
    }

    @GetMapping({"/home"})
    public String index2(){
        return "home";
    }

    @GetMapping({"/boxed"})
    public String layout(){
        return "layout/boxed";
    }
}

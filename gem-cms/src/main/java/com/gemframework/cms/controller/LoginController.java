package com.gemframework.cms.controller;

import com.gemframework.cms.common.security.scheme.GemMetadataSourceService;
import com.gemframework.cms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Title: UserController.java
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
        log.info("=========自定义登录");
        return "login";
    }

    @GetMapping("/error")
    public String error(){
        return "eroor";
    }

    @GetMapping("/403")
    public String denied(){
        log.info("拒绝访问..");
        return "403";
    }

    @GetMapping("/404")
    public String notFound(){
        gemMetadataSourceService.loadResourceDefine();
        return "404";
    }

    @GetMapping({"/index", "/home"})
    public String index(){
        log.info("=========主页");
        return "index";
    }

}

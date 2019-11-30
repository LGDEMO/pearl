package com.gemframework.admin.controller;

import com.gemframework.admin.model.po.User;
import com.gemframework.admin.model.vo.UserVo;
import com.gemframework.admin.service.UserService;
import com.gemframework.base.common.enums.ResultCode;
import com.gemframework.base.model.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    SessionRegistry sessionRegistry;
    @Autowired
    private UserService userService;

    @GetMapping("home")
    public String index(){
        log.info("登录成功跳转首页");
        return "adminindex";
    }

    @GetMapping("user")
    public String user(){
        log.info("userindex...");
        return "userindex";
    }

    @GetMapping("logout1")
    public void logout(String username) {
        log.info("==================注销登录："+username);
        UserDetails user = userService.loadUserByUsername(username);
        List<SessionInformation> allSessions = sessionRegistry.getAllSessions(user, false);
        if (allSessions != null) {
            for (int i = 0; i < allSessions.size(); i++) {
                SessionInformation sessionInformation = allSessions.get(i);
                sessionInformation.getSessionId();
                sessionInformation.expireNow();
            }
        }
    }

}

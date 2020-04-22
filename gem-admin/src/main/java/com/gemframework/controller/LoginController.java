/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.controller;

import com.gemframework.common.security.authorization.GemMetadataSourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

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

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/500")
    public String error(Model model){
        model.addAttribute("code","999");
        model.addAttribute("msg","系统错误");
        return "error/500";
    }

    @GetMapping("/403")
    public String denied(){
        return "error/403";
    }

    @GetMapping("/404")
    public String notFound(){
        gemMetadataSourceService.loadResourceDefine();
        return "error/404";
    }

    @GetMapping({"/index"})
    public String index(HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        if(principal == null || principal.getName() == null){
            return "login";
        }
        return "index";
    }

    @GetMapping({"/boxed"})
    public String layout(){
        return "layout/boxed";
    }
}

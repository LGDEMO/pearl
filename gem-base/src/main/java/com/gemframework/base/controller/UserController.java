package com.gemframework.base.controller;

import com.gemframework.base.model.BasicResult;
import com.gemframework.base.model.vo.UserVo;
import com.gemframework.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("add")
    public BasicResult add(UserVo vo){
        return BasicResult.SUCCESS(userService.add(vo));
    }

    @GetMapping("update")
    public BasicResult update(UserVo vo){
        return BasicResult.SUCCESS(userService.update(vo));
    }

    @GetMapping("list")
    public BasicResult list(){
        return BasicResult.SUCCESS(userService.findAll());
    }

    @GetMapping("delete/{id}")
    public BasicResult delete(@PathVariable("id") Long id){
        userService.delete(id);
        return BasicResult.SUCCESS();
    }
}

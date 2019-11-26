package com.gemframework.gembasic.controller;

import com.gemframework.gembasic.model.BasicResult;
import com.gemframework.gembasic.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hello",method = {RequestMethod.GET,RequestMethod.POST})
public class HelloController {

    @RequestMapping(value = "haha")
    public String sayHollow(){
        return "hellow java...";
    }

    @RequestMapping("/nihao")
    public String nihao(){
        return "nihao java...";
    }
    @RequestMapping("www")
    public String nihao2(){
        return "加不加“/”都行";
    }

    @RequestMapping("body")
    public BasicResult rbody(){
        return BasicResult.success("xxx");
    }

    @RequestMapping("getUser")
    public BasicResult getUser(){
        User User = com.gemframework.gembasic.model.User.builder().age(18).name("张三2221").build();
        return BasicResult.success(User);
    }

}

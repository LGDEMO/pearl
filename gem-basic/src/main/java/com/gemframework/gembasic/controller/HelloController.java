package com.gemframework.gembasic.controller;

import com.gemframework.gembasic.config.GemConfig;
import com.gemframework.gembasic.enums.ResultCode;
import com.gemframework.gembasic.exception.GemException;
import com.gemframework.gembasic.model.BasicResult;
import com.gemframework.gembasic.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "hello",method = {RequestMethod.GET,RequestMethod.POST})
public class HelloController {

    @Autowired
    private GemConfig gemConfig;

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
        return BasicResult.SUCCESS("xxx");
    }

    @RequestMapping("getUser")
    public BasicResult getUser(){
        User User = com.gemframework.gembasic.model.User.builder().age(18).name("张三2221").build();
        return BasicResult.SUCCESS(User);
    }

    @GetMapping("ex_test")
    public BasicResult exTest(){
        Integer a = 1/0;
        return null;
    }
    @GetMapping("ex_test2/{id}")
    public BasicResult exTest2(@PathVariable Integer id){
        if(id == 1){
            throw new GemException(ResultCode.SUCCESS);
        }
        return null;
    }


    @GetMapping("config_test/{id}")
    public BasicResult conf(@PathVariable Integer id){
        if(id == 1){
            throw new GemException(ResultCode.SUCCESS);
        }
        return BasicResult.SUCCESS(gemConfig.getDesc());
    }
}

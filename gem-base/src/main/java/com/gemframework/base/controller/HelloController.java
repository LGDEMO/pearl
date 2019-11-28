package com.gemframework.base.controller;

import com.gemframework.base.config.GemConfig;
import com.gemframework.base.enums.ResultCode;
import com.gemframework.base.exception.GemException;
import com.gemframework.base.model.BasicResult;
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

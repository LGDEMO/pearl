package com.gemframework.base.controller;

import com.gemframework.base.common.config.GemConfig;
import com.gemframework.base.common.enums.ResultCode;
import com.gemframework.base.common.exception.GemException;
import com.gemframework.base.model.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @Title: HelloController.java
 * @Package: com.gemframework.base.controller
 * @Date: 2019/11/30 15:49
 * @Version: v1.0
 * @Description: 学习第一步

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
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
    public BaseResult rbody(){
        return BaseResult.SUCCESS("xxx");
    }

    @GetMapping("ex_test")
    public BaseResult exTest(){
        Integer a = 1/0;
        return null;
    }
    @GetMapping("ex_test2/{id}")
    public BaseResult exTest2(@PathVariable Integer id){
        if(id == 1){
            throw new GemException(ResultCode.SUCCESS);
        }
        return null;
    }


    @GetMapping("config_test/{id}")
    public BaseResult conf(@PathVariable Integer id){
        if(id == 1){
            throw new GemException(ResultCode.SUCCESS);
        }
        return BaseResult.SUCCESS(gemConfig.getDesc());
    }

}

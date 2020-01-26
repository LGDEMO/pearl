package com.gemframework.cms.controller;

import com.gemframework.bas.model.BaseResult;
import com.gemframework.cms.common.utils.GemRedisUtils;
import com.gemframework.cms.model.po.User;
import com.gemframework.cms.service.CacheService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Title: IndexController.java
 * @Package: com.gemframework.gembasic.controller
 * @Date: 2019/11/28 18:03
 * @Version: v1.0
 * @Description: 页面控制器
 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */

@Slf4j
@Controller
@RequestMapping("demo")
@Api("示例管理接口")
public class DemoController {

    @Autowired
    private GemRedisUtils<String> gemRedisUtils;

    @GetMapping("/redis/index")
    @ApiOperation("redis示例页面")
    public String redis(Model model){
        return "demo/redis.html";
    }

    @GetMapping("/redis/get")
    public BaseResult get(String key){
        String val = gemRedisUtils.get(key);
        return BaseResult.SUCCESS(val);
    }

}

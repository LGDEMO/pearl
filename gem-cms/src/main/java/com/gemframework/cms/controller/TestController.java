package com.gemframework.cms.controller;

import com.gemframework.bas.model.BaseResult;
import com.gemframework.cms.common.utils.GemRedisUtils;
import com.gemframework.cms.model.po.User;
import com.gemframework.cms.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("test")
public class TestController {

    @Resource
    CacheService cacheService;

    @Autowired
    private GemRedisUtils<String> gemRedisUtils;

    @GetMapping("/redis/set")
    public BaseResult set(String key,String val){
        gemRedisUtils.set(key,val);
        gemRedisUtils.expire(key,10, TimeUnit.SECONDS);
        return BaseResult.SUCCESS(key+":"+val);
    }

    @GetMapping("/redis/get")
    public BaseResult get(String key){
        String val = gemRedisUtils.get(key);
        return BaseResult.SUCCESS(val);
    }

    @GetMapping("/cache/getUser")
    public BaseResult getUser(Long id){
        User user = cacheService.getById(id);
        return BaseResult.SUCCESS(user);
    }

}

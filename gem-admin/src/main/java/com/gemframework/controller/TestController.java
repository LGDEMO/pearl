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

import com.gemframework.common.utils.GemRedisUtils;
import com.gemframework.model.BaseResultData;
import com.gemframework.model.po.User;
import com.gemframework.service.CacheService;
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
    public BaseResultData set(String key, String val){
        gemRedisUtils.set(key,val);
        gemRedisUtils.expire(key,10, TimeUnit.SECONDS);
        return BaseResultData.SUCCESS(key+":"+val);
    }

    @GetMapping("/redis/get")
    public BaseResultData get(String key){
        String val = gemRedisUtils.get(key);
        return BaseResultData.SUCCESS(val);
    }

    @GetMapping("/cache/getUser")
    public BaseResultData getUser(Long id){
        User user = cacheService.getById(id);
        return BaseResultData.SUCCESS(user);
    }

}

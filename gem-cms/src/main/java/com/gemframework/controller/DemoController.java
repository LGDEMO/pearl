package com.gemframework.controller;

import com.gemframework.common.enums.ResultCode;
import com.gemframework.model.BaseResult;
import com.gemframework.common.config.GemSystemProperties;
import com.gemframework.common.utils.GemRedisUtils;
import com.gemframework.model.vo.response.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    @Autowired
    private GemSystemProperties gemSystemProperties;

    @GetMapping("/pages/redis")
    @ApiOperation("redis示例页面")
    public String redis(Model model){
        return "demo/redis.html";
    }

    @GetMapping("/pages/pageStyle")
    public String pagestyle(Model model){
        return "demo/pagestyle";
    }

    @GetMapping("/redis/get")
    @ResponseBody
    public BaseResult get(String key){
        String val = gemRedisUtils.get(key);
        return BaseResult.SUCCESS(val);
    }

    @GetMapping("/redis/set")
    @ResponseBody
    public BaseResult set(String key,String val){
        gemRedisUtils.set(key,val);
        return BaseResult.SUCCESS(key+"="+val);
    }

    @GetMapping("/BB")
    @ResponseBody
    public BaseResult BB(){
        return BaseResult.SUCCESS(gemSystemProperties);
    }


}

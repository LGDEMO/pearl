package com.gemframework.controller;

import com.gemframework.common.enums.ResultCode;
import com.gemframework.model.BaseResult;
import com.gemframework.common.config.GemSystemProperties;
import com.gemframework.common.utils.GemRedisUtils;
import com.gemframework.model.vo.DemoVo;
import com.gemframework.service.DemoService;
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

    @Autowired
    private DemoService demoService;

    @GetMapping("/redis/index")
    @ApiOperation("redis示例页面")
    public String redis(Model model){
        return "demo/redis.html";
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



    @GetMapping("list.html")
    public String list(Model model){
        return "demo/list";
    }

    @GetMapping("pageByParams")
    @ResponseBody
    public BaseResult pageByParams(DemoVo vo, Pageable pageable){
//        PageInfo<DemoVo> pageInfo =  demoService.findPageByParams(vo,pageable);
        List<DemoVo> list =  demoService.findPageByParams(vo,pageable);
        return BaseResult.SUCCESS(list);
    }

    @GetMapping("add.html")
    public String add(Model model){
        return "demo/add";
    }


    @GetMapping("edit.html")
    public String edit(Model model, Long id){
        DemoVo vo = demoService.getById(id);
        model.addAttribute("editInfo",vo);
        return "demo/edit";
    }

    @PostMapping("add")
    @ResponseBody
    public BaseResult add(@Valid @RequestBody DemoVo vo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return BaseResult.ERROR(ResultCode.PARAM_EXCEPTION.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        return BaseResult.SUCCESS(demoService.save(vo));
    }

    @PostMapping("delete/{id}")
    @ResponseBody
    public BaseResult delete(@PathVariable("id") Long id){
        demoService.delete(id);
        return BaseResult.SUCCESS();
    }

    @PostMapping("deleteBatch")
    @ResponseBody
    public BaseResult deleteBatch(@RequestBody List<DemoVo> vos){
        demoService.deleteBatch(vos);
        return BaseResult.SUCCESS();
    }

    @GetMapping("getOne")
    @ResponseBody
    public BaseResult get(Long id){
        return BaseResult.SUCCESS(demoService.getById(id));
    }

}

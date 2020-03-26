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

import com.gemframework.common.enums.ResultCode;
import com.gemframework.model.BaseResultData;
import com.gemframework.model.vo.SysLogVo;
import com.gemframework.model.vo.response.PageInfo;
import com.gemframework.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


/**
 * @Title: SysLogController.java
 * @Package: com.gemframework.controller
 * @Date: 2020-02-13 20:46:35
 * @Version: v1.0
 * @Description: 这里写描述
 * @Author: gemteam
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */

@Slf4j
@Controller
@RequestMapping("sysLog")
public class SysLogController {

    @Resource
    SysLogService sysLogService;

    @GetMapping("list.html")
    public String list(HttpServletRequest request, Model model){
        sysLogService.findListAll();
        return "sysLog/list";
    }

    @GetMapping("add.html")
    public String add(HttpServletRequest request,Model model){
        return "sysLog/add";
    }


    @GetMapping("edit.html")
    public String edit(HttpServletRequest request,Model model, Long id){
        SysLogVo vo = sysLogService.getById(id);
        model.addAttribute("editInfo",vo);
        return "sysLog/edit";
    }

    @GetMapping("pageByParams")
    @ResponseBody
    public BaseResultData pageByParams(SysLogVo vo, Pageable pageable){
        PageInfo pageInfo =  sysLogService.findPageByParams(vo,pageable);
        return BaseResultData.SUCCESS(pageInfo);
    }

    @PostMapping("add")
    @ResponseBody
    public BaseResultData add(@Valid @RequestBody SysLogVo vo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return BaseResultData.ERROR(ResultCode.PARAM_EXCEPTION.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        return BaseResultData.SUCCESS(sysLogService.save(vo));
    }

    @PostMapping("delete")
    @ResponseBody
    public BaseResultData delete(Long id){
        sysLogService.delete(id);
        return BaseResultData.SUCCESS();
    }

    @PostMapping("deleteBatch")
    @ResponseBody
    public BaseResultData deleteBatch(@RequestBody List<SysLogVo> vos){
        sysLogService.deleteBatch(vos);
        return BaseResultData.SUCCESS();
    }

    @GetMapping("getOne")
    @ResponseBody
    public BaseResultData get(Long id){
        return BaseResultData.SUCCESS(sysLogService.getById(id));
    }
}

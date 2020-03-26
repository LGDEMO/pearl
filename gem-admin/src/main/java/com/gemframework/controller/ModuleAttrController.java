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
import com.gemframework.model.vo.ModuleAttrVo;
import com.gemframework.model.vo.response.PageInfo;
import com.gemframework.service.ModuleAttrService;
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
 * @Title: ModuleAttrController.java
 * @Package: com.gemframework.controller
 * @Date: 2020-01-29 18:16:21
 * @Version: v1.0
 * @Description: 这里写描述
 * @Author: zhangys
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */

@Slf4j
@Controller
@RequestMapping("moduleAttr")
public class ModuleAttrController {

    @Resource
    ModuleAttrService moduleAttrService;

    @GetMapping("list.html")
    public String list(HttpServletRequest request,Model model){
        String moduleId = request.getParameter("moduleId");
        model.addAttribute("moduleId",moduleId);
        return "moduleAttr/list";
    }

    @GetMapping("pageByParams")
    @ResponseBody
    public BaseResultData pageByParams(ModuleAttrVo vo, Pageable pageable){
        PageInfo info =  moduleAttrService.findPageByParams(vo,pageable);
        return BaseResultData.SUCCESS(info);
    }

    @GetMapping("add.html")
    public String add(HttpServletRequest request,Model model){
        String moduleId = request.getParameter("moduleId");
        model.addAttribute("moduleId",moduleId);
        return "moduleAttr/add";
    }


    @GetMapping("edit.html")
    public String edit(Model model, Long id){
        ModuleAttrVo vo = moduleAttrService.getById(id);
        model.addAttribute("editInfo",vo);
        return "moduleAttr/edit";
    }

    @PostMapping("add")
    @ResponseBody
    public BaseResultData add(@Valid @RequestBody ModuleAttrVo vo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return BaseResultData.ERROR(ResultCode.PARAM_EXCEPTION.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        return BaseResultData.SUCCESS(moduleAttrService.save(vo));
    }

    @PostMapping("delete")
    @ResponseBody
    public BaseResultData delete(Long id){
        moduleAttrService.delete(id);
        return BaseResultData.SUCCESS();
    }

    @PostMapping("deleteBatch")
    @ResponseBody
    public BaseResultData deleteBatch(@RequestBody List<ModuleAttrVo> vos){
        moduleAttrService.deleteBatch(vos);
        return BaseResultData.SUCCESS();
    }

    @GetMapping("getOne")
    @ResponseBody
    public BaseResultData get(Long id){
        return BaseResultData.SUCCESS(moduleAttrService.getById(id));
    }



}

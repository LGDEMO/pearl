package com.gemframework.cms.controller;

import com.gemframework.bas.common.enums.ResultCode;
import com.gemframework.bas.model.BaseResult;
import com.gemframework.cms.model.vo.ModuleAttrVo;
import com.gemframework.cms.service.ModuleAttrService;
import io.swagger.annotations.Api;
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
 * @Package: com.gemframework.cms.controller
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
    public BaseResult pageByParams(ModuleAttrVo vo, Pageable pageable){
        List<ModuleAttrVo> list =  moduleAttrService.findPageByParams(vo,pageable);
        return BaseResult.SUCCESS(list);
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
    public BaseResult add(@Valid @RequestBody ModuleAttrVo vo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return BaseResult.ERROR(ResultCode.PARAM_EXCEPTION.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        return BaseResult.SUCCESS(moduleAttrService.save(vo));
    }

    @PostMapping("delete")
    @ResponseBody
    public BaseResult delete(Long id){
        moduleAttrService.delete(id);
        return BaseResult.SUCCESS();
    }

    @PostMapping("deleteBatch")
    @ResponseBody
    public BaseResult deleteBatch(@RequestBody List<ModuleAttrVo> vos){
        moduleAttrService.deleteBatch(vos);
        return BaseResult.SUCCESS();
    }

    @GetMapping("getOne")
    @ResponseBody
    public BaseResult get(Long id){
        return BaseResult.SUCCESS(moduleAttrService.getById(id));
    }



}

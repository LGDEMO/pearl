package com.gemframework.controller;

import com.gemframework.common.enums.ResultCode;
import com.gemframework.model.BaseResult;
import com.gemframework.model.vo.ModuleVo;
import com.gemframework.service.CodeService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
@RequestMapping("generate/code")
@Api("代码生成器")
public class CodeController {

    @Resource
    private CodeService codeService;

    @GetMapping("list.html")
    public String list(Model model){
        return "code/list";
    }

    @GetMapping("pageByParams")
    @ResponseBody
    public BaseResult pageByParams(ModuleVo vo, Pageable pageable){
        List<ModuleVo> list =  codeService.findPageByParams(vo,pageable);
        return BaseResult.SUCCESS(list);
    }

    @GetMapping("add.html")
    public String add(Model model){
        return "code/add";
    }


    @GetMapping("edit.html")
    public String edit(Model model, Long id){
        ModuleVo vo = codeService.getById(id);
        model.addAttribute("editInfo",vo);
        return "code/edit";
    }

    @PostMapping("add")
    @ResponseBody
    public BaseResult add(@Valid @RequestBody ModuleVo vo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return BaseResult.ERROR(ResultCode.PARAM_EXCEPTION.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        return BaseResult.SUCCESS(codeService.save(vo));
    }

    @PostMapping("delete")
    @ResponseBody
    public BaseResult delete(Long id){
        codeService.delete(id);
        return BaseResult.SUCCESS();
    }

    @PostMapping("deleteBatch")
    @ResponseBody
    public BaseResult deleteBatch(@RequestBody List<ModuleVo> vos){
        codeService.deleteBatch(vos);
        return BaseResult.SUCCESS();
    }

    @GetMapping("getOne")
    @ResponseBody
    public BaseResult get(Long id){
        return BaseResult.SUCCESS(codeService.getById(id));
    }


//创建实体
    /***
     * 包名：com.gemframe.demo.xxx
     * 实体名称 Demo demo  DemoVo demoVo
     * 属性名称 id,name...
     * 是否自增
     * 属性长度
     * 是否必填
     * 是否列表显示
     * 支持方法：增、删、改、查
     *
     */

}

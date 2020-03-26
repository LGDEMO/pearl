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
import com.gemframework.model.vo.DeptVo;
import com.gemframework.model.vo.response.PageInfo;
import com.gemframework.service.DeptService;
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
 * @Title: DeptController.java
 * @Package: com.gemframework.controller
 * @Date: 2019-12-05 22:22:32
 * @Version: v1.0
 * @Description: 这里写描述
 * @Author: zhangys
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */

@Slf4j
@Controller
@RequestMapping("dept")
public class DeptController {

    @Autowired
    DeptService deptService;

    /**
     * @Title:  add
     * @MethodName:  增
     * @Param: [vo, bindingResult]
     * @Retrun: com.gemframework.model.BaseResult
     * @Description:
     * @Date: 2019-12-05 22:22:32
     */
    @PostMapping("add")
    @ResponseBody
    public BaseResultData add(@Valid @RequestBody DeptVo vo, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return BaseResultData.ERROR(ResultCode.PARAM_EXCEPTION.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }

        return BaseResultData.SUCCESS(deptService.save(vo));
    }

    /**
     * @Title:  delete
     * @MethodName:  删
     * @Param: [id]
     * @Retrun: com.gemframework.model.BaseResult
     * @Description:
     * @Date: 2019-12-05 22:22:32
     */
    @PostMapping("delete/{id}")
    @ResponseBody
    public BaseResultData delete(@PathVariable("id") Long id){
        deptService.delete(id);
        return BaseResultData.SUCCESS();
    }

    /**
     * @Title:  查询单个
     * @MethodName:  查询
     * @Param: [vo]
     * @Retrun: com.gemframework.model.BaseResult
     * @Description:
     * @Date: 2019-12-05 22:22:32
     */
    @GetMapping("getOne")
    @ResponseBody
    public BaseResultData get(Long id){
        return BaseResultData.SUCCESS(deptService.getById(id));
    }

    /**
     * @Title:  list
     * @MethodName:  查-list
     * @Param: []
     * @Retrun: com.gemframework.model.BaseResult
     * @Description:
     * @Date: 2019-12-05 22:22:32
     */
    @GetMapping("list")
    @ResponseBody
    public BaseResultData list(){
        List list = deptService.findListAll();
        return BaseResultData.SUCCESS(list);
    }


    /**
     * @Title:  listByParams
     * @MethodName:  listByParams
     * @Param: [vo]
     * @Retrun: com.gemframework.model.BaseResult
     * @Description:
     * @Date: 2019-12-05 22:22:32
     */
    @GetMapping("listByParams")
    @ResponseBody
    public BaseResultData listByParams(DeptVo vo){
        List<DeptVo> list = deptService.findListByParams(vo);
        return BaseResultData.SUCCESS(list);
    }


    /**
     * @Title:  pageByParams
     * @MethodName:  pageByParams
     * @Param: [vo, pageable]
     * @Retrun: com.gemframework.model.BaseResult
     * @Description: 【分页】根据条件动态查询
     * @Date: 2019-12-05 22:22:32
     */
    @GetMapping("pageByParams")
    @ResponseBody
    public BaseResultData pageByParams(DeptVo vo, Pageable pageable){
        PageInfo page =  deptService.findPageByParams(vo,pageable);
        return BaseResultData.SUCCESS(page);
    }


    @GetMapping("list.html")
    public String list(Model model){
        List<DeptVo> list = deptService.findListAll();
        model.addAttribute("list_depts",list);
        return "dept/list";
    }
}

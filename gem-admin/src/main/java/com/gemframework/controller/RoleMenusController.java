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
import com.gemframework.model.vo.RoleMenusVo;
import com.gemframework.model.vo.response.PageInfo;
import com.gemframework.service.RoleMenusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Title: RoleMenusController.java
 * @Package: com.gemframework.controller
 * @Date: 2019-12-05 22:22:33
 * @Version: v1.0
 * @Description: 这里写描述
 * @Author: zhangys
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */

@Slf4j
@RestController
@RequestMapping("roleMenus")
public class RoleMenusController {

    @Autowired
    RoleMenusService roleMenusService;

    /**
     * @Title:  add
     * @MethodName:  增
     * @Param: [vo, bindingResult]
     * @Retrun: com.gemframework.model.BaseResult
     * @Description:
     * @Date: 2019-12-05 22:22:33
     */
    @PostMapping("add")
    public BaseResultData add(@Valid @RequestBody RoleMenusVo vo, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return BaseResultData.ERROR(ResultCode.PARAM_EXCEPTION.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }

        return BaseResultData.SUCCESS(roleMenusService.save(vo));
    }

    /**
     * @Title:  delete
     * @MethodName:  删
     * @Param: [id]
     * @Retrun: com.gemframework.model.BaseResult
     * @Description:
     * @Date: 2019-12-05 22:22:33
     */
    @PostMapping("delete/{id}")
    public BaseResultData delete(@PathVariable("id") Long id){
        roleMenusService.delete(id);
        return BaseResultData.SUCCESS();
    }


    /**
     * @Title:  list
     * @MethodName:  查-list
     * @Param: []
     * @Retrun: com.gemframework.model.BaseResult
     * @Description:
     * @Date: 2019-12-05 22:22:33
     */
    @GetMapping("list")
    public BaseResultData list(){
        List list = roleMenusService.findListAll();
        return BaseResultData.SUCCESS(list);
    }


    /**
     * @Title:  listByParams
     * @MethodName:  listByParams
     * @Param: [vo]
     * @Retrun: com.gemframework.model.BaseResult
     * @Description:
     * @Date: 2019-12-05 22:22:33
     */
    @GetMapping("listByParams")
    public BaseResultData listByParams(RoleMenusVo vo){
        List<RoleMenusVo> list = roleMenusService.findListByParams(vo);
        return BaseResultData.SUCCESS(list);
    }


    /**
     * @Title:  pageByParams
     * @MethodName:  pageByParams
     * @Param: [vo, pageable]
     * @Retrun: com.gemframework.model.BaseResult
     * @Description: 【分页】根据条件动态查询
     * @Date: 2019-12-05 22:22:33
     */
    @GetMapping("pageByParams")
    public BaseResultData pageByParams(RoleMenusVo vo, Pageable pageable){
        PageInfo page =  roleMenusService.findPageByParams(vo,pageable);
        return BaseResultData.SUCCESS(page);
    }

}

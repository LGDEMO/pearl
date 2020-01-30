package com.gemframework.cms.controller;

import com.gemframework.bas.common.enums.ResultCode;
import com.gemframework.bas.model.BaseResult;
import com.gemframework.cms.model.vo.RoleVo;
import com.gemframework.cms.model.vo.UserVo;
import com.gemframework.cms.model.vo.response.PageInfo;
import com.gemframework.cms.service.RoleService;
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
 * @Title: RoleController.java
 * @Package: com.gemframework.cms.controller
 * @Date: 2019-12-05 22:22:32
 * @Version: v1.0
 * @Description: 这里写描述
 * @Author: zhangys
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */

@Slf4j
@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * @Title:  add
     * @MethodName:  增
     * @Param: [vo, bindingResult]
     * @Retrun: com.gemframework.bas.model.BaseResult
     * @Description:
     * @Date: 2019-12-05 22:22:32
     */
    @PostMapping("add")
    @ResponseBody
    public BaseResult add(@Valid @RequestBody RoleVo vo, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return BaseResult.ERROR(ResultCode.PARAM_EXCEPTION.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }

        return BaseResult.SUCCESS(roleService.save(vo));
    }

    /**
     * @Title:  delete
     * @MethodName:  删
     * @Param: [id]
     * @Retrun: com.gemframework.bas.model.BaseResult
     * @Description:
     * @Date: 2019-12-05 22:22:32
     */
    @PostMapping("delete")
    @ResponseBody
    public BaseResult delete(Long id){
        roleService.delete(id);
        return BaseResult.SUCCESS();
    }

    /**
     * @Title:  deleteAll
     * @MethodName:  删-全部
     * @Param: [id]
     * @Retrun: com.gemframework.bas.model.BaseResult
     * @Description:
     * @Date: 2019/11/29 16:18
     */
    @PostMapping("deleteBatch")
    @ResponseBody
    public BaseResult deleteBatch(@RequestBody List<UserVo> vos){
        roleService.deleteBatch(vos);
        return BaseResult.SUCCESS();
    }


    /**
     * @Title:  list
     * @MethodName:  查-list
     * @Param: []
     * @Retrun: com.gemframework.bas.model.BaseResult
     * @Description:
     * @Date: 2019-12-05 22:22:32
     */
    @GetMapping("list")
    @ResponseBody
    public BaseResult list(){
        List list = roleService.findListAll();
        return BaseResult.SUCCESS(list);
    }


    /**
     * @Title:  listByParams
     * @MethodName:  listByParams
     * @Param: [vo]
     * @Retrun: com.gemframework.bas.model.BaseResult
     * @Description:
     * @Date: 2019-12-05 22:22:32
     */
    @GetMapping("listByParams")
    @ResponseBody
    public BaseResult listByParams(RoleVo vo){
        List<RoleVo> list = roleService.findListByParams(vo);
        return BaseResult.SUCCESS(list);
    }

    /**
     * @Title:  page
     * @MethodName:  page
     * @Param: [pageable]
     * @Retrun: com.gemframework.bas.model.BaseResult
     * @Description:
     * page ：第几页，从0开始，默认为第0页
     * size ：每一页的大小，默认为10
     * sort ：排序相关的信息，以`property[,ASC|DESC]`的方式组织，例如`sort=firstname&sort=lastname,desc`表示在按firstname正序排列基础上按lastname倒序排列。
     * @SortDefault.SortDefaults({@SortDefault(sort = "userName", direction = Sort.Direction.DESC),
     *             @SortDefault(sort = "id", direction = Sort.Direction.ASC)})
     * @PageableDefault(page = 0, size = 2)
     * @Date: 2019-12-05 22:22:32
     */
    @GetMapping("page")
    @ResponseBody
    public BaseResult page(Pageable pageable){
        List<RoleVo> vo = roleService.findPageAll(pageable);
        return BaseResult.SUCCESS(vo);
    }

    /**
     * @Title:  pageByParams
     * @MethodName:  pageByParams
     * @Param: [vo, pageable]
     * @Retrun: com.gemframework.bas.model.BaseResult
     * @Description: 【分页】根据条件动态查询
     * @Date: 2019-12-05 22:22:32
     */
    @GetMapping("pageByParams")
    @ResponseBody
    public BaseResult pageByParams(RoleVo vo,Pageable pageable){

        PageInfo<RoleVo> page =  roleService.findPageByParams(vo,pageable);
        return BaseResult.SUCCESS(page);
    }


    @GetMapping("list.html")
    public String list(Model model){
        return "role/list";
    }

    @GetMapping("add.html")
    public String add(Model model){
        return "role/add";
    }

    @GetMapping("edit.html")
    public String edit(Model model, Long id){
        RoleVo roleVo = roleService.getById(id);
        model.addAttribute("edit_role",roleVo);
        return "role/edit";
    }
}

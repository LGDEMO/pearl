package com.gemframework.bas.controller;

import com.gemframework.bas.common.enums.ResultCode;
import com.gemframework.bas.model.BaseResult;
import com.gemframework.bas.model.po.User;
import com.gemframework.bas.model.vo.UserVo;
import com.gemframework.bas.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Title: UserController.java
 * @Package: com.gemframework.bas.controller
 * @Date: 2019/11/28 18:03
 * @Version: v1.0
 * @Description: 这里写描述
 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * @Title:  add
     * @MethodName:  增
     * @Param: [vo, bindingResult]
     * @Retrun: com.gemframework.bas.model.BaseResult
     * @Description:
     * @Date: 2019/11/29 16:17
     */
    @PostMapping("add")
    public BaseResult add(@Valid @RequestBody UserVo vo, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return BaseResult.ERROR(ResultCode.PARAM_EXCEPTION.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }

        return BaseResult.SUCCESS(userService.add(vo));
    }

    /**
     * @Title:  delete
     * @MethodName:  删
     * @Param: [id]
     * @Retrun: com.gemframework.bas.model.BaseResult
     * @Description:
     * @Date: 2019/11/29 16:18
     */
    @PostMapping("delete/{id}")
    public BaseResult delete(@PathVariable("id") Long id){
        userService.delete(id);
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
    @PostMapping("deleteAll")
    public BaseResult deleteAll(){
        userService.deleteAll();
        return BaseResult.SUCCESS();
    }

    /**
     * @Title:  update
     * @MethodName:  改
     * @Param: [vo]
     * @Retrun: com.gemframework.bas.model.BaseResult
     * @Description:
     * @Date: 2019/11/29 16:17
     */
    @PostMapping("update")
    public BaseResult update(UserVo vo){
        return BaseResult.SUCCESS(userService.update(vo));
    }

    /**
     * @Title:  list
     * @MethodName:  查-list
     * @Param: []
     * @Retrun: com.gemframework.bas.model.BaseResult
     * @Description:
     * @Date: 2019/11/29 16:18
     */
    @GetMapping("list")
    public BaseResult list(){
        List list = userService.findListAll();
        return BaseResult.SUCCESS(list);
    }

    /**
     * @Title:  listByParams
     * @MethodName:  listByParams
     * @Param: [vo]
     * @Retrun: com.gemframework.bas.model.BaseResult
     * @Description:
     * @Date: 2019/11/29 21:19
     */
    @GetMapping("listByParams")
    public BaseResult listByParams(UserVo vo){
        List list = userService.findListByParams(vo);
        return BaseResult.SUCCESS(null);
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
     * @Date: 2019/11/29 16:38
     */
    @GetMapping("page")
    public BaseResult page(Pageable pageable){
        Page<User> page =  userService.findPageAll(pageable);
        List list = page.getContent();
        return BaseResult.SUCCESS(list);
    }

    /**
     * @Title:  pageByParams
     * @MethodName:  pageByParams
     * @Param: [vo, pageable]
     * @Retrun: com.gemframework.bas.model.BaseResult
     * @Description: 【分页】根据条件动态查询
     * @Date: 2019/11/29 21:21
     */
    @GetMapping("pageByParams")
    public BaseResult pageByParams(UserVo vo,Pageable pageable){
        Page<User> page =  userService.findPageByParams(vo,pageable);
        List list = page.getContent();
        return BaseResult.SUCCESS(list);
    }

}

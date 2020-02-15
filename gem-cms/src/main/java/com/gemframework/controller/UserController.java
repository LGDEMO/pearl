package com.gemframework.controller;

import com.gemframework.model.po.User;
import com.gemframework.model.vo.UserVo;
import com.gemframework.model.vo.request.ResetPasswordReq;
import com.gemframework.model.vo.response.PageInfo;
import com.gemframework.service.UserService;
import com.gemframework.common.enums.ResultCode;
import com.gemframework.model.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Title: UserController.java
 * @Package: com.gemframework.gembasic.controller
 * @Date: 2019/11/28 18:03
 * @Version: v1.0
 * @Description: 这里写描述
 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */

@Slf4j
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * @Title:  add
     * @MethodName:  增
     * @Param: [vo, bindingResult]
     * @Retrun: com.gemframework.model.BaseResult
     * @Description:
     * @Date: 2019/11/29 16:17
     */
    @PostMapping("add")
    @ResponseBody
    public BaseResult add(@Valid @RequestBody UserVo vo, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return BaseResult.ERROR(ResultCode.PARAM_EXCEPTION.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        vo = userService.save(vo);
        return BaseResult.SUCCESS(vo);
    }

    /**
     * @Title:  delete
     * @MethodName:  删
     * @Param: [id]
     * @Retrun: com.gemframework.model.BaseResult
     * @Description:
     * @Date: 2019/11/29 16:18
     */
    @PostMapping("delete/{id}")
    @ResponseBody
    public BaseResult delete(@PathVariable("id") Long id){
        userService.delete(id);
        return BaseResult.SUCCESS();
    }

    /**
     * @Title:  deleteAll
     * @MethodName:  删-全部
     * @Param: [id]
     * @Retrun: com.gemframework.model.BaseResult
     * @Description:
     * @Date: 2019/11/29 16:18
     */
    @PostMapping("deleteBatch")
    @ResponseBody
    public BaseResult deleteBatch(@RequestBody List<UserVo> vos){
        userService.deleteBatch(vos);
        return BaseResult.SUCCESS();
    }

    /**
     * @Title:  deleteAll
     * @MethodName:  删-全部
     * @Param: [id]
     * @Retrun: com.gemframework.model.BaseResult
     * @Description:
     * @Date: 2019/11/29 16:18
     */
    @PostMapping("deleteAll")
    @ResponseBody
    public BaseResult deleteAll(){
        userService.deleteAll();
        return BaseResult.SUCCESS();
    }

    /**
     * @Title:  update
     * @MethodName:  改
     * @Param: [vo]
     * @Retrun: com.gemframework.model.BaseResult
     * @Description:
     * @Date: 2019/11/29 16:17
     */
    @PostMapping("edit")
    @ResponseBody
    public BaseResult edit(@Valid @RequestBody UserVo vo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return BaseResult.ERROR(ResultCode.PARAM_EXCEPTION.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        return BaseResult.SUCCESS(userService.save(vo));
    }

    /**
     * @Title:  resetPassword
     * @MethodName:  修改密码
     * @Param: [vo]
     * @Retrun: com.gemframework.model.BaseResult
     * @Description:
     * @Date: 2019/11/29 16:17
     */
    @PostMapping("resetPassword")
    @ResponseBody
    public BaseResult resetPassword(@RequestBody ResetPasswordReq req){
        UserVo vo = new UserVo();
        vo.setId(req.getId());
        vo.setPassword(req.getNewPass());
        return BaseResult.SUCCESS(userService.save(vo));
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
    public BaseResult get(Long id){
        return BaseResult.SUCCESS(userService.getById(id));
    }


    /**
     * @Title:  list
     * @MethodName:  查-list
     * @Param: []
     * @Retrun: com.gemframework.model.BaseResult
     * @Description:
     * @Date: 2019/11/29 16:18
     */
    @GetMapping("list")
    @ResponseBody
    public BaseResult list(){
        List list = userService.findListAll();
        return BaseResult.SUCCESS(list);
    }

    /**
     * @Title:  listByParams
     * @MethodName:  listByParams
     * @Param: [vo]
     * @Retrun: com.gemframework.model.BaseResult
     * @Description:
     * @Date: 2019/11/29 21:19
     */
    @GetMapping("listByParams")
    @ResponseBody
    public BaseResult listByParams(UserVo vo){
        List list = userService.findListByParams(vo);
        return BaseResult.SUCCESS(null);
    }

    /**
     * @Title:  page
     * @MethodName:  page
     * @Param: [pageable]
     * @Retrun: com.gemframework.model.BaseResult
     * @Description:
     * page ：第几页，从0开始，默认为第0页
     * size ：每一页的大小，默认为10
     * sort ：排序相关的信息，以`property[,ASC|DESC]`的方式组织，例如`sort=firstname&sort=lastname,desc`表示在按firstname正序排列基础上按lastname倒序排列。
     * @SortDefault.SortDefaults({@SortDefault(sort = "userName", direction = Sort.Direction.DESC),
     *             @SortDefault(sort = "id", direction = Sort.Direction.ASC)})
     * @PageableDefault(page = 0, size = 2)
     * @Date: 2019/11/29 16:38
     */
    @GetMapping("/page")
    @ResponseBody
    public BaseResult page(Pageable pageable){
        Page<User> page =  userService.findPageAll(pageable);
        List list = page.getContent();
        return BaseResult.SUCCESS(list);
    }

    /**
     * @Title:  pageByParams
     * @MethodName:  pageByParams
     * @Param: [vo, pageable]
     * @Retrun: com.gemframework.model.BaseResult
     * @Description: 【分页】根据条件动态查询
     * @Date: 2019/11/29 21:21
     */
    @GetMapping("pageByParams")
    @ResponseBody
    public BaseResult pageByParams(UserVo vo,Pageable pageable){
        PageInfo page =  userService.findPageByParams(vo,pageable);
        return BaseResult.SUCCESS(page);

    }


    @GetMapping("list.html")
    public String list(Model model){
        return "user/list";
    }

    @GetMapping("add.html")
    public String add(Model model){
        return "user/add";
    }

    @GetMapping("edit.html")
    public String edit(Model model, Long id){
        UserVo userVo = userService.getById(id);
        model.addAttribute("edit_user",userVo);
        return "user/edit";
    }

}
package com.gemframework.cms.controller;

import com.gemframework.bas.common.enums.ResultCode;
import com.gemframework.bas.model.BaseResult;
import com.gemframework.cms.model.vo.MenuVo;
import com.gemframework.cms.service.MenuService;
import com.gemframework.cms.service.impl.MenuServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @Title: MenuController.java
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
@RequestMapping("menu")
public class MenuController {

    @Autowired
    MenuService menuService;

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
    public BaseResult add(@Valid @RequestBody MenuVo vo, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return BaseResult.ERROR(ResultCode.PARAM_EXCEPTION.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }

        return BaseResult.SUCCESS(menuService.add(vo));
    }

    /**
     * @Title:  delete
     * @MethodName:  删
     * @Param: [id]
     * @Retrun: com.gemframework.bas.model.BaseResult
     * @Description:
     * @Date: 2019-12-05 22:22:32
     */
    @PostMapping("delete/{id}")
    public BaseResult delete(@PathVariable("id") Long id){
        menuService.delete(id);
        return BaseResult.SUCCESS();
    }

    /**
     * @Title:  update
     * @MethodName:  改
     * @Param: [vo]
     * @Retrun: com.gemframework.bas.model.BaseResult
     * @Description:
     * @Date: 2019-12-05 22:22:32
     */
    @PostMapping("edit")
    public BaseResult edit(MenuVo vo){
        return BaseResult.SUCCESS(menuService.update(vo));
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
    public BaseResult list(){
        List<MenuVo> list = menuService.findListAll();
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
    public BaseResult listByParams(MenuVo vo){
        List<MenuVo> list = menuService.findListByParams(vo);
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
    public BaseResult page(Pageable pageable){
        List<MenuVo> vo = menuService.findPageAll(pageable);
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
    public BaseResult pageByParams(MenuVo vo,Pageable pageable){
        List<MenuVo> list =  menuService.findPageByParams(vo,pageable);
        return BaseResult.SUCCESS(list);
    }


    @GetMapping("add.html")
    public String addHtml(){
        return "menu/add";
    }

    @GetMapping("edit.html")
    public String editHtml(){
        return "menu/edit";
    }

    @GetMapping("list.html")
    public String list(Model model, HttpServletRequest request){
        List list = menuService.findListAll();
        model.addAttribute("menuList",list);
        return "menu/list";
    }
}

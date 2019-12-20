package com.gemframework.cms.controller;

import com.gemframework.bas.model.BaseResult;
import com.gemframework.cms.model.vo.MenuData;
import com.gemframework.cms.model.vo.MenuVo;
import com.gemframework.cms.model.vo.RoleVo;
import com.gemframework.cms.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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
@RestController
public class IndexController {


    @Resource
    private MenuService menuService;

    @GetMapping("/initMenus")
    public BaseResult initMenus(HttpServletRequest request){
        List<MenuData> list = (List<MenuData>) request.getSession().getAttribute("session_menus");
        log.info("返回="+BaseResult.SUCCESS(list));
        return BaseResult.SUCCESS(list);
    }
    @GetMapping("/initMenus1")
    public BaseResult initMenus2(){
        List<RoleVo> roles = new ArrayList<>();
        RoleVo a = new RoleVo();
        a.setFlag("admin");
        a.setId(1L);
        RoleVo b = new RoleVo();
        b.setId(2L);
        b.setFlag("user");
        roles.add(a);
        roles.add(b);
        return BaseResult.SUCCESS(menuService.findListByRoles(roles));
    }

}

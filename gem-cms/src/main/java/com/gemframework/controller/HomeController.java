package com.gemframework.controller;

import com.gemframework.common.annotation.ValidToken;
import com.gemframework.common.config.GemSystemProperties;
import com.gemframework.model.BaseResultData;
import com.gemframework.common.enums.MenuType;
import com.gemframework.model.vo.MenuVo;
import com.gemframework.model.vo.tree.MenuSide;
import com.gemframework.model.vo.view.Home;
import com.gemframework.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
@Controller
@RequestMapping("home")
public class HomeController {


    @Resource
    private MenuService menuService;


    /***
     * 加载全部用户的左侧菜单栏MenuSide
     * @return
     */
    @GetMapping("/initAllMenus")
    @ResponseBody
    public BaseResultData initAllMenus(){
        List<MenuVo> menus = menuService.findListAllByType(MenuType.MENU);
        List<MenuSide> menuSides = new ArrayList<>();
        for(MenuVo menuVo:menus){
            MenuSide menuSide = MenuSide.builder()
                    .F_ModuleId(String.valueOf(menuVo.getId()))
                    .F_ParentId(String.valueOf(menuVo.getPid()))
                    .F_EnCode(menuVo.getTag())
                    .F_FullName(menuVo.getName())
                    .F_Icon(menuVo.getIcon())
                    .F_UrlAddress(menuVo.getLink()).build();
            menuSides.add(menuSide);
        }
        return BaseResultData.SUCCESS(menuSides);
    }

    /***
     * 加载当前权限用户的左侧菜单栏MenuSide
     * @param request
     * @return
     */
    @GetMapping("/initMenus")
    @ResponseBody
    public BaseResultData initMenus(HttpServletRequest request){
        List<MenuSide> menuSides = (List<MenuSide>) request.getSession().getAttribute("session_sidebar_menus");
        return BaseResultData.SUCCESS(menuSides);
    }

    /***
     * 加载当前权限用户的左侧菜单栏MenuSide
     * @return
     */
    @ValidToken
    @GetMapping("/orderInfo")
    @ResponseBody
    public BaseResultData orderInfo(){
        int random = (int)(Math.random()*100);
        Home.Order order = Home.Order.builder()
                .waitPay(random)
                .timeoutPay(random)
                .payOffs(random)
                .sended(random)
                .timeoutSend(random)
                .close(random)
                .refund(random)
                .success(random)
                .build();
        return BaseResultData.SUCCESS(order);
    }

    @GetMapping("")
    public String home(){
        return "home";
    }

    @GetMapping("userInfo")
    public String user(){
        return "home/user";
    }

}

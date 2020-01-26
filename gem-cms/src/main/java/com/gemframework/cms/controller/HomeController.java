package com.gemframework.cms.controller;

import com.gemframework.bas.common.annotation.ValidToken;
import com.gemframework.bas.model.BaseResult;
import com.gemframework.cms.common.enums.MenuType;
import com.gemframework.cms.model.vo.MenuVo;
import com.gemframework.cms.model.vo.tree.MenuSide;
import com.gemframework.cms.model.vo.view.Home;
import com.gemframework.cms.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public BaseResult initAllMenus(){
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
        return BaseResult.SUCCESS(menuSides);
    }

    /***
     * 加载当前权限用户的左侧菜单栏MenuSide
     * @param request
     * @return
     */
    @GetMapping("/initMenus")
    @ResponseBody
    public BaseResult initMenus(HttpServletRequest request){
        List<MenuSide> menuSides = (List<MenuSide>) request.getSession().getAttribute("session_sidebar_menus");
        return BaseResult.SUCCESS(menuSides);
    }

    /***
     * 加载当前权限用户的左侧菜单栏MenuSide
     * @return
     */
    @ValidToken
    @GetMapping("/orderInfo")
    @ResponseBody
    public BaseResult orderInfo(){
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
        return BaseResult.SUCCESS(order);
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

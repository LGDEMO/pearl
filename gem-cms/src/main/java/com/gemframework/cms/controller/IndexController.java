package com.gemframework.cms.controller;

import com.alibaba.fastjson.JSON;
import com.gemframework.bas.model.BaseResult;
import com.gemframework.cms.common.enums.MenuType;
import com.gemframework.cms.common.security.config.GemSecurityProperties;
import com.gemframework.cms.model.vo.MenuVo;
import com.gemframework.cms.model.vo.tree.MenuSide;
import com.gemframework.cms.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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
@RestController
public class IndexController {


    @Resource
    private MenuService menuService;
    @Resource
    private GemSecurityProperties GemSecurityProperties;

    /***
     * 加载全部用户的左侧菜单栏MenuSide
     * @return
     */
    @GetMapping("/initAllMenus")
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
    public BaseResult initMenus(HttpServletRequest request){
        List<MenuSide> menuSides = (List<MenuSide>) request.getSession().getAttribute("session_sidebar_menus");

        if(!GemSecurityProperties.isOpen()){
//            List<MenuVo> menus = menuService.findMenusListAll();
            List<MenuVo> menus = menuService.findListAllByType(MenuType.MENU);
            log.info("menus===>"+JSON.toJSONString(menus));
            if(menus!=null && menus.size()>0){
                menuSides = new ArrayList<>();
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
            }
        }
        log.info("menus===>"+JSON.toJSONString(menuSides));
        return BaseResult.SUCCESS(menuSides);
    }

}

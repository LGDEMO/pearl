package com.gemframework.controller;

import com.alibaba.fastjson.JSON;
import com.gemframework.model.BaseResult;
import com.gemframework.common.enums.MenuType;
import com.gemframework.model.vo.DeptVo;
import com.gemframework.model.vo.MenuVo;
import com.gemframework.model.vo.tree.MenuSide;
import com.gemframework.model.vo.tree.ZtreeEntity;
import com.gemframework.service.DeptService;
import com.gemframework.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title: CommController.java
 * @Package: com.gemframework.gembasic.controller
 * @Date: 2019/11/28 18:03
 /* @Version: v1.0
 * @Description: 公共组件控制器
 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */

@Slf4j
@RestController
@RequestMapping("common")
public class CommController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private DeptService deptService;

    /***
     * 加载当前权限用户的菜单树
     * @return
     */
    @GetMapping("/findAllMenusTree")
    public BaseResult findAllMenusTree(){
        List<MenuVo> menus = menuService.findListAll();
        List<ZtreeEntity> ztreeEntities = new ArrayList<>();
        ZtreeEntity ztreeEntity = ZtreeEntity.builder()
                .id(0L)
                .pid(-1L)
                .name("根目录")
                .title("根目录")
                .level(0)
                .open(true)
                .nocheck(true)
                .build();
        ztreeEntities.add(ztreeEntity);
        for(MenuVo menuVo:menus){
            ztreeEntity = ZtreeEntity.builder()
                    .id(menuVo.getId())
                    .pid(menuVo.getPid())
                    .name(menuVo.getName())
                    .title(menuVo.getName())
                    .level(menuVo.getLevel())
                    .open(true)
                    .nocheck(false)
                    .build();
            ztreeEntities.add(ztreeEntity);
        }
        return BaseResult.SUCCESS(toTree(ztreeEntities));
    }

    /***
     * 加载当前权限用户的菜单树
     * @return
     */
    @GetMapping("/findMenusTree")
    public BaseResult findMenusTree(){
        List<MenuVo> menus = menuService.findListAllByType(MenuType.MENU);
        List<ZtreeEntity> ztreeEntities = new ArrayList<>();
        ZtreeEntity ztreeEntity = ZtreeEntity.builder()
                .id(0L)
                .pid(-1L)
                .name("根目录")
                .title("根目录")
                .level(0)
                .open(true)
                .nocheck(true)
                .build();
        ztreeEntities.add(ztreeEntity);
        for(MenuVo menuVo:menus){
            ztreeEntity = ZtreeEntity.builder()
                    .id(menuVo.getId())
                    .pid(menuVo.getPid())
                    .name(menuVo.getName())
                    .title(menuVo.getName())
                    .level(menuVo.getLevel())
                    .open(true)
                    .nocheck(false)
                    .build();
            ztreeEntities.add(ztreeEntity);
        }
        return BaseResult.SUCCESS(toTree(ztreeEntities));
    }

    /***
     * 加载当前权限用户的部门树
     * @return
     */
    @GetMapping("/findAllDeptTree")
    public BaseResult findAllDeptTree(){
        List<DeptVo> depts = deptService.findListAll();
        List<ZtreeEntity> ztreeEntities = new ArrayList<>();
        ZtreeEntity ztreeEntity = ZtreeEntity.builder()
                .id(0L)
                .pid(-1L)
                .name("公司总部")
                .title("公司总部")
                .level(0)
                .open(true)
                .nocheck(true)
                .build();
        ztreeEntities.add(ztreeEntity);
        for(DeptVo deptVo:depts){
            ztreeEntity = ZtreeEntity.builder()
                    .id(deptVo.getId())
                    .pid(deptVo.getPid())
                    .name(deptVo.getName())
                    .title(deptVo.getName())
                    .level(deptVo.getLevel())
                    .open(true)
                    .nocheck(false)
                    .build();
            ztreeEntities.add(ztreeEntity);
        }
        return BaseResult.SUCCESS(toTree(ztreeEntities));
    }




    /**
     * 将list格式是权限数据，转化成tree格式的权限数据。
     * @param treeNodes 传入的树节点列表
     * @return
     */
    public static List<ZtreeEntity> toTree(List<ZtreeEntity> treeNodes) {
        List<ZtreeEntity> trees = new ArrayList<ZtreeEntity>();
        for (ZtreeEntity treeNode : treeNodes) {
            if (-1 == (treeNode.getPid())) {
                trees.add(treeNode);
            }
            for (ZtreeEntity it : treeNodes) {
                if (it.getPid() == treeNode.getId()) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<ZtreeEntity>());
                    }
                    treeNode.getChildren().add(it);
                }
            }
        }
        return trees;
    }

    /***
     * 重置左侧菜单
     * @return
     */
    @GetMapping("/resetSideMenus")
    public BaseResult resetLeftMenus(HttpServletRequest request){
        List<MenuSide> menuSides = new ArrayList<>();
        List<MenuVo> menus = menuService.findListAllByType(MenuType.MENU);
        if(menus!=null && menus.size()>0){
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

            log.info("menuSides = "+ JSON.toJSONString(menuSides));
            request.getSession().setAttribute("session_sidebar_menus", menuSides);
        }
        return BaseResult.SUCCESS();
    }

}

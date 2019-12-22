package com.gemframework.cms.controller;

import com.alibaba.fastjson.JSON;
import com.gemframework.bas.model.BaseResult;
import com.gemframework.cms.model.vo.MenuVo;
import com.gemframework.cms.model.vo.ztree.MenuSide;
import com.gemframework.cms.model.vo.ztree.MenuTree;
import com.gemframework.cms.service.MenuService;
import com.gemframework.cms.service.impl.MenuServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
public class CommController {

    @Autowired
    private MenuService menuService;

    /***
     * 加载当前权限用户的左侧菜单栏MenuSide
     * @return
     */
    @GetMapping("/findAllMenusTree")
    public BaseResult findAllMenusTree(){
        List<MenuVo> menus = menuService.findListAll();
        List<MenuTree> menuTrees = new ArrayList<>();
        MenuTree menuTree = MenuTree.builder()
                .id(0L)
                .pid(-1L)
                .name("根目录")
                .title("根目录")
                .level(0)
                .open(true)
                .nocheck(true)
                .build();
        menuTrees.add(menuTree);
        for(MenuVo menuVo:menus){
            menuTree = MenuTree.builder()
                    .id(menuVo.getId())
                    .pid(menuVo.getPid())
                    .name(menuVo.getName())
                    .title(menuVo.getName())
                    .level(menuVo.getLevel())
                    .open(true)
                    .nocheck(true)
                    .build();
            menuTrees.add(menuTree);
        }
        return BaseResult.SUCCESS(toTree(menuTrees));
    }




    /**
     * 将list格式是权限数据，转化成tree格式的权限数据。
     * @param treeNodes 传入的树节点列表
     * @return
     */
    public static List<MenuTree> toTree(List<MenuTree> treeNodes) {
        List<MenuTree> trees = new ArrayList<MenuTree>();
        for (MenuTree treeNode : treeNodes) {
            if (-1 == (treeNode.getPid())) {
                trees.add(treeNode);
            }
            for (MenuTree it : treeNodes) {
                if (it.getPid() == treeNode.getId()) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<MenuTree>());
                    }
                    treeNode.getChildren().add(it);
                }
            }
        }
        return trees;
    }
}

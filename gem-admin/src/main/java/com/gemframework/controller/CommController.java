/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.controller;

import com.gemframework.common.security.configure.GemSecurityProperties;
import com.gemframework.model.BaseResultData;
import com.gemframework.common.enums.MenuType;
import com.gemframework.model.vo.DeptVo;
import com.gemframework.model.vo.MenuVo;
import com.gemframework.model.vo.tree.ZtreeEntity;
import com.gemframework.service.DeptService;
import com.gemframework.service.MenuService;
import com.gemframework.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private RoleService roleService;

    @Autowired
    private GemSecurityProperties gemSecurityProperties;

    /***
     * 加载当前权限用户的菜单树
     * @return
     */
    @GetMapping("/findAllMenusTree")
    public BaseResultData findAllMenusTree(){
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
        return BaseResultData.SUCCESS(toTree(ztreeEntities));
    }

    /***
     * 加载当前权限用户的菜单树
     * @return
     */
    @GetMapping("/findMenusTree")
    public BaseResultData findMenusTree(){
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
        return BaseResultData.SUCCESS(toTree(ztreeEntities));
    }

    /***
     * 加载当前权限用户的部门树
     * @return
     */
    @GetMapping("/findAllDeptTree")
    public BaseResultData findAllDeptTree(){
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
        return BaseResultData.SUCCESS(toTree(ztreeEntities));
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
}

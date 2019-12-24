package com.gemframework.cms.controller;

import com.gemframework.bas.model.BaseResult;
import com.gemframework.cms.model.vo.DeptVo;
import com.gemframework.cms.model.vo.MenuVo;
import com.gemframework.cms.model.vo.tree.ZtreeEntity;
import com.gemframework.cms.service.DeptService;
import com.gemframework.cms.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
public class CommController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private DeptService deptService;

    /***
     * 加载当前权限用户的左侧菜单栏MenuSide
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
                    .nocheck(true)
                    .build();
            ztreeEntities.add(ztreeEntity);
        }
        return BaseResult.SUCCESS(toTree(ztreeEntities));
    }

    /***
     * 加载当前权限用户的左侧菜单栏MenuSide
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
                    .nocheck(true)
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
}

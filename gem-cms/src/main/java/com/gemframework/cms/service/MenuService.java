package com.gemframework.cms.service;

import com.gemframework.cms.common.enums.MenuType;
import com.gemframework.cms.model.vo.MenuVo;
import com.gemframework.cms.model.vo.RoleVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MenuService {

    MenuVo add(MenuVo vo);

    /**
     * 查询资源链表 用于资源管理list页面
     * @return
     */
    List<MenuVo> findListAll();
    /**
     * 查询资源链表 用于资源管理list页面
     * @return
     */
    List<MenuVo> findLinkedListAll();

    /**
     * 获取所有菜单列表
     * @return
     */
    List<MenuVo> findListAllByType(MenuType type);

    /**
     * 条件动态查询
     * @param vo
     * @return
     */
    List<MenuVo> findListByParams(MenuVo vo);

    /**
     * 根据角色ID获取资源列表
     * @param roleId
     * @return
     */
    List<MenuVo> findListByRoleId(Long roleId);

    /**
     * 根据角色列表获取资源列表
     * @param roles
     * @return
     */
    List<MenuVo> findListByRoles(List<RoleVo> roles);

    /**
     * 根据角色列表获取资源列表树
     * @param roles
     * @return
     */
    List<MenuVo> findTreeByRoles(List<RoleVo> roles);

    List<MenuVo> findPageAll(Pageable pageable);

    List<MenuVo> findPageByParams(MenuVo vo, Pageable pageable);

    MenuVo update(MenuVo vo);

    void delete(Long id);

    MenuVo getById(Long id);

}

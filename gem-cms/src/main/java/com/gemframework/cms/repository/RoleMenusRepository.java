package com.gemframework.cms.repository;

import com.gemframework.cms.model.po.RoleMenus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Title: RoleMenusRepository.java
 * @Package: com.gemframework.gembasic.repository
 * @Date: 2019-12-05 22:09:15
 * @Version: v1.0
 * @Description: 这里写描述

 * @Author: zhangys
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
public interface RoleMenusRepository extends JpaRepository<RoleMenus, Long> {

    @Query("select roleMenus from RoleMenus where roleId = ?1")
    List<RoleMenus> findListByRoleId(Long roleId);

}

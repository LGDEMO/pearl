package com.gemframework.cms.repository;

import com.gemframework.cms.model.po.RoleOrgs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Title: RoleOrgsRepository.java
 * @Package: com.gemframework.gembasic.repository
 * @Date: 2019-12-05 22:08:48
 * @Version: v1.0
 * @Description: 这里写描述

 * @Author: zhangys
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
public interface RoleOrgsRepository extends JpaRepository<RoleOrgs, Long> {

    @Query("select roleOrgs from RoleOrgs roleOrgs where roleId = ?1")
    List<RoleOrgs> findListByRoleId(Long roleId);

}

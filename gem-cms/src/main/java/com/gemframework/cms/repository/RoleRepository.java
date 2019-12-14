package com.gemframework.cms.repository;

import com.gemframework.cms.model.po.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Title: RoleRepository.java
 * @Package: com.gemframework.gembasic.repository
 * @Date: 2019-12-05 22:10:59
 * @Version: v1.0
 * @Description: 这里写描述

 * @Author: zhangys
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("select role from Role role where id = ?1")
    Role getById(Long id);
}

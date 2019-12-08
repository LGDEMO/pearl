package com.gemframework.cms.repository;

import com.gemframework.cms.model.po.Menu;
import com.gemframework.cms.model.po.Org;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Title: OrgRepository.java
 * @Package: com.gemframework.gembasic.repository
 * @Date: 2019-12-05 22:08:20
 * @Version: v1.0
 * @Description: 这里写描述

 * @Author: zhangys
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
public interface OrgRepository extends JpaRepository<Org, Long> {

    @Query("select org from Org role where id = ?1")
    Org getById(Long id);
}

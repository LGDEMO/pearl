package com.gemframework.cms.repository;

import com.gemframework.cms.model.po.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Title: CodeRepository.java
 * @Package: com.gemframework.gembasic.repository
 * @Date: 2019-12-05 22:07:32
 * @Version: v1.0
 * @Description: 这里写描述

 * @Author: zhangys
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
public interface CodeRepository extends JpaRepository<Module, Long> {

    @Query("select code from Module code where id = ?1")
    Module getById(Long id);

    @Query("select code from Module code where name_cn=?1 and id <> ?2")
    Module exist(String name, Long id);
}

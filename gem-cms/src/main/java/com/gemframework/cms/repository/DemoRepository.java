package com.gemframework.cms.repository;

import com.gemframework.cms.model.po.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Title: DemoRepository.java
 * @Package: com.gemframework.gembasic.repository
 * @Date: 2019-12-05 22:07:32
 * @Version: v1.0
 * @Description: 这里写描述

 * @Author: zhangys
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
public interface DemoRepository extends JpaRepository<Demo, Long> {

    @Query("select demo from Demo demo where id = ?1")
    Demo getById(Long id);

    @Query("select demo from Demo demo where name=?1 and id <> ?2")
    Demo exist(String name, Long id);
}

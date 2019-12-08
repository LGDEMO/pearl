package com.gemframework.cms.repository;

import com.gemframework.cms.model.po.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Title: MenuRepository.java
 * @Package: com.gemframework.gembasic.repository
 * @Date: 2019-12-05 22:10:15
 * @Version: v1.0
 * @Description: 这里写描述

 * @Author: zhangys
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query("select menu from Menu menu where id = ?1")
    Menu getById(Long id);
}

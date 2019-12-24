package com.gemframework.cms.repository;

import com.gemframework.cms.model.po.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Title: DeptRepository.java
 * @Package: com.gemframework.gembasic.repository
 * @Date: 2019-12-05 22:07:32
 * @Version: v1.0
 * @Description: 这里写描述

 * @Author: zhangys
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
public interface DeptRepository extends JpaRepository<Dept, Long> {

    @Query("select dept from Dept dept where id = ?1")
    Dept getById(Long id);
}

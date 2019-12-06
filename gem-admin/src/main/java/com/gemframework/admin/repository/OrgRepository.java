package com.gemframework.admin.repository;

import com.gemframework.admin.model.po.Org;
import org.springframework.data.jpa.repository.JpaRepository;

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
}

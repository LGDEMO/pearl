package com.gemframework.base.repository;

import com.gemframework.base.model.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Title: UserRepository.java
 * @Package: com.gemframework.gembasic.repository
 * @Date: 2019/11/28 16:26
 * @Version: v1.0
 * @Description: 这里写描述

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
public interface UserRepository extends JpaRepository<User, Long> {
}

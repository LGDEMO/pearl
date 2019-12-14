package com.gemframework.bas.repository;

import com.gemframework.bas.model.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Title: UserRepository.java
 * @Package: com.gemframework.bas.repository
 * @Date: 2019/11/28 16:26
 * @Version: v1.0
 * @Description: 这里写描述

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select user from User user where userPhone=?1")
    User findByPhone(String phone);
}

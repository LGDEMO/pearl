/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.repository;

import com.gemframework.model.po.RoleDepts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Title: RoleDeptsRepository.java
 * @Package: com.gemframework.gembasic.repository
 * @Date: 2019-12-05 22:09:48
 * @Version: v1.0
 * @Description: 这里写描述

 * @Author: zhangys
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
public interface RoleDeptsRepository extends JpaRepository<RoleDepts, Long> {

    @Query("select roleDrpts from RoleDepts roleDrpts where roleId = ?1")
    List<RoleDepts> findListByRoleId(Long roleId);

    @Modifying
    @Transactional
    @Query("delete from RoleDepts rd where rd.roleId = ?1")
    int deleteByRoleId(Long roleId);


}

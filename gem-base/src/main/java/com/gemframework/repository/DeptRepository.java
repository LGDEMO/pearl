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

import com.gemframework.model.po.Dept;
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

    @Query("select dept from Dept dept where name=?1")
    Dept getByName(String name);

    @Query("select dept from Dept dept where name=?1 and id <> ?2")
    Dept exist(String name, Long id);
}

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

import com.gemframework.model.po.ModuleAttr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Title: ModuleAttrRepository.java
 * @Package: com.gemframework.repository
 * @Date: 2020-01-29 18:16:21
 * @Version: v1.0
 * @Description: 这里写描述

 * @Author: zhangys
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
public interface ModuleAttrRepository extends JpaRepository<ModuleAttr, Long> {

    @Query("select moduleAttr from ModuleAttr moduleAttr where id = ?1")
    ModuleAttr getById(Long id);

    @Query("select moduleAttr from ModuleAttr moduleAttr where moduleId = ?1 order by attrSort asc")
    List<ModuleAttr> findByModuleId(Long moduleId);

    @Query("select moduleAttr from ModuleAttr moduleAttr where attrName=?1 and id <> ?2")
    ModuleAttr exist(String name, Long id);
}

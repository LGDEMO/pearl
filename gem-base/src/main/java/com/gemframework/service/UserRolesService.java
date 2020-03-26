/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.service;

import com.gemframework.model.vo.UserRolesVo;
import com.gemframework.model.vo.response.PageInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserRolesService {

    UserRolesVo save(UserRolesVo vo);

    List<UserRolesVo> findListAll();

    List<UserRolesVo> findListByParams(UserRolesVo vo);

    List<UserRolesVo> findListByUserId(Long userId);

    PageInfo findPageByParams(UserRolesVo vo, Pageable pageable);

    UserRolesVo update(UserRolesVo vo);

    void delete(Long id);
}

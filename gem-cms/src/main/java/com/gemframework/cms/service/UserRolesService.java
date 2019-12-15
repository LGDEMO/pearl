package com.gemframework.cms.service;

import com.gemframework.cms.model.vo.UserRolesVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserRolesService {


    UserRolesVo add(UserRolesVo vo);

    List<UserRolesVo> findListAll();

    List<UserRolesVo> findListByParams(UserRolesVo vo);

    List<UserRolesVo> findListByUserId(Long userId);

    List<UserRolesVo> findPageAll(Pageable pageable);

    List<UserRolesVo> findPageByParams(UserRolesVo vo, Pageable pageable);

    UserRolesVo update(UserRolesVo vo);

    void delete(Long id);
}

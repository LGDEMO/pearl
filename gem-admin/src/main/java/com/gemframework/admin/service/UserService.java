package com.gemframework.admin.service;

import com.gemframework.admin.model.vo.UserVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {


    UserVo add(UserVo vo);

    List findListAll();

    List findListByParams(UserVo vo);

    Page findPageAll(Pageable pageable);

    Page findPageByParams(UserVo vo, Pageable pageable);

    UserVo update(UserVo vo);

    void delete(Long id);

    void deleteAll();
}

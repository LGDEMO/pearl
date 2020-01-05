package com.gemframework.cms.service;

import com.gemframework.cms.model.vo.DeptVo;
import com.gemframework.cms.model.vo.UserVo;
import com.gemframework.cms.model.vo.response.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {


    boolean exist(UserVo vo);

    UserVo save(UserVo vo);

    List findListAll();

    List findListByParams(UserVo vo);

    Page findPageAll(Pageable pageable);

    PageInfo<UserVo> findPageByParams(UserVo vo, Pageable pageable);

    UserVo getByLoginName(String loginName);

    void delete(Long id);

    void deleteBatch(List<UserVo> vos);

    void deleteAll();

    UserVo getById(Long id);
}

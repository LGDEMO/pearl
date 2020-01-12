package com.gemframework.cms.service;

import com.gemframework.cms.model.po.Role;
import com.gemframework.cms.model.vo.DeptVo;
import com.gemframework.cms.model.vo.RoleVo;
import com.gemframework.cms.model.vo.UserVo;
import com.gemframework.cms.model.vo.response.PageInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {

    boolean exist(RoleVo vo);

    RoleVo save(RoleVo vo);

    List<RoleVo> findListAll();

    List<RoleVo> findListByParams(RoleVo vo);

    List<RoleVo> findPageAll(Pageable pageable);

    PageInfo<RoleVo> findPageByParams(RoleVo vo, Pageable pageable);

    void delete(Long id);

    void deleteBatch(List<UserVo> vos);

    RoleVo getById(Long id);

    RoleVo getByFlag(String flag);

}

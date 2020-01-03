package com.gemframework.cms.service;

import com.gemframework.cms.model.po.Role;
import com.gemframework.cms.model.vo.RoleVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {


    RoleVo save(RoleVo vo);

    List<RoleVo> findListAll();

    List<RoleVo> findListByParams(RoleVo vo);

    List<RoleVo> findPageAll(Pageable pageable);

    List<RoleVo> findPageByParams(RoleVo vo, Pageable pageable);

    RoleVo update(RoleVo vo);

    void delete(Long id);

    RoleVo getById(Long id);

    RoleVo getByFlag(String flag);

}

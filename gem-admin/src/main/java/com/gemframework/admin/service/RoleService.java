package com.gemframework.admin.service;

import com.gemframework.admin.model.vo.RoleVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {


    RoleVo add(RoleVo vo);

    List<RoleVo> findListAll();

    List<RoleVo> findListByParams(RoleVo vo);

    List<RoleVo> findPageAll(Pageable pageable);

    List<RoleVo> findPageByParams(RoleVo vo, Pageable pageable);

    RoleVo update(RoleVo vo);

    void delete(Long id);

    RoleVo getById(Long id);

}

package com.gemframework.admin.service;

import com.gemframework.admin.model.vo.RoleMenusVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleMenusService {


    RoleMenusVo add(RoleMenusVo vo);

    List<RoleMenusVo> findListAll();

    List<RoleMenusVo> findListByParams(RoleMenusVo vo);

    List<RoleMenusVo> findPageAll(Pageable pageable);

    List<RoleMenusVo> findPageByParams(RoleMenusVo vo, Pageable pageable);

    RoleMenusVo update(RoleMenusVo vo);

    void delete(Long id);
}

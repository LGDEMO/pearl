package com.gemframework.service;

import com.gemframework.model.vo.RoleMenusVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleMenusService {


    RoleMenusVo save(RoleMenusVo vo);

    List<RoleMenusVo> findListAll();

    List<RoleMenusVo> findListByParams(RoleMenusVo vo);

    List<RoleMenusVo> findPageAll(Pageable pageable);

    List<RoleMenusVo> findPageByParams(RoleMenusVo vo, Pageable pageable);

    RoleMenusVo update(RoleMenusVo vo);

    void delete(Long id);
}

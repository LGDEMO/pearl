package com.gemframework.cms.service;

import com.gemframework.cms.model.vo.RoleOrgsVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleOrgsService {


    RoleOrgsVo add(RoleOrgsVo vo);

    List<RoleOrgsVo> findListAll();

    List<RoleOrgsVo> findListByParams(RoleOrgsVo vo);

    List<RoleOrgsVo> findPageAll(Pageable pageable);

    List<RoleOrgsVo> findPageByParams(RoleOrgsVo vo, Pageable pageable);

    RoleOrgsVo update(RoleOrgsVo vo);

    void delete(Long id);
}

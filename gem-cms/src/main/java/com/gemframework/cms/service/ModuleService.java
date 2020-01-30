package com.gemframework.cms.service;

import com.gemframework.cms.model.vo.ModuleVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ModuleService {

    boolean exist(ModuleVo vo);

    ModuleVo save(ModuleVo vo);

    List<ModuleVo> findListAll();

    List<ModuleVo> findListByParams(ModuleVo vo);

    List<ModuleVo> findPageAll(Pageable pageable);

    List<ModuleVo> findPageByParams(ModuleVo vo, Pageable pageable);

    void delete(Long id);

    void deleteBatch(List<ModuleVo> vos);

    ModuleVo getById(Long id);
}

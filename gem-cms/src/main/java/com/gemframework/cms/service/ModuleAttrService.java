package com.gemframework.cms.service;

import com.gemframework.cms.model.vo.ModuleAttrVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ModuleAttrService {

    boolean exist(ModuleAttrVo vo);

    ModuleAttrVo save(ModuleAttrVo vo);

    List<ModuleAttrVo> findListAll();

    List<ModuleAttrVo> findListByParams(ModuleAttrVo vo);

    List<ModuleAttrVo> findPageAll(Pageable pageable);

    List<ModuleAttrVo> findPageByParams(ModuleAttrVo vo, Pageable pageable);

    void delete(Long id);

    void deleteBatch(List<ModuleAttrVo> vos);

    ModuleAttrVo getById(Long id);
}

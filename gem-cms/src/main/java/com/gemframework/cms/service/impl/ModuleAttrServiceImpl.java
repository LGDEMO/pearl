package com.gemframework.cms.service.impl;

import com.gemframework.bas.common.enums.ResultCode;
import com.gemframework.bas.common.exception.GemException;
import com.gemframework.bas.common.utils.GemBeanUtils;
import com.gemframework.cms.model.po.ModuleAttr;
import com.gemframework.cms.model.vo.ModuleAttrVo;
import com.gemframework.cms.repository.ModuleAttrRepository;
import com.gemframework.cms.service.ModuleAttrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ModuleAttrServiceImpl implements ModuleAttrService {

    @Resource
    private ModuleAttrRepository moduleAttrRepository;

    @Override
    public boolean exist(ModuleAttrVo vo) {
        ModuleAttr entity = moduleAttrRepository.exist(vo.getFiledName(),vo.getId());
        if(entity == null){
            return false;
        }
        return true;
    }

    @Override
    public ModuleAttrVo save(ModuleAttrVo vo) {
        ModuleAttr entity = new ModuleAttr();
        GemBeanUtils.copyProperties(vo,entity);
        entity = moduleAttrRepository.save(entity);
        GemBeanUtils.copyProperties(entity,vo);
        return vo;
    }

    @Override
    public List<ModuleAttrVo> findListAll() {
        List<ModuleAttr> list = moduleAttrRepository.findAll();
        List<ModuleAttrVo> vos = GemBeanUtils.copyCollections(list,ModuleAttrVo.class);
        return vos;
    }

    @Override
    public List<ModuleAttrVo> findListByParams(ModuleAttrVo vo) {
        ModuleAttr entity = new ModuleAttr();
        GemBeanUtils.copyProperties(vo,entity);
        List<ModuleAttr> list = moduleAttrRepository.findAll(Example.of(entity));
        List<ModuleAttrVo> vos = GemBeanUtils.copyCollections(list,ModuleAttrVo.class);
        return vos;
    }

    @Override
    public List<ModuleAttrVo> findPageAll(Pageable pageable) {
        Page<ModuleAttr> page = moduleAttrRepository.findAll(pageable);
        List<ModuleAttrVo> vos = GemBeanUtils.copyCollections(page.getContent(),ModuleAttrVo.class);
        return vos;
}

    @Override
    public List<ModuleAttrVo> findPageByParams(ModuleAttrVo vo,Pageable pageable) {
        ModuleAttr entity = new ModuleAttr();
        GemBeanUtils.copyProperties(vo,entity);
        Page<ModuleAttr> page = moduleAttrRepository.findAll(Example.of(entity),pageable);
        List<ModuleAttrVo> vos = GemBeanUtils.copyCollections(page.getContent(),ModuleAttrVo.class);
        return vos;
    }

    @Override
    public void delete(Long id) {
        if(!moduleAttrRepository.existsById(id)){
            throw new GemException(ResultCode.DATA_NOT_EXIST);
        }
        moduleAttrRepository.deleteById(id);
    }

    @Override
    public void deleteBatch(List<ModuleAttrVo> vos) {
        List<ModuleAttr> list = GemBeanUtils.copyCollections(vos,ModuleAttr.class);
        moduleAttrRepository.deleteInBatch(list);
    }

    @Override
    public ModuleAttrVo getById(Long id) {
        ModuleAttrVo vo  = new ModuleAttrVo();
        ModuleAttr entity = moduleAttrRepository.getById(id);
        GemBeanUtils.copyProperties(entity,vo);
        return vo;
    }
}


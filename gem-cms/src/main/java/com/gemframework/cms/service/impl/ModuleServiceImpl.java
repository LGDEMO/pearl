package com.gemframework.cms.service.impl;

import com.gemframework.bas.common.enums.ResultCode;
import com.gemframework.bas.common.exception.GemException;
import com.gemframework.bas.common.utils.GemBeanUtils;
import com.gemframework.cms.model.po.Module;
import com.gemframework.cms.model.po.ModuleAttr;
import com.gemframework.cms.model.vo.ModuleAttrVo;
import com.gemframework.cms.model.vo.ModuleVo;
import com.gemframework.cms.repository.ModuleAttrRepository;
import com.gemframework.cms.repository.ModuleRepository;
import com.gemframework.cms.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ModuleServiceImpl implements ModuleService {

    @Resource
    private ModuleRepository moduleRepository;
    @Resource
    private ModuleAttrRepository moduleAttrRepository;

    @Override
    public boolean exist(ModuleVo vo) {
        Module entity = moduleRepository.exist(vo.getNameEn(),vo.getId());
        if(entity == null){
            return false;
        }
        return true;
    }

    @Override
    public ModuleVo save(ModuleVo vo) {
        Module entity = new Module();
        GemBeanUtils.copyProperties(vo,entity);
        entity = moduleRepository.save(entity);
        GemBeanUtils.copyProperties(entity,vo);
        return vo;
    }

    @Override
    public List<ModuleVo> findListAll() {
        List<Module> list = moduleRepository.findAll();
        List<ModuleVo> vos = GemBeanUtils.copyCollections(list,ModuleVo.class);
        return vos;
    }

    @Override
    public List<ModuleVo> findListByParams(ModuleVo vo) {
        Module entity = new Module();
        GemBeanUtils.copyProperties(vo,entity);
        List<Module> list = moduleRepository.findAll(Example.of(entity));
        List<ModuleVo> vos = GemBeanUtils.copyCollections(list,ModuleVo.class);
        return vos;
    }

    @Override
    public List<ModuleVo> findPageAll(Pageable pageable) {
        Page<Module> page = moduleRepository.findAll(pageable);
        List<ModuleVo> vos = GemBeanUtils.copyCollections(page.getContent(),ModuleVo.class);
        return vos;
}

    @Override
    public List<ModuleVo> findPageByParams(ModuleVo vo,Pageable pageable) {
        Module entity = new Module();
        GemBeanUtils.copyProperties(vo,entity);
        Page<Module> page = moduleRepository.findAll(Example.of(entity),pageable);
        List<ModuleVo> vos = GemBeanUtils.copyCollections(page.getContent(),ModuleVo.class);
        if(vos!=null && vos.size()>0){
            for(ModuleVo moduleVo:vos){
                Long id = moduleVo.getId();
                List<ModuleAttr> moduleAttrs = moduleAttrRepository.getByModuleId(id);
                if(moduleAttrs!=null && moduleAttrs.size()>0){
                    List<ModuleAttrVo> moduleAttrVos = new ArrayList<>();
                    for(ModuleAttr moduleAttr:moduleAttrs){
                        ModuleAttrVo moduleAttrVo = new ModuleAttrVo();
                        GemBeanUtils.copyProperties(moduleAttr,moduleAttrVo);
                        moduleAttrVos.add(moduleAttrVo);
                    }
                    moduleVo.setModuleAttrs(moduleAttrVos);
                }
            }
        }
        return vos;
    }

    @Override
    public void delete(Long id) {
        if(!moduleRepository.existsById(id)){
            throw new GemException(ResultCode.DATA_NOT_EXIST);
        }
        moduleRepository.deleteById(id);
    }

    @Override
    public void deleteBatch(List<ModuleVo> vos) {
        List<Module> list = GemBeanUtils.copyCollections(vos,Module.class);
        moduleRepository.deleteInBatch(list);
    }

    @Override
    public ModuleVo getById(Long id) {
        ModuleVo vo  = new ModuleVo();
        Module entity = moduleRepository.getById(id);
        GemBeanUtils.copyProperties(entity,vo);
        return vo;
    }
}


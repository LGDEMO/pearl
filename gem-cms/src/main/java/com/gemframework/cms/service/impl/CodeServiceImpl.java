package com.gemframework.cms.service.impl;

import com.gemframework.bas.common.enums.ResultCode;
import com.gemframework.bas.common.exception.GemException;
import com.gemframework.bas.common.utils.GemBeanUtils;
import com.gemframework.cms.model.po.Module;
import com.gemframework.cms.model.vo.ModuleVo;
import com.gemframework.cms.repository.CodeRepository;
import com.gemframework.cms.service.CodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class CodeServiceImpl implements CodeService {

    @Resource
    private CodeRepository codeRepository;

    @Override
    public boolean exist(ModuleVo vo) {
        Module entity = codeRepository.exist(vo.getNameCn(),vo.getId());
        if(entity == null){
            return false;
        }
        return true;
    }

    @Override
    public ModuleVo save(ModuleVo vo) {
        Module entity = new Module();
        GemBeanUtils.copyProperties(vo,entity);
        entity = codeRepository.save(entity);
        GemBeanUtils.copyProperties(entity,vo);
        return vo;
    }

    @Override
    public List<ModuleVo> findListAll() {
        List<Module> list = codeRepository.findAll();
        List<ModuleVo> vos = GemBeanUtils.copyCollections(list, ModuleVo.class);
        return vos;
    }

    @Override
    public List<ModuleVo> findListByParams(ModuleVo vo) {
        Module entity = new Module();
        GemBeanUtils.copyProperties(vo,entity);
        List<Module> list = codeRepository.findAll(Example.of(entity));
        List<ModuleVo> vos = GemBeanUtils.copyCollections(list, ModuleVo.class);
        return vos;
    }

    @Override
    public List<ModuleVo> findPageAll(Pageable pageable) {
        Page<Module> page = codeRepository.findAll(pageable);
        List<ModuleVo> vos = GemBeanUtils.copyCollections(page.getContent(), ModuleVo.class);
        return vos;
}

    @Override
    public List<ModuleVo> findPageByParams(ModuleVo vo, Pageable pageable) {
        Module entity = new Module();
        GemBeanUtils.copyProperties(vo,entity);
        Page<Module> page = codeRepository.findAll(Example.of(entity),pageable);
        List<ModuleVo> vos = GemBeanUtils.copyCollections(page.getContent(), ModuleVo.class);
        return vos;
    }

    @Override
    public void delete(Long id) {
        if(!codeRepository.existsById(id)){
            throw new GemException(ResultCode.DATA_NOT_EXIST);
        }
        codeRepository.deleteById(id);
    }

    @Override
    public void deleteBatch(List<ModuleVo> vos) {
        List<Module> list = GemBeanUtils.copyCollections(vos, Module.class);
        codeRepository.deleteInBatch(list);
    }

    @Override
    public ModuleVo getById(Long id) {
        ModuleVo vo  = new ModuleVo();
        Module entity = codeRepository.getById(id);
        GemBeanUtils.copyProperties(entity,vo);
        return vo;
    }
}

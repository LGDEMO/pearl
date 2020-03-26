/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.service.impl;

import com.gemframework.common.enums.ResultCode;
import com.gemframework.common.exception.GemException;
import com.gemframework.common.utils.GemBeanUtils;
import com.gemframework.model.po.Menu;
import com.gemframework.model.po.ModuleAttr;
import com.gemframework.model.po.SysLog;
import com.gemframework.model.vo.ModuleAttrVo;
import com.gemframework.model.vo.SysLogVo;
import com.gemframework.model.vo.response.PageInfo;
import com.gemframework.repository.ModuleAttrRepository;
import com.gemframework.service.ModuleAttrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ModuleAttrServiceImpl implements ModuleAttrService {

    @Resource
    private ModuleAttrRepository moduleAttrRepository;

    @Override
    public boolean exist(ModuleAttrVo vo) {
        ModuleAttr entity = moduleAttrRepository.exist(vo.getAttrName(),vo.getId());
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
    public PageInfo findPageByParams(ModuleAttrVo vo,Pageable pageable) {
        ModuleAttr entity = new ModuleAttr();
        GemBeanUtils.copyProperties(vo,entity);
        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) //改变默认字符串匹配方式：模糊查询
                .withIgnoreCase(true); //改变默认大小写忽略方式：忽略大小写
        Page<ModuleAttr> page = moduleAttrRepository.findAll(Example.of(entity,matcher),pageable);
        PageInfo pageInfo = PageInfo.builder()
                .total(page.getTotalElements())
                .rows(page.getContent())
                .build();
        return pageInfo;
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


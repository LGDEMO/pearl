package com.gemframework.service.impl;

import com.gemframework.common.enums.ResultCode;
import com.gemframework.common.exception.GemException;
import com.gemframework.common.utils.GemBeanUtils;
import com.gemframework.model.po.SysLog;
import com.gemframework.model.vo.SysLogVo;
import com.gemframework.model.vo.response.PageInfo;
import com.gemframework.repository.SysLogRepository;
import com.gemframework.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class SysLogServiceImpl implements SysLogService {

    @Resource
    private SysLogRepository sysLogRepository;


    @Override
    public SysLogVo save(SysLogVo vo) {
        SysLog entity = new SysLog();
        GemBeanUtils.copyProperties(vo,entity);
        entity = sysLogRepository.save(entity);
        GemBeanUtils.copyProperties(entity,vo);
        return vo;
    }

    @Override
    public List<SysLogVo> findListAll() {
        List<SysLog> list = sysLogRepository.findAll();
        List<SysLogVo> vos = GemBeanUtils.copyCollections(list,SysLogVo.class);
        return vos;
    }

    @Override
    public List<SysLogVo> findListByParams(SysLogVo vo) {
        SysLog entity = new SysLog();
        GemBeanUtils.copyProperties(vo,entity);
        List<SysLog> list = sysLogRepository.findAll(Example.of(entity));
        List<SysLogVo> vos = GemBeanUtils.copyCollections(list,SysLogVo.class);
        return vos;
    }

    @Override
    public PageInfo findPageAll(Pageable pageable) {
        Page<SysLog> page = sysLogRepository.findAll(pageable);
        List<SysLogVo> vos = GemBeanUtils.copyCollections(page.getContent(),SysLogVo.class);
        PageInfo pageInfo = PageInfo.builder()
                .total(page.getTotalElements())
                .rows(vos)
                .build();
        return pageInfo;
}

    @Override
    public PageInfo findPageByParams(SysLogVo vo,Pageable pageable) {
        SysLog entity = new SysLog();
        GemBeanUtils.copyProperties(vo,entity);
        Page<SysLog> page = sysLogRepository.findAll(Example.of(entity),pageable);
        List<SysLogVo> vos = GemBeanUtils.copyCollections(page.getContent(),SysLogVo.class);
        PageInfo pageInfo = PageInfo.builder()
                .total(page.getTotalElements())
                .rows(vos)
                .build();
        return pageInfo;
    }

    @Override
    public void delete(Long id) {
        if(!sysLogRepository.existsById(id)){
            throw new GemException(ResultCode.DATA_NOT_EXIST);
        }
        sysLogRepository.deleteById(id);
    }

    @Override
    public void deleteBatch(List<SysLogVo> vos) {
        List<SysLog> list = GemBeanUtils.copyCollections(vos,SysLog.class);
        sysLogRepository.deleteInBatch(list);
    }

    @Override
    public SysLogVo getById(Long id) {
        SysLogVo vo  = new SysLogVo();
        SysLog entity = sysLogRepository.getById(id);
        GemBeanUtils.copyProperties(entity,vo);
        return vo;
    }
}


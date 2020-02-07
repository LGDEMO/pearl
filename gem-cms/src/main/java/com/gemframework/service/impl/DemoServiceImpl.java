package com.gemframework.service.impl;

import com.gemframework.common.enums.ResultCode;
import com.gemframework.common.exception.GemException;
import com.gemframework.common.utils.GemBeanUtils;
import com.gemframework.model.po.Demo;
import com.gemframework.model.vo.DemoVo;
import com.gemframework.repository.DemoRepository;
import com.gemframework.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    private DemoRepository demoRepository;

    @Override
    public boolean exist(DemoVo vo) {
        Demo entity = demoRepository.exist(vo.getName(),vo.getId());
        if(entity == null){
            return false;
        }
        return true;
    }

    @Override
    public DemoVo save(DemoVo vo) {
        Demo entity = new Demo();
        GemBeanUtils.copyProperties(vo,entity);
        entity = demoRepository.save(entity);
        GemBeanUtils.copyProperties(entity,vo);
        return vo;
    }

    @Override
    public List<DemoVo> findListAll() {
        List<Demo> list = demoRepository.findAll();
        List<DemoVo> vos = GemBeanUtils.copyCollections(list,DemoVo.class);
        return vos;
    }

    @Override
    public List<DemoVo> findListByParams(DemoVo vo) {
        Demo entity = new Demo();
        GemBeanUtils.copyProperties(vo,entity);
        List<Demo> list = demoRepository.findAll(Example.of(entity));
        List<DemoVo> vos = GemBeanUtils.copyCollections(list,DemoVo.class);
        return vos;
    }

    @Override
    public List<DemoVo> findPageAll(Pageable pageable) {
        Page<Demo> page = demoRepository.findAll(pageable);
        List<DemoVo> vos = GemBeanUtils.copyCollections(page.getContent(),DemoVo.class);
//        PageInfo<DemoVo> pageInfo = new PageInfo();
//        pageInfo.setRows(vos);
//        pageInfo.setTotal(page.getTotalElements());
//        return pageInfo;
        return vos;
}

    @Override
    public List<DemoVo> findPageByParams(DemoVo vo,Pageable pageable) {
        Demo entity = new Demo();
        GemBeanUtils.copyProperties(vo,entity);
        Page<Demo> page = demoRepository.findAll(Example.of(entity),pageable);
        List<DemoVo> vos = GemBeanUtils.copyCollections(page.getContent(),DemoVo.class);
//        PageInfo<DemoVo> pageInfo = new PageInfo();
//        pageInfo.setRows(vos);
//        pageInfo.setTotal(page.getTotalElements());
//        return pageInfo;
        return vos;
    }

    @Override
    public void delete(Long id) {
        if(!demoRepository.existsById(id)){
            throw new GemException(ResultCode.DATA_NOT_EXIST);
        }
        demoRepository.deleteById(id);
    }

    @Override
    public void deleteBatch(List<DemoVo> vos) {
        List<Demo> list = GemBeanUtils.copyCollections(vos,Demo.class);
        demoRepository.deleteInBatch(list);
    }

    @Override
    public DemoVo getById(Long id) {
        DemoVo vo  = new DemoVo();
        Demo entity = demoRepository.getById(id);
        GemBeanUtils.copyProperties(entity,vo);
        return vo;
    }
}

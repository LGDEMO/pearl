package com.gemframework.service;

import com.gemframework.model.vo.DemoVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DemoService {

    boolean exist(DemoVo vo);

    DemoVo save(DemoVo vo);

    List<DemoVo> findListAll();

    List<DemoVo> findListByParams(DemoVo vo);

    List<DemoVo> findPageAll(Pageable pageable);

    List<DemoVo> findPageByParams(DemoVo vo, Pageable pageable);

    void delete(Long id);

    void deleteBatch(List<DemoVo> vos);

    DemoVo getById(Long id);
}

package com.gemframework.service;

import com.gemframework.model.vo.DeptVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DeptService {

    boolean exist(DeptVo vo);

    DeptVo save(DeptVo vo);

    List<DeptVo> findListAll();

    List<DeptVo> findListByParams(DeptVo vo);

    List<DeptVo> findPageAll(Pageable pageable);

    List<DeptVo> findPageByParams(DeptVo vo, Pageable pageable);

    DeptVo update(DeptVo vo);

    void delete(Long id);

    DeptVo getById(Long id);
}

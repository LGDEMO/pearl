package com.gemframework.admin.service;

import com.gemframework.admin.model.vo.DeptVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DeptService {


    DeptVo add(DeptVo vo);

    List<DeptVo> findListAll();

    List<DeptVo> findListByParams(DeptVo vo);

    List<DeptVo> findPageAll(Pageable pageable);

    List<DeptVo> findPageByParams(DeptVo vo, Pageable pageable);

    DeptVo update(DeptVo vo);

    void delete(Long id);
}

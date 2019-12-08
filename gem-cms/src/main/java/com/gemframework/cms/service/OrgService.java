package com.gemframework.cms.service;

import com.gemframework.cms.model.vo.OrgVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrgService {


    OrgVo add(OrgVo vo);

    List<OrgVo> findListAll();

    List<OrgVo> findListByParams(OrgVo vo);

    List<OrgVo> findPageAll(Pageable pageable);

    List<OrgVo> findPageByParams(OrgVo vo, Pageable pageable);

    OrgVo update(OrgVo vo);

    void delete(Long id);
}

package com.gemframework.cms.service;

import com.gemframework.cms.model.po.User;
import com.gemframework.cms.model.vo.DeptVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CacheService {

    String put(String key, String value);
    String get(String key);
    void remove(String key);


    User getById(Long id);
}

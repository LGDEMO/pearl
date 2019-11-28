package com.gemframework.base.service;

import com.gemframework.base.model.po.User;
import com.gemframework.base.model.vo.UserVo;

import java.util.List;

public interface UserService {


    User add(UserVo vo);

    List findAll();

    User update(UserVo vo);

    void delete(Long id);
}

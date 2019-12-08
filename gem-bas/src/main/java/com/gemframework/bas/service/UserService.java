package com.gemframework.bas.service;

import com.gemframework.bas.model.po.User;
import com.gemframework.bas.model.vo.UserVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {


    User add(UserVo vo);

    List findListAll();

    List findListByParams(UserVo vo);

    Page findPageAll(Pageable pageable);

    Page findPageByParams(UserVo vo,Pageable pageable);

    User update(UserVo vo);

    void delete(Long id);

    void deleteAll();
}

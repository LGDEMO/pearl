package com.gemframework.cms.service;

import com.gemframework.cms.model.vo.MenuVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MenuService {


    MenuVo add(MenuVo vo);

    List<MenuVo> findListAll();

    List<MenuVo> findListByParams(MenuVo vo);

    List<MenuVo> findPageAll(Pageable pageable);

    List<MenuVo> findPageByParams(MenuVo vo, Pageable pageable);

    MenuVo update(MenuVo vo);

    void delete(Long id);

    MenuVo getById(Long id);

}

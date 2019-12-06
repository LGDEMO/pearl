package com.gemframework.admin.service.impl;

import com.gemframework.base.common.enums.ResultCode;
import com.gemframework.base.common.exception.GemException;
import com.gemframework.base.common.utils.GemBeanUtils;
import com.gemframework.admin.model.po.Menu;
import com.gemframework.admin.model.vo.MenuVo;
import com.gemframework.admin.repository.MenuRepository;
import com.gemframework.admin.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuRepository menuRepository;

    /**
     * @Title:  add
     * @MethodName:  add
     * @Param: [vo]
     * @Retrun: com.gemframework.admin.model.po.Menu
     * @Description: 添加
     * @Date: 2019-12-05 22:10:15
     */
    @Override
    public MenuVo add(MenuVo vo) {
        Menu menu = new Menu();
        GemBeanUtils.copyProperties(vo,menu);
        menu = menuRepository.save(menu);
        GemBeanUtils.copyProperties(menu,vo);
        return vo;
    }

    /**
     * @Title:  findListAll
     * @MethodName:  findListAll
     * @Param: []
     * @Retrun: java.util.List
     * @Description:  查询所有数据列表
     * @Date: 2019-12-05 22:10:15
     */
    @Override
    public List<MenuVo> findListAll() {
        List<Menu> list = menuRepository.findAll();
        List<MenuVo> vos = GemBeanUtils.copyCollections(list,MenuVo.class);
        return vos;
    }

    /**
     * @Title:  findListByParams
     * @MethodName:  findListByParams
     * @Param: [vo]
     * @Retrun: java.util.List
     * @Description: 动态查询数据
     * //创建匹配器，即使用查询条件
     * @Date: 2019-12-05 22:10:15
     */
    @Override
    public List<MenuVo> findListByParams(MenuVo vo) {
        Menu menu = new Menu();
        GemBeanUtils.copyProperties(vo,menu);
        Example<Menu> example =Example.of(menu);
        List<Menu> list = menuRepository.findAll(example);
        List<MenuVo> vos = GemBeanUtils.copyCollections(list,MenuVo.class);
        return vos;
    }

    /**
     * @Title:  findPageAll
     * @MethodName:  findPageAll
     * @Param: [pageable]
     * @Retrun: org.springframework.data.domain.Page
     * @Description: 【分页】查询所有数据
     * @Date: 2019-12-05 22:10:15
     */
    @Override
    public List<MenuVo> findPageAll(Pageable pageable) {
        Page<Menu> page = menuRepository.findAll(pageable);
        List<Menu> list = page.getContent();
        List<MenuVo> vos = GemBeanUtils.copyCollections(list,MenuVo.class);
        return vos;
    }

    /**
     * @Title:  findPageByParams
     * @MethodName:  findPageByParams
     * @Param: [vo, pageable]
     * @Retrun: org.springframework.data.domain.Page
     * @Description: 【分页】根据条件动态查询
     * @Date: 2019-12-05 22:10:15
     */
    @Override
    public List<MenuVo> findPageByParams(MenuVo vo,Pageable pageable) {
        Menu menu = new Menu();
        GemBeanUtils.copyProperties(vo,menu);
        Example<Menu> example =Example.of(menu);
        Page<Menu> page = menuRepository.findAll(example,pageable);
        List<Menu> list = page.getContent();
        List<MenuVo> vos = GemBeanUtils.copyCollections(list,MenuVo.class);
        return vos;
    }

    /**
     * @Title:  update
     * @MethodName:  update
     * @Param: [vo]
     * @Retrun: com.gemframework.base.model.po.User
     * @Description: 更新数据
     * @Date: 2019-12-05 22:10:15
     */
    @Override
    public MenuVo update(MenuVo vo) {
        Optional<Menu> optional= menuRepository.findById(vo.getId());
        if(optional.isPresent()){
            Menu menu = optional.get();
            GemBeanUtils.copyProperties(vo,menu);
            menu = menuRepository.save(menu);
            GemBeanUtils.copyProperties(menu,vo);
            return vo;
        }
        return null;

    }

    /**
     * @Title:  delete
     * @MethodName:  delete
     * @Param: [id]
     * @Retrun: void
     * @Description: 根据ID删除数据
     * @Date: 2019-12-05 22:10:15
     */
    @Override
    public void delete(Long id) {
        if(!menuRepository.existsById(id)){
            throw new GemException(ResultCode.DATA_NOT_EXIST);
        }
        menuRepository.deleteById(id);

    }
}

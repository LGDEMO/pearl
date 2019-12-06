package com.gemframework.admin.service.impl;

import com.gemframework.base.common.enums.ResultCode;
import com.gemframework.base.common.exception.GemException;
import com.gemframework.base.common.utils.GemBeanUtils;
import com.gemframework.admin.model.po.RoleMenus;
import com.gemframework.admin.model.vo.RoleMenusVo;
import com.gemframework.admin.repository.RoleMenusRepository;
import com.gemframework.admin.service.RoleMenusService;
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
public class RoleMenusServiceImpl implements RoleMenusService {

    @Resource
    private RoleMenusRepository roleMenusRepository;

    /**
     * @Title:  add
     * @MethodName:  add
     * @Param: [vo]
     * @Retrun: com.gemframework.admin.model.po.RoleMenus
     * @Description: 添加
     * @Date: 2019-12-05 22:09:15
     */
    @Override
    public RoleMenusVo add(RoleMenusVo vo) {
        RoleMenus roleMenus = new RoleMenus();
        GemBeanUtils.copyProperties(vo,roleMenus);
        roleMenus = roleMenusRepository.save(roleMenus);
        GemBeanUtils.copyProperties(roleMenus,vo);
        return vo;
    }

    /**
     * @Title:  findListAll
     * @MethodName:  findListAll
     * @Param: []
     * @Retrun: java.util.List
     * @Description:  查询所有数据列表
     * @Date: 2019-12-05 22:09:15
     */
    @Override
    public List<RoleMenusVo> findListAll() {
        List<RoleMenus> list = roleMenusRepository.findAll();
        List<RoleMenusVo> vos = GemBeanUtils.copyCollections(list,RoleMenusVo.class);
        return vos;
    }

    /**
     * @Title:  findListByParams
     * @MethodName:  findListByParams
     * @Param: [vo]
     * @Retrun: java.util.List
     * @Description: 动态查询数据
     * //创建匹配器，即使用查询条件
     * @Date: 2019-12-05 22:09:15
     */
    @Override
    public List<RoleMenusVo> findListByParams(RoleMenusVo vo) {
        RoleMenus roleMenus = new RoleMenus();
        GemBeanUtils.copyProperties(vo,roleMenus);
        Example<RoleMenus> example =Example.of(roleMenus);
        List<RoleMenus> list = roleMenusRepository.findAll(example);
        List<RoleMenusVo> vos = GemBeanUtils.copyCollections(list,RoleMenusVo.class);
        return vos;
    }

    /**
     * @Title:  findPageAll
     * @MethodName:  findPageAll
     * @Param: [pageable]
     * @Retrun: org.springframework.data.domain.Page
     * @Description: 【分页】查询所有数据
     * @Date: 2019-12-05 22:09:15
     */
    @Override
    public List<RoleMenusVo> findPageAll(Pageable pageable) {
        Page<RoleMenus> page = roleMenusRepository.findAll(pageable);
        List<RoleMenus> list = page.getContent();
        List<RoleMenusVo> vos = GemBeanUtils.copyCollections(list,RoleMenusVo.class);
        return vos;
    }

    /**
     * @Title:  findPageByParams
     * @MethodName:  findPageByParams
     * @Param: [vo, pageable]
     * @Retrun: org.springframework.data.domain.Page
     * @Description: 【分页】根据条件动态查询
     * @Date: 2019-12-05 22:09:15
     */
    @Override
    public List<RoleMenusVo> findPageByParams(RoleMenusVo vo,Pageable pageable) {
        RoleMenus roleMenus = new RoleMenus();
        GemBeanUtils.copyProperties(vo,roleMenus);
        Example<RoleMenus> example =Example.of(roleMenus);
        Page<RoleMenus> page = roleMenusRepository.findAll(example,pageable);
        List<RoleMenus> list = page.getContent();
        List<RoleMenusVo> vos = GemBeanUtils.copyCollections(list,RoleMenusVo.class);
        return vos;
    }

    /**
     * @Title:  update
     * @MethodName:  update
     * @Param: [vo]
     * @Retrun: com.gemframework.base.model.po.User
     * @Description: 更新数据
     * @Date: 2019-12-05 22:09:15
     */
    @Override
    public RoleMenusVo update(RoleMenusVo vo) {
        Optional<RoleMenus> optional= roleMenusRepository.findById(vo.getId());
        if(optional.isPresent()){
            RoleMenus roleMenus = optional.get();
            GemBeanUtils.copyProperties(vo,roleMenus);
            roleMenus = roleMenusRepository.save(roleMenus);
            GemBeanUtils.copyProperties(roleMenus,vo);
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
     * @Date: 2019-12-05 22:09:15
     */
    @Override
    public void delete(Long id) {
        if(!roleMenusRepository.existsById(id)){
            throw new GemException(ResultCode.DATA_NOT_EXIST);
        }
        roleMenusRepository.deleteById(id);

    }
}

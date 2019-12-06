package com.gemframework.admin.service.impl;

import com.gemframework.base.common.enums.ResultCode;
import com.gemframework.base.common.exception.GemException;
import com.gemframework.base.common.utils.GemBeanUtils;
import com.gemframework.admin.model.po.RoleOrgs;
import com.gemframework.admin.model.vo.RoleOrgsVo;
import com.gemframework.admin.repository.RoleOrgsRepository;
import com.gemframework.admin.service.RoleOrgsService;
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
public class RoleOrgsServiceImpl implements RoleOrgsService {

    @Resource
    private RoleOrgsRepository roleOrgsRepository;

    /**
     * @Title:  add
     * @MethodName:  add
     * @Param: [vo]
     * @Retrun: com.gemframework.admin.model.po.RoleOrgs
     * @Description: 添加
     * @Date: 2019-12-05 22:08:48
     */
    @Override
    public RoleOrgsVo add(RoleOrgsVo vo) {
        RoleOrgs roleOrgs = new RoleOrgs();
        GemBeanUtils.copyProperties(vo,roleOrgs);
        roleOrgs = roleOrgsRepository.save(roleOrgs);
        GemBeanUtils.copyProperties(roleOrgs,vo);
        return vo;
    }

    /**
     * @Title:  findListAll
     * @MethodName:  findListAll
     * @Param: []
     * @Retrun: java.util.List
     * @Description:  查询所有数据列表
     * @Date: 2019-12-05 22:08:48
     */
    @Override
    public List<RoleOrgsVo> findListAll() {
        List<RoleOrgs> list = roleOrgsRepository.findAll();
        List<RoleOrgsVo> vos = GemBeanUtils.copyCollections(list,RoleOrgsVo.class);
        return vos;
    }

    /**
     * @Title:  findListByParams
     * @MethodName:  findListByParams
     * @Param: [vo]
     * @Retrun: java.util.List
     * @Description: 动态查询数据
     * //创建匹配器，即使用查询条件
     * @Date: 2019-12-05 22:08:48
     */
    @Override
    public List<RoleOrgsVo> findListByParams(RoleOrgsVo vo) {
        RoleOrgs roleOrgs = new RoleOrgs();
        GemBeanUtils.copyProperties(vo,roleOrgs);
        Example<RoleOrgs> example =Example.of(roleOrgs);
        List<RoleOrgs> list = roleOrgsRepository.findAll(example);
        List<RoleOrgsVo> vos = GemBeanUtils.copyCollections(list,RoleOrgsVo.class);
        return vos;
    }

    /**
     * @Title:  findPageAll
     * @MethodName:  findPageAll
     * @Param: [pageable]
     * @Retrun: org.springframework.data.domain.Page
     * @Description: 【分页】查询所有数据
     * @Date: 2019-12-05 22:08:48
     */
    @Override
    public List<RoleOrgsVo> findPageAll(Pageable pageable) {
        Page<RoleOrgs> page = roleOrgsRepository.findAll(pageable);
        List<RoleOrgs> list = page.getContent();
        List<RoleOrgsVo> vos = GemBeanUtils.copyCollections(list,RoleOrgsVo.class);
        return vos;
    }

    /**
     * @Title:  findPageByParams
     * @MethodName:  findPageByParams
     * @Param: [vo, pageable]
     * @Retrun: org.springframework.data.domain.Page
     * @Description: 【分页】根据条件动态查询
     * @Date: 2019-12-05 22:08:48
     */
    @Override
    public List<RoleOrgsVo> findPageByParams(RoleOrgsVo vo,Pageable pageable) {
        RoleOrgs roleOrgs = new RoleOrgs();
        GemBeanUtils.copyProperties(vo,roleOrgs);
        Example<RoleOrgs> example =Example.of(roleOrgs);
        Page<RoleOrgs> page = roleOrgsRepository.findAll(example,pageable);
        List<RoleOrgs> list = page.getContent();
        List<RoleOrgsVo> vos = GemBeanUtils.copyCollections(list,RoleOrgsVo.class);
        return vos;
    }

    /**
     * @Title:  update
     * @MethodName:  update
     * @Param: [vo]
     * @Retrun: com.gemframework.base.model.po.User
     * @Description: 更新数据
     * @Date: 2019-12-05 22:08:48
     */
    @Override
    public RoleOrgsVo update(RoleOrgsVo vo) {
        Optional<RoleOrgs> optional= roleOrgsRepository.findById(vo.getId());
        if(optional.isPresent()){
            RoleOrgs roleOrgs = optional.get();
            GemBeanUtils.copyProperties(vo,roleOrgs);
            roleOrgs = roleOrgsRepository.save(roleOrgs);
            GemBeanUtils.copyProperties(roleOrgs,vo);
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
     * @Date: 2019-12-05 22:08:48
     */
    @Override
    public void delete(Long id) {
        if(!roleOrgsRepository.existsById(id)){
            throw new GemException(ResultCode.DATA_NOT_EXIST);
        }
        roleOrgsRepository.deleteById(id);

    }
}

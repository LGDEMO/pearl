package com.gemframework.cms.service.impl;

import com.gemframework.bas.common.enums.ResultCode;
import com.gemframework.bas.common.exception.GemException;
import com.gemframework.bas.common.utils.GemBeanUtils;
import com.gemframework.cms.model.po.Org;
import com.gemframework.cms.model.vo.OrgVo;
import com.gemframework.cms.repository.OrgRepository;
import com.gemframework.cms.service.OrgService;
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
public class OrgServiceImpl implements OrgService {

    @Resource
    private OrgRepository orgRepository;

    /**
     * @Title:  add
     * @MethodName:  add
     * @Param: [vo]
     * @Retrun: com.gemframework.cms.model.po.Org
     * @Description: 添加
     * @Date: 2019-12-05 22:08:20
     */
    @Override
    public OrgVo add(OrgVo vo) {
        Org org = new Org();
        GemBeanUtils.copyProperties(vo,org);
        org = orgRepository.save(org);
        GemBeanUtils.copyProperties(org,vo);
        return vo;
    }

    /**
     * @Title:  findListAll
     * @MethodName:  findListAll
     * @Param: []
     * @Retrun: java.util.List
     * @Description:  查询所有数据列表
     * @Date: 2019-12-05 22:08:20
     */
    @Override
    public List<OrgVo> findListAll() {
        List<Org> list = orgRepository.findAll();
        List<OrgVo> vos = GemBeanUtils.copyCollections(list,OrgVo.class);
        return vos;
    }

    /**
     * @Title:  findListByParams
     * @MethodName:  findListByParams
     * @Param: [vo]
     * @Retrun: java.util.List
     * @Description: 动态查询数据
     * //创建匹配器，即使用查询条件
     * @Date: 2019-12-05 22:08:20
     */
    @Override
    public List<OrgVo> findListByParams(OrgVo vo) {
        Org org = new Org();
        GemBeanUtils.copyProperties(vo,org);
        Example<Org> example =Example.of(org);
        List<Org> list = orgRepository.findAll(example);
        List<OrgVo> vos = GemBeanUtils.copyCollections(list,OrgVo.class);
        return vos;
    }

    /**
     * @Title:  findPageAll
     * @MethodName:  findPageAll
     * @Param: [pageable]
     * @Retrun: org.springframework.data.domain.Page
     * @Description: 【分页】查询所有数据
     * @Date: 2019-12-05 22:08:20
     */
    @Override
    public List<OrgVo> findPageAll(Pageable pageable) {
        Page<Org> page = orgRepository.findAll(pageable);
        List<Org> list = page.getContent();
        List<OrgVo> vos = GemBeanUtils.copyCollections(list,OrgVo.class);
        return vos;
    }

    /**
     * @Title:  findPageByParams
     * @MethodName:  findPageByParams
     * @Param: [vo, pageable]
     * @Retrun: org.springframework.data.domain.Page
     * @Description: 【分页】根据条件动态查询
     * @Date: 2019-12-05 22:08:20
     */
    @Override
    public List<OrgVo> findPageByParams(OrgVo vo,Pageable pageable) {
        Org org = new Org();
        GemBeanUtils.copyProperties(vo,org);
        Example<Org> example =Example.of(org);
        Page<Org> page = orgRepository.findAll(example,pageable);
        List<Org> list = page.getContent();
        List<OrgVo> vos = GemBeanUtils.copyCollections(list,OrgVo.class);
        return vos;
    }

    /**
     * @Title:  update
     * @MethodName:  update
     * @Param: [vo]
     * @Retrun: com.gemframework.bas.model.po.User
     * @Description: 更新数据
     * @Date: 2019-12-05 22:08:20
     */
    @Override
    public OrgVo update(OrgVo vo) {
        Optional<Org> optional= orgRepository.findById(vo.getId());
        if(optional.isPresent()){
            Org org = optional.get();
            GemBeanUtils.copyProperties(vo,org);
            org = orgRepository.save(org);
            GemBeanUtils.copyProperties(org,vo);
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
     * @Date: 2019-12-05 22:08:20
     */
    @Override
    public void delete(Long id) {
        if(!orgRepository.existsById(id)){
            throw new GemException(ResultCode.DATA_NOT_EXIST);
        }
        orgRepository.deleteById(id);

    }
}

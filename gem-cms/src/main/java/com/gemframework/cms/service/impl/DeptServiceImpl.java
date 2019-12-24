package com.gemframework.cms.service.impl;

import com.gemframework.bas.common.enums.ResultCode;
import com.gemframework.bas.common.exception.GemException;
import com.gemframework.bas.common.utils.GemBeanUtils;
import com.gemframework.cms.model.po.Dept;
import com.gemframework.cms.model.po.Menu;
import com.gemframework.cms.model.vo.DeptVo;
import com.gemframework.cms.model.vo.MenuVo;
import com.gemframework.cms.repository.DeptRepository;
import com.gemframework.cms.service.DeptService;
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
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptRepository deptRepository;

    /**
     * @Title:  add
     * @MethodName:  add
     * @Param: [vo]
     * @Retrun: com.gemframework.cms.model.po.Dept
     * @Description: 添加
     * @Date: 2019-12-05 22:07:32
     */
    @Override
    public DeptVo add(DeptVo vo) {
        Dept dept = new Dept();
        GemBeanUtils.copyProperties(vo,dept);
        dept = deptRepository.save(dept);
        GemBeanUtils.copyProperties(dept,vo);
        return vo;
    }

    /**
     * @Title:  findListAll
     * @MethodName:  findListAll
     * @Param: []
     * @Retrun: java.util.List
     * @Description:  查询所有数据列表
     * @Date: 2019-12-05 22:07:32
     */
    @Override
    public List<DeptVo> findListAll() {
        List<Dept> list = deptRepository.findAll();
        List<DeptVo> vos = GemBeanUtils.copyCollections(list,DeptVo.class);
        return vos;
    }

    /**
     * @Title:  findListByParams
     * @MethodName:  findListByParams
     * @Param: [vo]
     * @Retrun: java.util.List
     * @Description: 动态查询数据
     * //创建匹配器，即使用查询条件
     * @Date: 2019-12-05 22:07:32
     */
    @Override
    public List<DeptVo> findListByParams(DeptVo vo) {
        Dept dept = new Dept();
        GemBeanUtils.copyProperties(vo,dept);
        Example<Dept> example =Example.of(dept);
        List<Dept> list = deptRepository.findAll(example);
        List<DeptVo> vos = GemBeanUtils.copyCollections(list,DeptVo.class);
        return vos;
    }

    /**
     * @Title:  findPageAll
     * @MethodName:  findPageAll
     * @Param: [pageable]
     * @Retrun: org.springframework.data.domain.Page
     * @Description: 【分页】查询所有数据
     * @Date: 2019-12-05 22:07:32
     */
    @Override
    public List<DeptVo> findPageAll(Pageable pageable) {
        Page<Dept> page = deptRepository.findAll(pageable);
        List<Dept> list = page.getContent();
        List<DeptVo> vos = GemBeanUtils.copyCollections(list,DeptVo.class);
        return vos;
    }

    /**
     * @Title:  findPageByParams
     * @MethodName:  findPageByParams
     * @Param: [vo, pageable]
     * @Retrun: org.springframework.data.domain.Page
     * @Description: 【分页】根据条件动态查询
     * @Date: 2019-12-05 22:07:32
     */
    @Override
    public List<DeptVo> findPageByParams(DeptVo vo,Pageable pageable) {
        Dept dept = new Dept();
        GemBeanUtils.copyProperties(vo,dept);
        Example<Dept> example =Example.of(dept);
        Page<Dept> page = deptRepository.findAll(example,pageable);
        List<Dept> list = page.getContent();
        List<DeptVo> vos = GemBeanUtils.copyCollections(list,DeptVo.class);
        return vos;
    }

    /**
     * @Title:  update
     * @MethodName:  update
     * @Param: [vo]
     * @Retrun: com.gemframework.bas.model.po.User
     * @Description: 更新数据
     * @Date: 2019-12-05 22:07:32
     */
    @Override
    public DeptVo update(DeptVo vo) {
        Optional<Dept> optional= deptRepository.findById(vo.getId());
        if(optional.isPresent()){
            Dept dept = optional.get();
            GemBeanUtils.copyProperties(vo,dept);
            dept = deptRepository.save(dept);
            GemBeanUtils.copyProperties(dept,vo);
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
     * @Date: 2019-12-05 22:07:32
     */
    @Override
    public void delete(Long id) {
        if(!deptRepository.existsById(id)){
            throw new GemException(ResultCode.DATA_NOT_EXIST);
        }
        deptRepository.deleteById(id);

    }

    /**
     * @Title: 根据ID获取对象
     * @Param: id
     * @Retrun: Entity
     * @Description:
     * @Date: 2019/12/5 22:40
     */
    @Override
    public DeptVo getById(Long id) {
        DeptVo vo = new DeptVo();
        Dept entity = deptRepository.getById(id);
        if(entity!=null){
            GemBeanUtils.copyProperties(entity,vo);
        }
        return vo;
    }
}

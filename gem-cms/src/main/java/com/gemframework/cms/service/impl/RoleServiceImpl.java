package com.gemframework.cms.service.impl;

import com.gemframework.bas.common.enums.ResultCode;
import com.gemframework.bas.common.exception.GemException;
import com.gemframework.bas.common.utils.GemBeanUtils;
import com.gemframework.cms.model.po.*;
import com.gemframework.cms.model.vo.MenuVo;
import com.gemframework.cms.model.vo.OrgVo;
import com.gemframework.cms.model.vo.RoleVo;
import com.gemframework.cms.repository.*;
import com.gemframework.cms.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleRepository roleRepository;
    @Resource
    private OrgRepository orgRepository;
    @Resource
    private MenuRepository menuRepository;
    @Resource
    private RoleOrgsRepository roleOrgsRepository;
    @Resource
    private RoleMenusRepository roleMenusRepository;

    /**
     * @Title:  add
     * @MethodName:  add
     * @Param: [vo]
     * @Retrun: com.gemframework.cms.model.po.Role
     * @Description: 添加
     * @Date: 2019-12-05 22:10:59
     */
    @Override
    public RoleVo save(RoleVo vo) {
        Role role = new Role();
        GemBeanUtils.copyProperties(vo,role);
        role = roleRepository.save(role);
        GemBeanUtils.copyProperties(role,vo);
        return vo;
    }

    /**
     * @Title:  findListAll
     * @MethodName:  findListAll
     * @Param: []
     * @Retrun: java.util.List
     * @Description:  查询所有数据列表
     * @Date: 2019-12-05 22:10:59
     */
    @Override
    public List<RoleVo> findListAll() {
        List<RoleVo> roleVos = new ArrayList<>();
        List<Role> list = roleRepository.findAll();
        for(Role roles:list){
            RoleVo roleVo = new RoleVo();
            GemBeanUtils.copyProperties(roles,roleVo);
            List<Org> orgsList = new ArrayList<>();
            List<RoleOrgs> roleOrgs = roleOrgsRepository.findListByRoleId(roles.getId());
            //查询roleOrgs
            for(RoleOrgs orgs:roleOrgs){
                Org org = orgRepository.getById(orgs.getOrgId());
                orgsList.add(org);
            }
            roles.setOrgs(orgsList);
            List<OrgVo> orgVos = GemBeanUtils.copyCollections(orgsList,OrgVo.class);
            roleVo.setOrgs(orgVos);

            //查询roleMenus
            List<Menu> menusList = new ArrayList<>();
            List<RoleMenus> roleMenus = roleMenusRepository.findListByRoleId(roles.getId());
            for(RoleMenus menus:roleMenus){
                Menu menu = menuRepository.getById(menus.getMenuId());
                menusList.add(menu);
            }
            roles.setMenus(menusList);

            List<MenuVo> menuVos = GemBeanUtils.copyCollections(menusList,MenuVo.class);
            roleVo.setMenus(menuVos);

            roleVos.add(roleVo);
        }
        return roleVos;
    }

    /**
     * @Title:  findListByParams
     * @MethodName:  findListByParams
     * @Param: [vo]
     * @Retrun: java.util.List
     * @Description: 动态查询数据
     * //创建匹配器，即使用查询条件
     * @Date: 2019-12-05 22:10:59
     */
    @Override
    public List<RoleVo> findListByParams(RoleVo vo) {
        Role role = new Role();
        GemBeanUtils.copyProperties(vo,role);
        Example<Role> example =Example.of(role);
        List<Role> list = roleRepository.findAll(example);
        List<RoleVo> vos = GemBeanUtils.copyCollections(list,RoleVo.class);
        return vos;
    }

    /**
     * @Title:  findPageAll
     * @MethodName:  findPageAll
     * @Param: [pageable]
     * @Retrun: org.springframework.data.domain.Page
     * @Description: 【分页】查询所有数据
     * @Date: 2019-12-05 22:10:59
     */
    @Override
    public List<RoleVo> findPageAll(Pageable pageable) {
        Page<Role> page = roleRepository.findAll(pageable);
        List<Role> list = page.getContent();
        List<RoleVo> vos = GemBeanUtils.copyCollections(list,RoleVo.class);
        return vos;
    }

    /**
     * @Title:  findPageByParams
     * @MethodName:  findPageByParams
     * @Param: [vo, pageable]
     * @Retrun: org.springframework.data.domain.Page
     * @Description: 【分页】根据条件动态查询
     * @Date: 2019-12-05 22:10:59
     */
    @Override
    public List<RoleVo> findPageByParams(RoleVo vo,Pageable pageable) {
        Role role = new Role();
        GemBeanUtils.copyProperties(vo,role);
        Example<Role> example =Example.of(role);
        Page<Role> page = roleRepository.findAll(example,pageable);
        List<Role> list = page.getContent();
        List<RoleVo> vos = GemBeanUtils.copyCollections(list,RoleVo.class);
        return vos;
    }

    /**
     * @Title:  update
     * @MethodName:  update
     * @Param: [vo]
     * @Retrun: com.gemframework.bas.model.po.User
     * @Description: 更新数据
     * @Date: 2019-12-05 22:10:59
     */
    @Override
    public RoleVo update(RoleVo vo) {
        Optional<Role> optional= roleRepository.findById(vo.getId());
        if(optional.isPresent()){
            Role role = optional.get();
            GemBeanUtils.copyProperties(vo,role);
            role = roleRepository.save(role);
            GemBeanUtils.copyProperties(role,vo);
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
     * @Date: 2019-12-05 22:10:59
     */
    @Override
    public void delete(Long id) {
        if(!roleRepository.existsById(id)){
            throw new GemException(ResultCode.DATA_NOT_EXIST);
        }
        roleRepository.deleteById(id);

    }

    /**
     * @Title: 根据ID获取对象
     * @Param: id
     * @Retrun: Entity
     * @Description:
     * @Date: 2019/12/5 22:40
     */
    @Override
    public RoleVo getById(Long id) {
        RoleVo roleVo = null;
        Role role = roleRepository.getById(id);
        if(role != null){
            roleVo =  new RoleVo();
            //查询roleOrgs
            List<Org> orgsList = null;
            List<RoleOrgs> roleOrgs = roleOrgsRepository.findListByRoleId(id);
            for(RoleOrgs orgs:roleOrgs){
                Org org = orgRepository.getById(orgs.getOrgId());
                orgsList = new ArrayList<>();
                orgsList.add(org);
            }
            role.setOrgs(orgsList);
            //查询roleMenus
            List<Menu> menusList = null;
            List<RoleMenus> roleMenus = roleMenusRepository.findListByRoleId(id);
            for(RoleMenus menus:roleMenus){
                Menu menu = menuRepository.getById(menus.getRoleId());
                menusList = new ArrayList<>();
                menusList.add(menu);
            }
            role.setMenus(menusList);
            GemBeanUtils.copyProperties(role,roleVo);
        }
        return roleVo;
    }

    @Override
    public RoleVo getByFlag(String flag) {
        RoleVo roleVo = null;
        Role role = roleRepository.getByFlag(flag);
        if(role != null){
            roleVo =  new RoleVo();
            //查询roleOrgs
            List<Org> orgsList = null;
            List<RoleOrgs> roleOrgs = roleOrgsRepository.findListByRoleId(role.getId());
            for(RoleOrgs orgs:roleOrgs){
                Org org = orgRepository.getById(orgs.getOrgId());
                orgsList = new ArrayList<>();
                orgsList.add(org);
            }
            role.setOrgs(orgsList);
            //查询roleMenus
            List<Menu> menusList = null;
            List<RoleMenus> roleMenus = roleMenusRepository.findListByRoleId(role.getId());
            for(RoleMenus menus:roleMenus){
                Menu menu = menuRepository.getById(menus.getRoleId());
                menusList = new ArrayList<>();
                menusList.add(menu);
            }
            role.setMenus(menusList);
            GemBeanUtils.copyProperties(role,roleVo);
        }
        return roleVo;
    }

}

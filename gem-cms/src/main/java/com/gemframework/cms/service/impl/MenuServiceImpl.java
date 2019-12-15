package com.gemframework.cms.service.impl;

import com.gemframework.bas.common.enums.ResultCode;
import com.gemframework.bas.common.exception.GemException;
import com.gemframework.bas.common.utils.GemBeanUtils;
import com.gemframework.cms.model.po.Menu;
import com.gemframework.cms.model.po.Role;
import com.gemframework.cms.model.po.RoleMenus;
import com.gemframework.cms.model.vo.MenuVo;
import com.gemframework.cms.model.vo.RoleVo;
import com.gemframework.cms.repository.MenuRepository;
import com.gemframework.cms.repository.RoleMenusRepository;
import com.gemframework.cms.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuRepository menuRepository;
    @Resource
    private RoleMenusRepository roleMenusRepository;

    /**
     * @Title:  add
     * @MethodName:  add
     * @Param: [vo]
     * @Retrun: com.gemframework.cms.model.po.Menu
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

    @Override
    public List<MenuVo> findListByRoleId(Long roleId) {
        List<MenuVo> list = new ArrayList<>();
        List<RoleMenus> roleMenus = roleMenusRepository.findListByRoleId(roleId);
        for(RoleMenus role:roleMenus){
            Long menuId = role.getMenuId();
            MenuVo vo = GemBeanUtils.copyProperties(menuRepository.getById(menuId),MenuVo.class);
            list.add(vo);
        }
        return menusToTree(list);
    }

    @Override
    public List<MenuVo> findListByRoles(List<RoleVo> roles) {
        List<MenuVo> list = new ArrayList<>();
        List<Long> roleIds = new ArrayList<>();
        for(RoleVo role:roles){
            roleIds.add(role.getId());
        }
        log.info("====================="+roleIds);
        List<RoleMenus> roleMenus = roleMenusRepository.findListByRoleIds(roleIds);
        for(RoleMenus role:roleMenus){
            Long menuId = role.getMenuId();
            MenuVo vo = GemBeanUtils.copyProperties(menuRepository.getById(menuId),MenuVo.class);
            list.add(vo);
        }
        //list去重
        Set set = new HashSet();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        Collections.sort(list);
        return menusToTree(list);
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
     * @Retrun: com.gemframework.bas.model.po.User
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
    /**
     * @Title: 根据ID获取对象
     * @Param: id
     * @Retrun: Entity
     * @Description:
     * @Date: 2019/12/5 22:40
     */
    @Override
    public MenuVo getById(Long id) {
        MenuVo vo = new MenuVo();
        Menu entity = menuRepository.getById(id);
        GemBeanUtils.copyProperties(entity,vo);
        return vo;
    }


    /**
     * @Title: 将list格式是权限数据，转化成tree格式的权限数据。
     * @Param: [vos]
     * @Retrun: java.util.List<com.gemframework.cms.model.vo.MenuVo>
     * @Description:
     * @Date: 2019/12/15 13:24
     */
    private List<MenuVo> menusToTree(List<MenuVo> vos){

        List<MenuVo> menuVos = new ArrayList<MenuVo>();
        //list to tree
        for (MenuVo menus : vos) {
            if(menus.getPid() == null){
                menuVos.add(menus);
            }
            for (MenuVo subMenus : vos) {
                if(subMenus.getPid()!=null){
                    if(subMenus.getPid().equals(menus.getId())){
                        if(menus.getChilds() == null){
                            List<MenuVo> childs = new ArrayList<MenuVo>();
                            childs.add(subMenus);
                            menus.setChilds(childs);
                        }else{
                            menus.getChilds().add(subMenus);
                        }
                    }
                }
            }
        }
        return menuVos;
    }
}

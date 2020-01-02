package com.gemframework.cms.service.impl;

import com.gemframework.bas.common.enums.ResultCode;
import com.gemframework.bas.common.exception.GemException;
import com.gemframework.bas.common.utils.GemBeanUtils;
import com.gemframework.cms.common.enums.MenuType;
import com.gemframework.cms.model.po.Menu;
import com.gemframework.cms.model.po.RoleMenus;
import com.gemframework.cms.model.vo.MenuVo;
import com.gemframework.cms.model.vo.RoleVo;
import com.gemframework.cms.repository.MenuRepository;
import com.gemframework.cms.repository.RoleMenusRepository;
import com.gemframework.cms.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.ListUtils;

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
    public MenuVo save(MenuVo vo) {
        Menu menu = new Menu();
        GemBeanUtils.copyProperties(vo,menu);
        menu = menuRepository.save(menu);

        //更新id_path,series
        MenuVo parentVo = getById(vo.getPid());
        String idPath = String.valueOf(menu.getId());
        if(menu.getId()<10){
            idPath = "0"+menu.getId();
        }
        if(parentVo != null && parentVo.getIdPath() != null){
            idPath = parentVo.getIdPath()+"-"+idPath;
        }
        //设置idpath
        menu.setIdPath(idPath);

        //设置series
        String series = menu.getIdPath();
        if(series.indexOf("-")>0){
            series = series.substring(0,series.indexOf("-"));
        }
        menu.setSeries(series);
        //更新
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
        for(MenuVo menuVo :vos){
            if(menuVo!=null && menuVo.getIdPath()!=null){
                if(menuVo.getIdPath().lastIndexOf("-")>0){
                    menuVo.setParentIdPath(menuVo.getIdPath().substring(0,menuVo.getIdPath().lastIndexOf("-")));
                }
            }
        }
        return vos;
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
    public List<MenuVo> findLinkedListAll() {
        List<Menu> list = menuRepository.findAll();
        List<MenuVo> vos = GemBeanUtils.copyCollections(list,MenuVo.class);
        for(MenuVo menuVo :vos){
            if(menuVo!=null && menuVo.getIdPath()!=null){
                if(menuVo.getIdPath().lastIndexOf("-")>0){
                    menuVo.setParentIdPath(menuVo.getIdPath().substring(0,menuVo.getIdPath().lastIndexOf("-")));
                }
            }
        }
        //通过链表重新排序
        vos = getMenuLinkedList(vos);
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
        for(MenuVo menuVo :vos){
            if(menuVo!=null && menuVo.getIdPath()!=null){
                if(menuVo.getIdPath().lastIndexOf("-")>0){
                    menuVo.setParentIdPath(vo.getIdPath().substring(0,vo.getIdPath().lastIndexOf("-")));
                }
            }
        }
        return vos;
    }

    @Override
    public List<MenuVo> findListByRoleId(Long roleId) {
        List<RoleMenus> roleMenus = roleMenusRepository.findListByRoleId(roleId);
        List<MenuVo> list = findMenusByRole(roleMenus);
        Collections.sort(list);
        return list;
    }

    /**
     * 获取菜单列表
     * @return
     */
    @Override
    public List<MenuVo> findListAllByType(MenuType type) {
        List<Menu> list = menuRepository.findListByType(type.getCode());
        List<MenuVo> vos = GemBeanUtils.copyCollections(list,MenuVo.class);
        //list排序
        Collections.sort(vos);
        return vos;
    }

    /**
     * 获取资源列表
     * @param roles
     * @return
     */
    @Override
    public List<MenuVo> findListByRoles(List<RoleVo> roles) {
        List<Long> roleIds = new ArrayList<>();
        for(RoleVo role:roles){
            roleIds.add(role.getId());
        }
        List<RoleMenus> roleMenus = roleMenusRepository.findListByRoleIds(roleIds);
        List<MenuVo> list = findMenusByRole(roleMenus);
        //list去重
        Set set = new HashSet();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        Collections.sort(list);
        return list;
    }

    /**
     * 获取树列表
     * @param roles
     * @return
     */
    @Override
    public List<MenuVo> findTreeByRoles(List<RoleVo> roles) {
        List<Long> roleIds = new ArrayList<>();
        for(RoleVo role:roles){
            roleIds.add(role.getId());
        }
        List<RoleMenus> roleMenus = roleMenusRepository.findListByRoleIds(roleIds);
        List<MenuVo> list = findMenusByRole(roleMenus);
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
        if(entity!=null){
            GemBeanUtils.copyProperties(entity,vo);
            if(vo.getPid()!=null){
                vo.setPname("根目录");
                //父级信息
                entity = menuRepository.getById(vo.getPid());
                if(entity!=null){
                    vo.setPname(entity.getName());
                }
            }
        }
        return vo;
    }


    /**
     * @Title: 将list格式是权限数据，转化成tree格式的权限数据。
     * @Param: [vos]
     * @Retrun: java.util.List<com.gemframework.cms.model.vo.MenuVo>
     * @Description:
     * @Date: 2019/12/15 13:24
     */
    public static List<MenuVo> menusToTree(List<MenuVo> treeNodes){
        List<MenuVo> trees = new ArrayList<MenuVo>();
        for (MenuVo treeNode : treeNodes) {
            if (0 == (treeNode.getPid())) {
                trees.add(treeNode);
            }
            for (MenuVo it : treeNodes) {
                if (it.getPid() == treeNode.getId()) {
                    if (treeNode.getChilds() == null) {
                        treeNode.setChilds(new ArrayList<MenuVo>());
                    }
                    treeNode.getChilds().add(it);
                }
            }
        }
        return trees;

    }

    private List findMenusByRole(List<RoleMenus> roleMenus){
        List<MenuVo> list = new ArrayList<>();
        for(RoleMenus role:roleMenus){
            Long menuId = role.getMenuId();
            Menu menu = menuRepository.getById(menuId, MenuType.MENU.getCode());
            if(menu != null){
                MenuVo vo = GemBeanUtils.copyProperties(menu,MenuVo.class);
                list.add(vo);
            }
        }
        return list;
    }

    /**
     * 获取菜单列表
     * @param list
     * @return
     *
     */
    private List<MenuVo> getMenuLinkedList(List<MenuVo> list) {
        //对数据排序 start -----treeTable不知道怎么排序，如果可以的话，在前端用js排序比这个效率要高，后面可以优化
        List<MenuVo> listSorted = new LinkedList<>();
        if (!ListUtils.isEmpty(list)){
            for (MenuVo o:list){
                sortNodeInfo(o,list,listSorted);
            }
        }
        //对数据排序 end
        return listSorted;
    }

    /**
     * 通过链表对节点信息排序
     */
    private void sortNodeInfo(MenuVo vo,List<MenuVo> list,List<MenuVo> listSorted) {
        if (listSorted.lastIndexOf(vo) > 0) {
            return;
        }
        listSorted.add(vo);
        Long id = vo.getId();
        if (id == null) {
            return;
        }
        for (MenuVo m : list) {
            if (id == m.getPid()) {
                sortNodeInfo(m, list, listSorted);
            }
        }
    }

    public static void main(String[] args) {
        String aa = "00-01-12-33";
        System.out.println("=="+aa.indexOf("#"));
    }
}

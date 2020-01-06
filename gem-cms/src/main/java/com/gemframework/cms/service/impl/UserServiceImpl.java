package com.gemframework.cms.service.impl;

import com.gemframework.bas.common.constant.GemConstant;
import com.gemframework.cms.model.po.*;
import com.gemframework.cms.model.vo.DeptVo;
import com.gemframework.cms.model.vo.RoleVo;
import com.gemframework.cms.model.vo.UserRolesVo;
import com.gemframework.cms.model.vo.UserVo;
import com.gemframework.cms.model.vo.response.PageInfo;
import com.gemframework.cms.repository.*;
import com.gemframework.cms.service.RoleService;
import com.gemframework.cms.service.UserRolesService;
import com.gemframework.cms.service.UserService;
import com.gemframework.bas.common.enums.ResultCode;
import com.gemframework.bas.common.exception.GemException;
import com.gemframework.bas.common.utils.GemBeanUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.*;

import static com.gemframework.bas.common.constant.GemConstant.System.DEF_PASSWORD;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private DeptRepository deptRepository;

    @Resource
    private RoleRepository roleRepository;

    @Resource
    private UserRolesRepository userRolesRepository;


    @Resource
    private RoleService roleService;

    @Resource
    private UserRolesService userRolesService;

    @Override
    public boolean exist(UserVo vo) {
        //新增
        if(vo.getId() == null || vo.getId() == 0){
            if(null != userRepository.getByPhone(vo.getPhone()) ||
                    null != userRepository.getByUserName(vo.getUsername())){
                return false;
            }
        }else{
            if(null != userRepository.getByPhone(vo.getPhone(),vo.getId())){
                return false;
            }
            if(null != userRepository.getByUserName(vo.getUsername(),vo.getId())){
                return false;
            }
        }
        return true;
    }

    /**
     * @Title:  add
     * @MethodName:  add
     * @Param: [vo]
     * @Retrun: com.gemframework.bas.model.po.User
     * @Description: 添加
     * @Date: 2019/11/29 20:44
     */
    @Override
    public UserVo save(UserVo vo) {
        if(!exist(vo)){
            throw new GemException(ResultCode.USER_EXIST);
        }
        User user = new User();
        //新增
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(vo.getId() == null || vo.getId() == 0){
            if(vo.getPassword() == null || vo.getPassword().equals("")){
                //如果是新增 默认设置密码123456
                user.setPassword(passwordEncoder.encode(DEF_PASSWORD));
            }
        }else{
            user = userRepository.getById(vo.getId());
        }

        if(user != null){
            GemBeanUtils.copyProperties(vo,user);
        }
        user.setPassword(passwordEncoder.encode(vo.getPassword()));
        user = userRepository.save(user);
        GemBeanUtils.copyProperties(user,vo);

//        //第二步：保存用户关联部门
//        List<DeptVo> deptVoList = vo.getDepts();
//        if(deptVoList != null){
//            for(DeptVo deptVo:deptVoList){
//                UserDepts userDepts = new UserDepts();
//                userDepts.setUserId(user.getId());
//                userDepts.setDeptId(deptVo.getId());
//                userDeptsRepository.save(userDepts);
//            }
//        }

        //第三步：保存用户关联角色
        List<RoleVo> roleVoList = vo.getRoles();
        if(roleVoList != null){
            userRolesRepository.deleteByUserId(user.getId());
            for(RoleVo roleVo:roleVoList){
                UserRoles userRoles = new UserRoles();
                userRoles.setUserId(user.getId());
                userRoles.setRoleId(roleVo.getId());
                userRolesRepository.save(userRoles);
            }
        }
        return vo;
    }

    /**
     * @Title:  findListAll
     * @MethodName:  findListAll
     * @Param: []
     * @Retrun: java.util.List
     * @Description:  查询所有数据列表
     * @Date: 2019/11/29 20:44
     */
    @Override
    public List findListAll() {
        List<User> list = userRepository.findAll();
        return list;
    }

    /**
     * @Title:  findListByParams
     * @MethodName:  findListByParams
     * @Param: [vo]
     * @Retrun: java.util.List
     * @Description: 动态查询数据
     * //创建匹配器，即如何使用查询条件
     * @Date: 2019/11/29 20:39
     */
    @Override
    public List findListByParams(UserVo vo) {
        User user = new User();
        GemBeanUtils.copyProperties(vo,user);
        Example<User> example =Example.of(user);
        List<User> list = userRepository.findAll(example);
        return list;
    }

    /**
     * @Title:  findPageAll
     * @MethodName:  findPageAll
     * @Param: [pageable]
     * @Retrun: org.springframework.data.domain.Page
     * @Description: 【分页】查询所有数据
     * @Date: 2019/11/29 20:42
     */
    @Override
    public Page findPageAll(Pageable pageable) {
        Page<User> page = userRepository.findAll(pageable);
        return page;
    }

    /**
     * @Title:  findPageByParams
     * @MethodName:  findPageByParams
     * @Param: [vo, pageable]
     * @Retrun: org.springframework.data.domain.Page
     * @Description: 【分页】根据条件动态查询
     * @Date: 2019/11/29 20:42
     */
    @Override

    public PageInfo<UserVo> findPageByParams(UserVo vo,Pageable pageable) {
        User user = new User();
        GemBeanUtils.copyProperties(vo,user);
        Example<User> example =Example.of(user);
        Page<User> page = userRepository.findAll(example,pageable);
        List<User> list = page.getContent();
        List<UserVo> vos = GemBeanUtils.copyCollections(list,UserVo.class);
        PageInfo<UserVo> pageInfo = new PageInfo();
        pageInfo.setRows(vos);
        pageInfo.setTotal(page.getTotalElements());
        return pageInfo;
    }

    @Override
    public UserVo getByLoginName(String loginName) {
        UserVo vo = new UserVo();
        User user = userRepository.getByUserName(loginName);
        if(user == null){
            user = userRepository.getByPhone(loginName);
        }
        GemBeanUtils.copyProperties(user,vo);
        return vo;
    }


    /**
     * @Title:  delete
     * @MethodName:  delete
     * @Param: [id]
     * @Retrun: void
     * @Description: 根据ID删除数据
     * @Date: 2019/11/29 20:43
     */
    @Override
    public void delete(Long id) {
        if(!userRepository.existsById(id)){
            throw new GemException(ResultCode.DATA_NOT_EXIST);
        }
        userRepository.deleteById(id);
    }

    /**
     * @Title:  deleteBitch
     * @MethodName:  delete
     * @Param: [id]
     * @Retrun: void
     * @Description: 根据ID删除数据
     * @Date: 2019/11/29 20:43
     */
    @Override
    public void deleteBatch(List<UserVo> vos) {
        List<User> list = GemBeanUtils.copyCollections(vos,User.class);
        userRepository.deleteInBatch(list);
    }

    /**
     * @Title:  deleteAll
     * @MethodName:  deleteAll
     * @Param: [id]
     * @Retrun: void
     * @Description: 删除全部
     * @Date: 2019/11/29 20:43
     */
    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public UserVo getById(Long id) {
        UserVo vo = null;
        User entity = userRepository.getById(id);
        if(entity != null){
            vo = new UserVo();
            //查询userRoles
            List<Role> rolesList = new ArrayList<>();
            List<UserRoles> userRoles = userRolesRepository.findListByUserId(id);
            for(UserRoles roles:userRoles){
                Role role = roleRepository.getById(roles.getRoleId());
                rolesList.add(role);
            }
            entity.setRoles(rolesList);
            GemBeanUtils.copyProperties(entity,vo);
            Dept dept = deptRepository.getById(vo.getDept_id());
            vo.setDept(dept);
        }
        return vo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("登录的用户名: {}", username);
        User gemuser = userRepository.getByUserName(username);
        if(gemuser == null){
            gemuser = userRepository.getByPhone(username);
            if(gemuser == null){
                throw new UsernameNotFoundException("未查询到用户："+username+"信息！");
            }
        }
        //查询权限信息
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = createAuthorities(gemuser.getId());
        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        org.springframework.security.core.userdetails.User user
                = new org.springframework.security.core.userdetails.User(username,gemuser.getPassword(),
                        true,
                true,
                true,
                true,
                simpleGrantedAuthorities);

        return user;
    }


    /**
     * @Title: 查询权限列表
     * @Param: [userId]
     * @Retrun: java.util.List<org.springframework.security.core.authority.SimpleGrantedAuthority>
     * @Description:
     * @Date: 2019/12/10 11:22
     */
    private List<SimpleGrantedAuthority> createAuthorities(Long userId){
        List<UserRolesVo> userRoles = userRolesService.findListByUserId(userId);
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (UserRolesVo userRolesVo : userRoles) {
            RoleVo role = roleService.getById(userRolesVo.getRoleId());
            if(role != null){
                simpleGrantedAuthorities.add(new SimpleGrantedAuthority(GemConstant.Auth.ROLE_PREFIX +role.getFlag()));
            }
        }
        log.info("当前登录用户角色:{}",simpleGrantedAuthorities);
        return simpleGrantedAuthorities;
    }

}

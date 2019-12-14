package com.gemframework.cms.service.impl;

import com.gemframework.bas.common.constant.GemConstant;
import com.gemframework.cms.model.vo.RoleVo;
import com.gemframework.cms.model.vo.UserRolesVo;
import com.gemframework.cms.model.vo.UserVo;
import com.gemframework.cms.model.po.User;
import com.gemframework.cms.repository.UserRepository;
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


import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private RoleService roleService;

    @Resource
    private UserRolesService userRolesService;

    /**
     * @Title:  add
     * @MethodName:  add
     * @Param: [vo]
     * @Retrun: com.gemframework.bas.model.po.User
     * @Description: 添加
     * @Date: 2019/11/29 20:44
     */
    @Override
    public UserVo add(UserVo vo) {
        if(null != userRepository.findByPhone(vo.getPhone()) ||
                null != userRepository.findByUserName(vo.getUsername())){
            throw new GemException(ResultCode.USER_EXIST);
        }
        User user = new User();
        GemBeanUtils.copyProperties(vo,user);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(vo.getPassword()));
        user = userRepository.save(user);
        GemBeanUtils.copyProperties(user,vo);
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
    public Page findPageByParams(UserVo vo,Pageable pageable) {
        User user = new User();
        GemBeanUtils.copyProperties(vo,user);
        Example<User> example =Example.of(user);
        Page<User> page = userRepository.findAll(example,pageable);
        return page;
    }

    @Override
    public UserVo getByLoginName(String loginName) {
        UserVo vo = new UserVo();
        User user = userRepository.findByUserName(loginName);
        if(user == null){
            user = userRepository.findByPhone(loginName);
        }
        GemBeanUtils.copyProperties(user,vo);
        return vo;
    }

    /**
     * @Title:  update
     * @MethodName:  update
     * @Param: [vo]
     * @Retrun: com.gemframework.bas.model.po.User
     * @Description: 更新数据
     * @Date: 2019/11/29 20:42
     */
    @Override
    public UserVo update(UserVo vo) {
        Optional<User> optional= userRepository.findById(vo.getId());
        if(optional.isPresent()){
            User user = optional.get();
            GemBeanUtils.copyProperties(vo,user);
            user = userRepository.save(user);
            GemBeanUtils.copyProperties(user,vo);
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("登录的用户名: {}", username);
        User gemuser = userRepository.findByUserName(username);
        if(gemuser == null){
            gemuser = userRepository.findByPhone(username);
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
        List<UserRolesVo> userRoles = userRolesService.findListByParams(new UserRolesVo(userId));
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (UserRolesVo userRolesVo : userRoles) {
            RoleVo role = roleService.getById(userRolesVo.getRoleId());
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(GemConstant.Auth.ROLE_PREFIX +role.getFlag()));
        }
        return simpleGrantedAuthorities;
    }

}

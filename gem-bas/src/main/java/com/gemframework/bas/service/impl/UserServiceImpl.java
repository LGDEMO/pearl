package com.gemframework.bas.service.impl;

import com.gemframework.bas.common.enums.ResultCode;
import com.gemframework.bas.common.exception.GemException;
import com.gemframework.bas.model.po.User;
import com.gemframework.bas.model.vo.UserVo;
import com.gemframework.bas.repository.UserRepository;
import com.gemframework.bas.service.UserService;
import com.gemframework.bas.common.utils.GemBeanUtils;
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
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    /**
     * @Title:  add
     * @MethodName:  add
     * @Param: [vo]
     * @Retrun: com.gemframework.bas.model.po.User
     * @Description: 添加
     * @Date: 2019/11/29 20:44
     */
    @Override
    public User add(UserVo vo) {
        if(null != userRepository.findByPhone(vo.getUserPhone())){
            throw new GemException(ResultCode.USER_EXIST);
        }
        User user = new User();
        GemBeanUtils.copyProperties(vo,user);
        userRepository.save(user);
        return user;
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
     *         ExampleMatcher matcher = ExampleMatcher.matching()
     *                 .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.startsWith())//模糊查询匹配开头，即{username}%
     *                 .withMatcher("address" ,ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
     *                 .withIgnorePaths("password");//忽略字段，即不管password是什么值都不加入查询条件
     *         //创建实例
     *         User user = new User();
     *         GemBeanUtils.copyProperties(vo,user);
     *         Example<User> example =Example.of(user,matcher);
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

    /**
     * @Title:  update
     * @MethodName:  update
     * @Param: [vo]
     * @Retrun: com.gemframework.bas.model.po.User
     * @Description: 更新数据
     * @Date: 2019/11/29 20:42
     */
    @Override
    public User update(UserVo vo) {
        Optional<User> optional= userRepository.findById(vo.getId());
        if(optional.isPresent()){
            User user = optional.get();
            GemBeanUtils.copyProperties(vo,user);
            userRepository.save(user);
            return user;
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
}

package com.gemframework.base.service.impl;

import com.gemframework.base.model.po.User;
import com.gemframework.base.model.vo.UserVo;
import com.gemframework.base.repository.UserRepository;
import com.gemframework.base.service.UserService;
import com.gemframework.base.util.GemBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;


    @Override
    public User add(UserVo vo) {
        User user = new User();
        GemBeanUtils.copyProperties(vo,user);
        userRepository.save(user);
        return user;
    }

    @Override
    public List findAll() {
        List<User> list = userRepository.findAll();
        return list;
    }

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

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}

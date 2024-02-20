package com.fastDev4j.system.web.service.impl;

import com.fastDev4j.system.web.entity.User;
import com.fastDev4j.system.web.mapper.UserMapper;
import com.fastDev4j.system.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.selectList(null);
    }

    @Override
    public User get(Integer userId) {
        return null;
    }

    @Override
    public int add(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(Integer userId) {
        return 0;
    }
}

package com.fastDev4j.system.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fastDev4j.system.web.entity.User;
import com.fastDev4j.system.web.mapper.UserMapper;
import com.fastDev4j.system.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl  implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return userMapper.selectOne(queryWrapper);
    }
}

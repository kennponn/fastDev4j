package com.fastDev4j.system.web.service;

import com.fastDev4j.system.web.entity.User;

import java.util.List;

public interface UserService {
    List<User> list();
    User get(Integer userId);
    int add(User user);
    int update(User user);
    int delete(Integer userId);
}

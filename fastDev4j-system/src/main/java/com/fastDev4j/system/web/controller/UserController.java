package com.fastDev4j.system.web.controller;

import com.fastDev4j.core.domain.Result;
import com.fastDev4j.system.web.entity.User;
import com.fastDev4j.system.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("list")
    public Result list() {
        return Result.success(userService.list());
    }

    @PostMapping("add")
    public Result add(@RequestBody User user) {

        return Result.success(userService.add(user));
    }
    
}

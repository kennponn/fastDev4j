package com.fastDev4j.system.web.controller;

import com.fastDev4j.core.domain.Result;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("/login")
    public Result login() {
        return Result.success();
    }
    public Result getInfo() {
        return Result.success();
    }
    public Result logout() {
        return Result.success();
    }
}

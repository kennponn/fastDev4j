package com.fastDev4j.system.web.controller;

import com.fastDev4j.core.domain.Result;

import com.fastDev4j.system.web.entity.User;
import com.fastDev4j.system.web.service.LoginService;
import com.fastDev4j.system.web.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisUtils redisUtils;
    @RequestMapping("/login")
    public Result login(String username,String password) {
        User user = loginService.login(username);
        if (user == null) {
            return Result.error("账号未注册");
        } else {
            //MD5加密
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            if (!md5Password.equals(user.getPassword())) {
                return Result.error("密码错误");
            }
        }
        //生成token
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        //保存token,key为token,value为id,有效期为1个小时
        redisUtils.set(token, user.getUserId(), 10, TimeUnit.MINUTES);
        return Result.success("登陆成功",token);

    }
    public Result getInfo() {
        return Result.success();
    }
    @GetMapping(value = "/logout")
    public Result tokenLogout(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        //删除redis的token
        redisUtils.del(token);
        return Result.success("退出成功",null);
    }
}

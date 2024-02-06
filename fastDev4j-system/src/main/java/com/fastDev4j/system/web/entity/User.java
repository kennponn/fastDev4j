package com.fastDev4j.system.web.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fastDev4j.core.entity.BaseEntity;

import java.util.List;

@TableName("sys_users")
public class User extends BaseEntity {
    private Integer userId;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String mobile;
    private Integer status;
    private String createBy;
    private String createDate;
    private List<Integer> deptIds;
    private List<Integer> roleIds;
    private List<Role> roles;
    private List<Dept> depts;




}

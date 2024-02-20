package com.fastDev4j.system.web.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fastDev4j.core.entity.BaseEntity;
import lombok.Data;

import java.util.List;

@TableName("sys_users")
@Data
public class User extends BaseEntity {
    private Integer userId;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String mobile;
    private Integer status;
    @TableField(exist = false)
    private List<Integer> deptIds;
    @TableField(exist = false)
    private List<Integer> roleIds;
    @TableField(exist = false)
    private List<Role> roles;
    @TableField(exist = false)
    private List<Dept> depts;




}

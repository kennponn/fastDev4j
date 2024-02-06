package com.fastDev4j.system.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("sys_depts")
public class Dept {
    private Integer deptId;
    private Integer parentId;
    private String deptName;
}

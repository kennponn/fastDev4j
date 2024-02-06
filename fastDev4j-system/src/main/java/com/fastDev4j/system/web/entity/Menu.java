package com.fastDev4j.system.web.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("sys_menus")
public class Menu {

    private Integer menuId;
    private Integer parentId;
    private String menuName;
}

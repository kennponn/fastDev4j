package com.fastDev4j.core.entity;

import lombok.Data;

@Data
public class BaseEntity {
    private String createBy;
    private String createDate;
    private String updateBy;
    private String updateDate;
    private Integer status;
    private Integer sort_id;
}

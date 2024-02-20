package com.fastDev4j.core.entity;

import lombok.Data;
import lombok.Getter;

@Data
public class BaseEntity {
    private String createBy;
    private String createDate;
    private Integer status;
    private Integer sortId;
}

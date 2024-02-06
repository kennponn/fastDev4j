package com.fastDev4j.core.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Result {

    private int code;
    private String msg;
    private Object data;

    public static Result success() {
        return new Result(200,"操作成功",null);
    }
    public static Result success(Object data) {
        return new Result(200,"操作成功",data);
    }
    public static Result success(String msg,Object data) {
        return new Result(200,msg,data);
    }
    public static Result error() {
        return new Result(500,"操作失败",null);
    }
    public static Result error(String msg) {
        return new Result(500,msg,null);
    }
}


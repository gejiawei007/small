package com.small.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable{

    private static final long serialVersionUID = 1L;

    // 200成功
    @ApiModelProperty(value = "错误码", name = "错误码")
    private int code;

    // 返回消息，成功为“success”，失败为具体失败信息
    @ApiModelProperty(value = "错误码描述", name = "错误码描述")
    private String msg;

    // 返回数据
    @ApiModelProperty(value = "数据对象", name = "数据对象")
    private T data;

    public Result() {
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getmsg() {
        return msg;
    }

    public void setmsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

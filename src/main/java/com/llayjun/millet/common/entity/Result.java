package com.llayjun.millet.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 接口统一返回的json数据
 *
 * @author zhangyinlei
 * @since 2019/12/14
 */
@ApiModel(value = "通用接口返回对象")
@Data
public class Result<T> {

    @ApiModelProperty(required = true, notes = "实际传输的数据")
    private T data;
    @ApiModelProperty(required = true,notes = "返回结果判断", example = "true")
    private boolean success = true;
    @ApiModelProperty(required = true,notes = "消息", example = "消息")
    private String msg = "操作完成";

    public Result() {
    }

    public Result<T> genSuccess(String msg) {
        return (new Result<T>()).setSuccess(true).setMsg(msg);
    }

    public Result<T> genSuccessData(T data) {
        return (new Result<T>()).setSuccess(true).setData(data);
    }

    public Result<T> genFail(String msg) {
        return (new Result<T>()).setSuccess(false).setMsg(msg);
    }

    private Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    private Result<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    private Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

}

package com.llayjun.millet.common.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Collection;

/**
 * 接口统一返回的json数据
 *
 * @author zhangyinlei
 * @since 2019/12/14
 */
@Api
@Data
public class Result {

    @ApiModelProperty("实际传输的数据")
    private Object data;
    @ApiModelProperty
    private Integer total = 1;
    @ApiModelProperty
    private boolean success = true;
    @ApiModelProperty
    private String msg = "操作完成";

    public Result() {
    }

    public static Result genSuccess(String msg) {
        return (new Result()).setSuccess(true).setMsg(msg);
    }

    public static Result genSuccess(Collection<?> data) {
        return genSuccess(data, data.size());
    }

    public static Result genSuccessSingle(Object data) {
        return genSuccess(data, 1);
    }

    public static Result genSuccess(Object data, Long total) {
        return genSuccess(data, total.intValue());
    }

    public static Result genSuccess(Object data, Integer total) {
        return (new Result()).setSuccess(true).setData(data).setTotal(total);
    }

    public static Result genFail(String msg) {
        return (new Result()).setSuccess(false).setMsg(msg).setTotal(0);
    }

    public boolean isSuccess() {
        return this.success;
    }

    public Result setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public Object getData() {
        return this.data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Integer getTotal() {
        return this.total;
    }

    public Result setTotal(Integer total) {
        this.total = total;
        return this;
    }
}

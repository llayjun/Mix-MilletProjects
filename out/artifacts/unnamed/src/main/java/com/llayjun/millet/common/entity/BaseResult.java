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
public class BaseResult<T> {

    // 成功
    public static final Integer SUCCESS_CODE = 0;

    // 失败
    public static final Integer FAIL_CODE = -1;

    @ApiModelProperty(required = true, notes = "结果码", example = "0")
    private int code;
    @ApiModelProperty(required = true, notes = "消息", example = "消息")
    private String msg;
    @ApiModelProperty(required = true, notes = "数据对象")
    private T data;

    public BaseResult() {
    }

    public BaseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResult(int code, String msg, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static BaseResult success() {
        return BaseResult.success("操作成功");
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static BaseResult success(String msg) {
        return BaseResult.success(msg, null);
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static BaseResult success(Object object) {
        return BaseResult.success("操作成功", object);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @param object 数据对象
     * @return 成功消息
     */
    public static BaseResult success(String msg, Object object) {
        return new BaseResult(SUCCESS_CODE, msg, object);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static BaseResult error() {
        return BaseResult.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static BaseResult error(String msg) {
        return BaseResult.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static BaseResult error(String msg, Object data) {
        return new BaseResult(FAIL_CODE, msg, data);
    }

}

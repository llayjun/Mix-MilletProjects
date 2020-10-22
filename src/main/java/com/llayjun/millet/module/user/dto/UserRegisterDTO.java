package com.llayjun.millet.module.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zyl
 * @description 用户注册
 * @date 2020/7/6 9:08 上午
 */
@Data
public class UserRegisterDTO {

    @ApiModelProperty(value = "用户名字", required = true)
    @NotBlank(message = "用户名字不能为空")
    private String name;

    @ApiModelProperty(value = "用户性别", required = true)
    private int sex;

    @ApiModelProperty(value = "用户手机号", required = true)
    @NotBlank(message = "用户手机号不能为空")
    private String mobile;

    @ApiModelProperty(value = "用户密码", required = true)
    @NotBlank(message = "用户密码不能为空")
    private String passWord;

}


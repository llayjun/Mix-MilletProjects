package com.llayjun.millet.module.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zyl
 * @description 用户登录
 * @date 2020/7/6 9:08 上午
 */
@Data
public class UserLoginDTO {

    @ApiModelProperty(value = "手机号", required = true)
    @NotBlank(message = "手机号不能为空")
    private String mobile;

    @ApiModelProperty(value = "密码", required = true)
    @NotBlank(message = "密码不能为空")
    private String passWord;
}

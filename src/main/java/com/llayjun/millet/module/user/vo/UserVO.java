package com.llayjun.millet.module.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserVO{

    @ApiModelProperty(value = "用户id", example = "1")
    private String id;

    @ApiModelProperty(value = "用户名字", example = "name")
    private String name;

    @ApiModelProperty(value = "用户性别", example = "1")
    private Integer sex;

    @ApiModelProperty(value = "用户手机号", example = "13142667578")
    private String mobile;

    @ApiModelProperty(value = "用户密码", example = "12345678")
    private String passWord;

    @ApiModelProperty(value = "Authorization", example = "token")
    private String Authorization;

}


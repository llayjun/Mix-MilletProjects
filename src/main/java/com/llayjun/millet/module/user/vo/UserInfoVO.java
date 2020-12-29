package com.llayjun.millet.module.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 作为token获取后返回的用户信息
 */
@Data
public class UserInfoVO {

    @ApiModelProperty(value = "用户id", example = "1", hidden = true)
    private String id;

    @ApiModelProperty(value = "用户名字", example = "name", hidden = true)
    private String name;

    @ApiModelProperty(value = "用户性别", example = "1", hidden = true)
    private Integer sex;

    @ApiModelProperty(value = "用户手机号", example = "13142667578", hidden = true)
    private String mobile;

    @ApiModelProperty(value = "用户密码", example = "12345678", hidden = true)
    private String passWord;

    @Override
    public String toString() {
        return "UserInfoVO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}


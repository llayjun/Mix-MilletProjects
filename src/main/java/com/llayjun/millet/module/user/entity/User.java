package com.llayjun.millet.module.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.llayjun.millet.common.entity.UUIDBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@TableName("user")
@ApiModel(value="User对象")
public class User extends UUIDBaseEntity{

    @ApiModelProperty(value = "用户名字", example = "name")
    private String name;

    @ApiModelProperty(value = "用户性别", example = "1")
    private Integer sex;

    @ApiModelProperty(value = "用户手机号", example = "13142667578")
    private String mobile;

    @ApiModelProperty(value = "用户密码", example = "12345678")
    private String passWord;

}


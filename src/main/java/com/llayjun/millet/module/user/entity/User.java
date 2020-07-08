package com.llayjun.millet.module.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.llayjun.millet.common.entity.UUIDBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("user")
@ApiModel(value="User对象", description="用户信息")
public class User extends UUIDBaseEntity{

    @ApiModelProperty(value = "用户名字")
    private String name;

    @ApiModelProperty(value = "用户性别")
    private int sex;

    @ApiModelProperty(value = "用户手机号")
    private String mobile;

    @ApiModelProperty(value = "用户密码")
    private String passWord;

}


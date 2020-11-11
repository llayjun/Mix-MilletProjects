package com.llayjun.millet.module.merchant.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.llayjun.millet.common.entity.UUIDBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author zyl
 * @since 2020-10-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Merchant对象")
@TableName("merchant")
public class Merchant extends UUIDBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商户名称")
    private String merchantName;

    @ApiModelProperty(value = "商户头像")
    private String merchantLogo;

    @ApiModelProperty(value = "商户城市")
    private String city;

    @ApiModelProperty(value = "商户地址详情")
    private String location;

    @ApiModelProperty(value = "商户规模")
    private String scale;

    @ApiModelProperty(value = "商户成立时间")
    private LocalDateTime establishTime;

    @ApiModelProperty(value = "商户性质")
    private String nature;

    @ApiModelProperty(value = "商户注册资金")
    private String funds;

    @ApiModelProperty(value = "商户规模")
    private String merchantRange;

}

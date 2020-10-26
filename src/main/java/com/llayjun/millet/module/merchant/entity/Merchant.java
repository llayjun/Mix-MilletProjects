package com.llayjun.millet.module.merchant.entity;

import com.llayjun.millet.common.entity.UUIDBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class Merchant extends UUIDBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商户名称")
    private String merchantName;

    @ApiModelProperty(value = "商户头像")
    private String merchantLogo;


}

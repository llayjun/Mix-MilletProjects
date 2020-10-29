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
@ApiModel(value="MerchantPicture对象")
public class MerchantPicture extends UUIDBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商户Id")
    private String merchantId;

    @ApiModelProperty(value = "商户图片")
    private String picture;

}

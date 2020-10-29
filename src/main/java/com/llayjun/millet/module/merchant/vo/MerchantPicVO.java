package com.llayjun.millet.module.merchant.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MerchantPicVO {

    @ApiModelProperty(value = "商户图片id", example = "1")
    private String id;

    @ApiModelProperty(value = "商户图片url", example = "xxx")
    private String picture;
}

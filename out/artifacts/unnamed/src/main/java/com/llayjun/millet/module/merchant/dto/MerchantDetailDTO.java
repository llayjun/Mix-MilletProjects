package com.llayjun.millet.module.merchant.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MerchantDetailDTO {

    @ApiModelProperty(value = "商户id", example = "1")
    @NotNull(message = "商户id不能为空")
    private String merchantId;

}

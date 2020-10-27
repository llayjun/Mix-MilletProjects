package com.llayjun.millet.module.merchant.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MerchantVO {

    @ApiModelProperty(value = "id", example = "111")
    private String id;

    @ApiModelProperty(value = "商户名称", example = "肯德基")
    private String merchantName;

    @ApiModelProperty(value = "商户logo", example = "http://xxx")
    private String merchantLogo;

    @ApiModelProperty(value = "商户任务个数", example = "1")
    private Integer merchantTaskNum;

}

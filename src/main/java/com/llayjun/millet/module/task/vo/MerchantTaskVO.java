package com.llayjun.millet.module.task.vo;

import io.swagger.annotations.ApiModelProperty;
import javafx.scene.input.DataFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MerchantTaskVO {

    @ApiModelProperty(value = "任务id", example = "111")
    private String id;

    @ApiModelProperty(value = "商户id", example = "111")
    private String merchantId;

    @ApiModelProperty(value = "商户名称", example = "肯德基")
    private String merchantName;

    @ApiModelProperty(value = "商户logo", example = "xxx")
    private String merchantLogo;

    @ApiModelProperty(value = "任务名称", example = "xxx")
    private String merchantTaskName;

    @ApiModelProperty(value = "任务描述", example = "xxx")
    private String merchantTaskDesc;

    @ApiModelProperty(value = "单价", example = "1.2")
    private Float merchantTaskUnitPrice;

    @ApiModelProperty(value = "任务地址", example = "苏州")
    private String taskLocation;

    @ApiModelProperty(value = "任务创建时间", example = "2020")
    private LocalDateTime createdTime;

}

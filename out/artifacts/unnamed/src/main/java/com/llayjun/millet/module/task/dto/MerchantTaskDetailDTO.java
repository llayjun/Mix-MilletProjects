package com.llayjun.millet.module.task.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 商户任务详情
 */
@Data
public class MerchantTaskDetailDTO {

    @ApiModelProperty(value = "任务id", example = "1")
    @NotNull(message = "任务id不能为空")
    private String merchantTaskId;

}

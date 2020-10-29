package com.llayjun.millet.module.task.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MerchantTaskPictureVO {

    @ApiModelProperty(value = "任务图片id", example = "1")
    private String id;

    @ApiModelProperty(value = "任务图片url", example = "xxx")
    private String picture;
}

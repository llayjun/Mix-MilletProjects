package com.llayjun.millet.module.banner.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BannerVO {

    @ApiModelProperty(value = "id", example = "111")
    private String id;

    @ApiModelProperty(value = "图片地址", example = "http://xxx")
    private String imageUrl;

}

package com.llayjun.millet.module.articleType.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddArticleTypeDTO {

    @ApiModelProperty(value = "文章类型id", required = true)
    @NotBlank(message = "文章类型id不能为空")
    private Integer articleType;

    @ApiModelProperty(value = "文章类型名称", required = true)
    @NotBlank(message = "文章类型名称不能为空")
    private String articleTypeName;

}

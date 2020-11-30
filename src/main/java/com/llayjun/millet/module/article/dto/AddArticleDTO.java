package com.llayjun.millet.module.article.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddArticleDTO {

    @ApiModelProperty(value = "文章类型id", required = true)
    @NotNull(message = "文章类型id不能为空")
    private Integer articleType;

    @ApiModelProperty(value = "文章标题", required = true)
    @NotBlank(message = "文章标题不能为空")
    private String articleTitle;

    @ApiModelProperty(value = "文章链接", required = true)
    @NotBlank(message = "文章链接不能为空")
    private String articleUrl;

}

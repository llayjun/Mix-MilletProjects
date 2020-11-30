package com.llayjun.millet.module.article.dto;

import com.llayjun.millet.common.dto.BaseListDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ArticlePageDTO extends BaseListDTO {

    @ApiModelProperty(value = "文章类型id", required = false)
    private Integer articleType;

}

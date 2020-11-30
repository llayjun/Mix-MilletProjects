package com.llayjun.millet.module.article.entity;

import com.llayjun.millet.common.entity.UUIDBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zyl
 * @since 2020-11-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="Article对象", description="")
public class Article extends UUIDBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文章类型")
    private Integer articleType;

    @ApiModelProperty(value = "文章标题")
    private String articleTitle;

    @ApiModelProperty(value = "文章链接")
    private String articleUrl;

    @ApiModelProperty(value = "文章状态0：未读，1：已读")
    private Integer readState;
}

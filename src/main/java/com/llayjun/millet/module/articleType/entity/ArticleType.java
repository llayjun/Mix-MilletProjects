package com.llayjun.millet.module.articleType.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.llayjun.millet.common.entity.UUIDBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@Accessors(chain = true)
@ApiModel(value="Article对象", description="")
@TableName("article_type")
public class ArticleType extends UUIDBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文章分类类型")
    private Integer articleType;

    @ApiModelProperty(value = "文章分类名称")
    private String articleTypeName;


}

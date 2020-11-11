package com.llayjun.millet.module.banner.entity;

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
 * @since 2020-07-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "Banner对象")
public class Banner extends UUIDBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(required = true, value = "图片地址")
    private String imageUrl;

}

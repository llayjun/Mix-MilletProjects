package com.llayjun.millet.module.task.entity;

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
 * @since 2020-10-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="MerchantTaskPicture对象")
public class MerchantTaskPicture extends UUIDBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "任务Id")
    private String taskId;

    @ApiModelProperty(value = "商户图片")
    private String picture;

}

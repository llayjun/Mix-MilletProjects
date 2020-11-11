package com.llayjun.millet.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 分页DTO
 *
 * @author jingchen
 * @since 2019/12/27
 */
@Data
public class BaseListDTO {

    @ApiModelProperty(value = "页数", example = "1")
    @NotNull(message = "页数不能为空")
    private Integer pageNum = 1;

    @ApiModelProperty(value = "每页条数", example = "10")
    @NotNull(message = "每页条数不能为空")
    private Integer pageSize = 10;

    @ApiModelProperty(value = "搜索内容", required = false)
    private String content;

}

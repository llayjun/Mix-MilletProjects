package com.llayjun.millet.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 实体类公共字段
 *
 * @author jiayu
 * @since 2019/9/29
 */
@Data
public class UUIDBaseEntity {

    @TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty("id")
    protected String id;

    @ApiModelProperty(hidden = true)
    @TableField(fill = FieldFill.INSERT)
    protected LocalDateTime createdTime;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @TableField(fill = FieldFill.INSERT)
    protected Long createdId;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @TableField(fill = FieldFill.INSERT)
    protected String createdName;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updatedTime;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected Long updatedId;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected String updatedName;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @TableLogic
    protected Integer logicDelete = 0;

}

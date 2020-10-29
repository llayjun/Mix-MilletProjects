package com.llayjun.millet.module.merchant.vo;

import com.llayjun.millet.module.task.vo.MerchantTaskVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MerchantDetailVO {

    @ApiModelProperty(value = "id", example = "111")
    private String id;

    @ApiModelProperty(value = "商户名称", example = "肯德基")
    private String merchantName;

    @ApiModelProperty(value = "商户logo", example = "http://xxx")
    private String merchantLogo;

    @ApiModelProperty(value = "商户所在城市", example = "苏州")
    private String city;

    @ApiModelProperty(value = "商户所在地址", example = "天灵路11号")
    private String location;

    @ApiModelProperty(value = "商户规模", example = "200人")
    private String scale;

    @ApiModelProperty(value = "商户成立时间", example = "2020-11-11")
    private LocalDateTime establishTime;

    @ApiModelProperty(value = "商户性质", example = "私企")
    private String nature;

    @ApiModelProperty(value = "商户注册资金", example = "200w")
    private String funds;

    @ApiModelProperty(value = "商户经营范围", example = "xxx")
    private String range;

    @ApiModelProperty(value = "商户任务个数", example = "1")
    private Integer merchantTaskNum;

    @ApiModelProperty(value = "商户图片", example = "[]")
    private List<MerchantPicVO> merchantPicList;

    @ApiModelProperty(value = "商户任务", example = "[]")
    private List<MerchantTaskVO> merchantTaskList;

}

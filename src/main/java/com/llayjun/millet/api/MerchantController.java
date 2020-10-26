package com.llayjun.millet.api;


import com.llayjun.millet.common.entity.BaseResult;
import com.llayjun.millet.module.merchant.service.IMerchantService;
import com.llayjun.millet.module.merchant.vo.MerchantVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.llayjun.millet.common.constant.Constants.APP_URI_V1;

/**
 * <p>
 *  商户信息
 * </p>
 *
 * @author zyl
 * @since 2020-10-26
 */
@RestController
@Api(tags = "商户接口")
@RequestMapping(APP_URI_V1 + "/merchant")
public class MerchantController {

    @Autowired
    private IMerchantService iMerchantService;

    @ApiOperation(value = "获取推荐商户列表", notes = "获取推荐商户列表")
    @GetMapping("/getMerchantList")
    public BaseResult<List<MerchantVO>> getMerchantList() {
        return BaseResult.success(iMerchantService.getMerchantList());
    }
}

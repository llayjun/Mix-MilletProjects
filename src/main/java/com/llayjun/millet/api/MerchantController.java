package com.llayjun.millet.api;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llayjun.millet.common.annotation.UserToken;
import com.llayjun.millet.common.entity.BaseResult;
import com.llayjun.millet.module.merchant.dto.MerchantDetailDTO;
import com.llayjun.millet.module.merchant.dto.MerchantPageDTO;
import com.llayjun.millet.module.merchant.entity.Merchant;
import com.llayjun.millet.module.merchant.service.IMerchantService;
import com.llayjun.millet.module.merchant.vo.MerchantDetailVO;
import com.llayjun.millet.module.merchant.vo.MerchantVO;
import com.llayjun.millet.module.user.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 获取推荐商户列表
     * @return
     */
    @ApiOperation(value = "获取推荐商户列表", notes = "获取推荐商户列表")
    @GetMapping("/getMerchantList")
    @UserToken
    public BaseResult<List<MerchantVO>> getMerchantList() {
        return BaseResult.success(iMerchantService.getMerchantList());
    }

    /**
     * 获取商户列表分页
     * @return
     */
    @ApiOperation(value = "获取商户分页列表", notes = "获取商户分页列表")
    @PostMapping("/getMerchantListPage")
    @UserToken
    public BaseResult<IPage<MerchantVO>> getMerchantListPage(@RequestBody @Validated MerchantPageDTO merchantPageDTO) {
        IPage<MerchantVO> page = new Page<>(merchantPageDTO.getPageNum(), merchantPageDTO.getPageSize());
        return BaseResult.success(iMerchantService.getMerchantListPage(page, merchantPageDTO));
    }

    /**
     * 获取商户详情
     */
    @ApiOperation(value = "获取商户详情信息", notes = "获取商户详情信息")
    @PostMapping("/getMerchantDetail")
    @UserToken
    public BaseResult<MerchantDetailVO> getMerchantDetail(@RequestBody @Validated MerchantDetailDTO merchantDetailDTO) {
        Merchant merchant = iMerchantService.getById(merchantDetailDTO.getMerchantId());
        if (merchant == null) {
            return BaseResult.error("该商户不存在");
        }
        return BaseResult.success(iMerchantService.getMerchantDetail(merchantDetailDTO));
    }

}

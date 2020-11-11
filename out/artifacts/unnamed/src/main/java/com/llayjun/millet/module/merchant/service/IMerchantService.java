package com.llayjun.millet.module.merchant.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.llayjun.millet.module.merchant.dto.MerchantDetailDTO;
import com.llayjun.millet.module.merchant.dto.MerchantPageDTO;
import com.llayjun.millet.module.merchant.entity.Merchant;
import com.baomidou.mybatisplus.extension.service.IService;
import com.llayjun.millet.module.merchant.vo.MerchantDetailVO;
import com.llayjun.millet.module.merchant.vo.MerchantVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zyl
 * @since 2020-10-26
 */
public interface IMerchantService extends IService<Merchant> {

    /**
     * 获取商户列表
     * @return
     */
    List<MerchantVO> getMerchantList();

    /**
     * 获取商户列表分页
     */
    IPage<MerchantVO> getMerchantListPage(IPage<MerchantVO> page, MerchantPageDTO merchantPageDTO);

    /**
     * 获取商户详情信息
     */
    MerchantDetailVO getMerchantDetail(MerchantDetailDTO merchantDetailDTO);
}

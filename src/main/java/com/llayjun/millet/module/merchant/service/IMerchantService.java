package com.llayjun.millet.module.merchant.service;

import com.llayjun.millet.module.merchant.entity.Merchant;
import com.baomidou.mybatisplus.extension.service.IService;
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

}

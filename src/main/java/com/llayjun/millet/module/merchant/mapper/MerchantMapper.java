package com.llayjun.millet.module.merchant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llayjun.millet.module.merchant.entity.Merchant;
import com.llayjun.millet.module.merchant.vo.MerchantVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zyl
 * @since 2020-10-26
 */
public interface MerchantMapper extends BaseMapper<Merchant> {

    List<MerchantVO> getMerchantList();

}

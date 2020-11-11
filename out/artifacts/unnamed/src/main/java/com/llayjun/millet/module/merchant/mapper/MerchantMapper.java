package com.llayjun.millet.module.merchant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.llayjun.millet.module.merchant.dto.MerchantDetailDTO;
import com.llayjun.millet.module.merchant.dto.MerchantPageDTO;
import com.llayjun.millet.module.merchant.entity.Merchant;
import com.llayjun.millet.module.merchant.vo.MerchantDetailVO;
import com.llayjun.millet.module.merchant.vo.MerchantVO;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 获取商户列表
     * @return
     */
    List<MerchantVO> getMerchantList();

    /**
     * 获取商户列表分页
     */
    IPage<MerchantVO> getMerchantListPage(IPage<MerchantVO> page, @Param("dto") MerchantPageDTO merchantPageDTO);

    /**
     * 获取商户详情信息
     */
    MerchantDetailVO getMerchantDetailInfo(@Param("dto") MerchantDetailDTO merchantDetailDTO);

}

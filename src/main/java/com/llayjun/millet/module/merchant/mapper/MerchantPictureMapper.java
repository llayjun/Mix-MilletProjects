package com.llayjun.millet.module.merchant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.llayjun.millet.module.merchant.dto.MerchantDetailDTO;
import com.llayjun.millet.module.merchant.dto.MerchantPageDTO;
import com.llayjun.millet.module.merchant.entity.Merchant;
import com.llayjun.millet.module.merchant.entity.MerchantPicture;
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
public interface MerchantPictureMapper extends BaseMapper<MerchantPicture> {

}

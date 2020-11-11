package com.llayjun.millet.module.banner.mapper;

import com.llayjun.millet.module.banner.entity.Banner;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llayjun.millet.module.banner.vo.BannerVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zyl
 * @since 2020-07-07
 */
public interface BannerMapper extends BaseMapper<Banner> {

    /**
     * 获取轮播图列表
     * @return
     */
    List<BannerVO> getBannerList();

}

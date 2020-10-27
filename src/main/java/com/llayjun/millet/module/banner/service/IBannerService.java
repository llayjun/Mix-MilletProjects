package com.llayjun.millet.module.banner.service;

import com.llayjun.millet.module.banner.entity.Banner;
import com.baomidou.mybatisplus.extension.service.IService;
import com.llayjun.millet.module.banner.vo.BannerVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zyl
 * @since 2020-07-07
 */
public interface IBannerService extends IService<Banner> {

    /**
     * 获取轮播图列表
     * @return
     */
    List<BannerVO> getBannerList();
}

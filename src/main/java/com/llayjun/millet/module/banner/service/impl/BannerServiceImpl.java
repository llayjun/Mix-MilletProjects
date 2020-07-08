package com.llayjun.millet.module.banner.service.impl;

import com.llayjun.millet.module.banner.entity.Banner;
import com.llayjun.millet.module.banner.mapper.BannerMapper;
import com.llayjun.millet.module.banner.service.IBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zyl
 * @since 2020-07-07
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements IBannerService {

    @Autowired
    BannerMapper bannerMapper;

    @Override
    public List<Banner> getBannerList() {
        return bannerMapper.getBannerList();
    }
}

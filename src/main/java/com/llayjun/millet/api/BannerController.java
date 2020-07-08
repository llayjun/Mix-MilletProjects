package com.llayjun.millet.api;


import com.llayjun.millet.common.entity.Result;
import com.llayjun.millet.module.banner.entity.Banner;
import com.llayjun.millet.module.banner.service.IBannerService;
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
 *  前端控制器
 * </p>
 *
 * @author zyl
 * @since 2020-07-07
 */
@RestController
@Api(tags = "轮播图接口")
@RequestMapping(APP_URI_V1 + "/banner")
public class BannerController {

    @Autowired
    private IBannerService iBannerService;

    @ApiOperation(value = "获取轮播图列表", notes = "获取轮播图列表接口")
    @GetMapping("/getBannerList")
    public Result<List<Banner>> getBannerList() {
        return new Result<List<Banner>>().genSuccessData(iBannerService.getBannerList());
    }

}

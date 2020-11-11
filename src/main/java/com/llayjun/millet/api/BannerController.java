package com.llayjun.millet.api;


import com.llayjun.millet.common.annotation.CurrentUser;
import com.llayjun.millet.common.annotation.UserToken;
import com.llayjun.millet.common.entity.BaseResult;
import com.llayjun.millet.module.banner.service.IBannerService;
import com.llayjun.millet.module.banner.vo.BannerVO;
import com.llayjun.millet.module.user.entity.User;
import com.llayjun.millet.module.user.vo.UserInfoVO;
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
 *
 */
@RestController
@Api(tags = "轮播图接口")
@RequestMapping(APP_URI_V1 + "/banner")
public class BannerController {

    @Autowired
    private IBannerService iBannerService;

    /**
     * 轮播图列表
     * @return
     */
    @ApiOperation(value = "获取轮播图列表", notes = "获取轮播图列表接口")
    @GetMapping("/getBannerList")
    @UserToken
    public BaseResult<List<BannerVO>> getBannerList() {
        return BaseResult.success(iBannerService.getBannerList());
    }

}

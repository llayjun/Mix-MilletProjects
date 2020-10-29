package com.llayjun.millet.api;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llayjun.millet.common.entity.BaseResult;
import com.llayjun.millet.module.merchant.vo.MerchantVO;
import com.llayjun.millet.module.task.dto.MerchantTaskPageDTO;
import com.llayjun.millet.module.task.service.IMerchantTaskService;
import com.llayjun.millet.module.task.vo.MerchantTaskVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.llayjun.millet.common.constant.Constants.APP_URI_V1;

/**
 * <p>
 *  商户任务接口
 * </p>
 *
 * @author zyl
 * @since 2020-10-27
 */
@RestController
@Api(tags = "任务接口")
@RequestMapping(APP_URI_V1 + "/task")
public class MerchantTaskController {

    @Autowired
    IMerchantTaskService iMerchantTaskService;

    /**
     * 获取商户任务列表
     * @return
     */
    @ApiOperation(value = "获取商户任务列表", notes = "获取商户任务列表")
    @GetMapping("/getMerchantTaskList")
    public BaseResult<List<MerchantTaskVO>> getMerchantTaskList(String merchantId) {
        return BaseResult.success(iMerchantTaskService.getMerchantTaskList(merchantId));
    }

    /**
     * 获取商户任务列表分页
     */
    @ApiOperation(value = "获取商户任务列表分页", notes = "获取商户任务列表分页")
    @PostMapping("/getMerchantTaskListPage")
    public BaseResult<IPage<MerchantTaskVO>> getMerchantTaskListPage(@RequestBody @Validated MerchantTaskPageDTO merchantTaskPageDTO) {
        IPage<MerchantTaskVO> page = new Page<>(merchantTaskPageDTO.getPageNum(), merchantTaskPageDTO.getPageSize());
        return BaseResult.success(iMerchantTaskService.getMerchantTaskListPage(page, merchantTaskPageDTO));
    }
}

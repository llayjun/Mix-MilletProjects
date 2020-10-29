package com.llayjun.millet.module.task.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.llayjun.millet.module.task.dto.MerchantTaskPageDTO;
import com.llayjun.millet.module.task.entity.MerchantTask;
import com.baomidou.mybatisplus.extension.service.IService;
import com.llayjun.millet.module.task.vo.MerchantTaskVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zyl
 * @since 2020-10-27
 */
public interface IMerchantTaskService extends IService<MerchantTask> {
    /**
     * 通过商户id统计任务数量
     *
     * @param merchantId
     * @return
     */
    Integer getMerchantTaskCount(String merchantId);

    /**
     * 获取商户任务列表
     * @return
     */
    List<MerchantTaskVO> getMerchantTaskList(String merchantId);

    /**
     * 获取商户任务列表分页
     */
    IPage<MerchantTaskVO> getMerchantTaskListPage(IPage<MerchantTaskVO> page, MerchantTaskPageDTO merchantTaskPageDTO);

}

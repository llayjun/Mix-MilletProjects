package com.llayjun.millet.module.task.service;

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

    List<MerchantTaskVO> getMerchantTaskList();

}

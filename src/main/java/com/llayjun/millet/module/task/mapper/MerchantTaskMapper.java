package com.llayjun.millet.module.task.mapper;

import com.llayjun.millet.module.task.entity.MerchantTask;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llayjun.millet.module.task.vo.MerchantTaskVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zyl
 * @since 2020-10-27
 */
public interface MerchantTaskMapper extends BaseMapper<MerchantTask> {
    List<MerchantTaskVO> getMerchantTaskList();
}

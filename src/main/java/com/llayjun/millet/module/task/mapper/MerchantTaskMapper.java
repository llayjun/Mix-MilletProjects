package com.llayjun.millet.module.task.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.llayjun.millet.module.merchant.dto.MerchantPageDTO;
import com.llayjun.millet.module.merchant.vo.MerchantVO;
import com.llayjun.millet.module.task.dto.MerchantTaskDetailDTO;
import com.llayjun.millet.module.task.dto.MerchantTaskPageDTO;
import com.llayjun.millet.module.task.entity.MerchantTask;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llayjun.millet.module.task.vo.MerchantTaskDetailVO;
import com.llayjun.millet.module.task.vo.MerchantTaskVO;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 获取商户任务列表
     * @return
     */
    List<MerchantTaskVO> getMerchantTaskList(String merchantId);

    /**
     * 通过商户id统计商户发布的任务
     * @param merchantId
     * @return
     */
    Integer getMerchantTaskCount(String merchantId);

    /**
     * 获取商户任务列表分页
     */
    IPage<MerchantTaskVO> getMerchantTaskListPage(IPage<MerchantTaskVO> page, @Param("dto") MerchantTaskPageDTO merchantTaskPageDTO);

    /**
     * 获取商户任务详情
     */
    MerchantTaskDetailVO getMerchantTaskDetail(@Param("dto")MerchantTaskDetailDTO merchantTaskDetailDTO);
}

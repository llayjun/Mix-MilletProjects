package com.llayjun.millet.module.task.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.llayjun.millet.common.utils.BeanUtil;
import com.llayjun.millet.module.task.dto.MerchantTaskDetailDTO;
import com.llayjun.millet.module.task.dto.MerchantTaskPageDTO;
import com.llayjun.millet.module.task.entity.MerchantTask;
import com.llayjun.millet.module.task.entity.MerchantTaskPicture;
import com.llayjun.millet.module.task.mapper.MerchantTaskMapper;
import com.llayjun.millet.module.task.service.IMerchantTaskPictureService;
import com.llayjun.millet.module.task.service.IMerchantTaskService;
import com.llayjun.millet.module.task.vo.MerchantTaskDetailVO;
import com.llayjun.millet.module.task.vo.MerchantTaskPictureVO;
import com.llayjun.millet.module.task.vo.MerchantTaskVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zyl
 * @since 2020-10-27
 */
@Service
public class MerchantTaskServiceImpl extends ServiceImpl<MerchantTaskMapper, MerchantTask> implements IMerchantTaskService {

    @Autowired
    MerchantTaskMapper merchantTaskMapper;

    @Autowired
    IMerchantTaskPictureService iMerchantTaskPictureService;

    @Override
    public Integer getMerchantTaskCount(String merchantId) {
        return merchantTaskMapper.getMerchantTaskCount(merchantId);
    }

    @Override
    public List<MerchantTaskVO> getMerchantTaskList(String merchantId) {
        return merchantTaskMapper.getMerchantTaskList(merchantId);
    }

    @Override
    public IPage<MerchantTaskVO> getMerchantTaskListPage(IPage<MerchantTaskVO> page, MerchantTaskPageDTO merchantTaskPageDTO) {
        return merchantTaskMapper.getMerchantTaskListPage(page, merchantTaskPageDTO);
    }

    @Override
    public MerchantTaskDetailVO getMerchantTaskDetail(MerchantTaskDetailDTO merchantTaskDetailDTO) {
        MerchantTaskDetailVO merchantTaskDetailVO = merchantTaskMapper.getMerchantTaskDetail(merchantTaskDetailDTO);
        // 任务图片
        LambdaQueryWrapper<MerchantTaskPicture> wrapperPic = Wrappers.lambdaQuery();
        wrapperPic.eq(MerchantTaskPicture::getTaskId, merchantTaskDetailDTO.getMerchantTaskId());
        List<MerchantTaskPicture> pictureList = iMerchantTaskPictureService.list(wrapperPic);
        List<MerchantTaskPictureVO> picVOList = BeanUtil.copyList(pictureList, MerchantTaskPictureVO.class);
        merchantTaskDetailVO.setTaskPictureList(picVOList);
        return merchantTaskDetailVO;
    }

}

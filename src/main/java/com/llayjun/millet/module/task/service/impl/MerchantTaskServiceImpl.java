package com.llayjun.millet.module.task.service.impl;

import com.llayjun.millet.module.task.entity.MerchantTask;
import com.llayjun.millet.module.task.mapper.MerchantTaskMapper;
import com.llayjun.millet.module.task.service.IMerchantTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

    @Override
    public Integer getMerchantTaskCount(String merchantId) {
        return merchantTaskMapper.getMerchantTaskCount(merchantId);
    }

    @Override
    public List<MerchantTaskVO> getMerchantTaskList() {
        return merchantTaskMapper.getMerchantTaskList();
    }
}

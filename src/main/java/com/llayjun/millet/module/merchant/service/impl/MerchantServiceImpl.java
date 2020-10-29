package com.llayjun.millet.module.merchant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.llayjun.millet.module.merchant.dto.MerchantDetailDTO;
import com.llayjun.millet.module.merchant.dto.MerchantPageDTO;
import com.llayjun.millet.module.merchant.entity.Merchant;
import com.llayjun.millet.module.merchant.entity.MerchantPicture;
import com.llayjun.millet.module.merchant.mapper.MerchantMapper;
import com.llayjun.millet.module.merchant.service.IMerchantPictureService;
import com.llayjun.millet.module.merchant.service.IMerchantService;
import com.llayjun.millet.module.merchant.vo.MerchantDetailVO;
import com.llayjun.millet.module.merchant.vo.MerchantPicVO;
import com.llayjun.millet.module.merchant.vo.MerchantVO;
import com.llayjun.millet.module.task.service.IMerchantTaskService;
import com.llayjun.millet.module.task.vo.MerchantTaskVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zyl
 * @since 2020-10-26
 */
@Service
public class MerchantServiceImpl extends ServiceImpl<MerchantMapper, Merchant> implements IMerchantService {

    @Autowired
    MerchantMapper merchantMapper;

    @Autowired
    IMerchantTaskService iMerchantTaskService;

    @Autowired
    IMerchantPictureService iMerchantPictureService;

    @Override
    public List<MerchantVO> getMerchantList() {
        List<MerchantVO> merchantVOList = merchantMapper.getMerchantList();
        // 商户累计数量
        for (MerchantVO merchantVO: merchantVOList) {
            Integer num = iMerchantTaskService.getMerchantTaskCount(merchantVO.getId());
            merchantVO.setMerchantTaskNum(num);
        }
        return merchantVOList;
    }

    @Override
    public IPage<MerchantVO> getMerchantListPage(IPage<MerchantVO> page, MerchantPageDTO merchantPageDTO) {
        IPage<MerchantVO> merchantVOList = merchantMapper.getMerchantListPage(page, merchantPageDTO);
        // 商户累计数量
        for (MerchantVO merchantVO: merchantVOList.getRecords()) {
            Integer num = iMerchantTaskService.getMerchantTaskCount(merchantVO.getId());
            merchantVO.setMerchantTaskNum(num);
        }
        return merchantVOList;
    }

    @Override
    public MerchantDetailVO getMerchantDetail(MerchantDetailDTO merchantDetailDTO) {
        MerchantDetailVO merchantDetailVO = merchantMapper.getMerchantDetailInfo(merchantDetailDTO);
        // 商户累计数量
        Integer num = iMerchantTaskService.getMerchantTaskCount(merchantDetailDTO.getMerchantId());
        merchantDetailVO.setMerchantTaskNum(num);
        // 商户任务
        List<MerchantTaskVO> merchantTaskVOList = iMerchantTaskService.getMerchantTaskList(merchantDetailDTO.getMerchantId());
        merchantDetailVO.setMerchantTaskList(merchantTaskVOList);
        // 商户图片
        LambdaQueryWrapper<MerchantPicture> wrapperPic = Wrappers.lambdaQuery();
        wrapperPic.eq(MerchantPicture::getMerchantId, merchantDetailDTO.getMerchantId());
        List<MerchantPicture> pictureList = iMerchantPictureService.list(wrapperPic);
        List<MerchantPicVO> picVOList = new ArrayList<>();
        for (MerchantPicture merchantPicture : pictureList) {
            MerchantPicVO merchantPicVO = new MerchantPicVO();
            BeanUtils.copyProperties(merchantPicture, merchantPicVO);
            picVOList.add(merchantPicVO);
        }
        merchantDetailVO.setMerchantPicList(picVOList);
        return merchantDetailVO;
    }

}

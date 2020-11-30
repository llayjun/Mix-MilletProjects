package com.llayjun.millet.module.articleType.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.llayjun.millet.module.articleType.entity.ArticleType;
import com.llayjun.millet.module.articleType.mapper.ArticleTypeMapper;
import com.llayjun.millet.module.articleType.service.IArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zyl
 * @since 2020-11-27
 */
@Service
public class ArticleTypeServiceImpl extends ServiceImpl<ArticleTypeMapper, ArticleType> implements IArticleTypeService {

    @Autowired
    ArticleTypeMapper articleTypeMapper;

    @Override
    public List<ArticleType> getArticleTypeList() {
        return articleTypeMapper.getArticleTypeList();
    }

}

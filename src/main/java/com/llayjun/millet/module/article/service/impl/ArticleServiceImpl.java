package com.llayjun.millet.module.article.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.llayjun.millet.module.article.dto.ArticlePageDTO;
import com.llayjun.millet.module.article.entity.Article;
import com.llayjun.millet.module.article.mapper.ArticleMapper;
import com.llayjun.millet.module.article.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zyl
 * @since 2020-11-27
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public IPage<Article> getArticleList(IPage<Article> iPage, ArticlePageDTO articlePageDTO) {
        IPage<Article> articleIPage = articleMapper.getArticleList(iPage, articlePageDTO);
        return articleIPage;
    }
}

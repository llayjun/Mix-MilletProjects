package com.llayjun.millet.module.article.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.llayjun.millet.module.article.dto.ArticlePageDTO;
import com.llayjun.millet.module.article.entity.Article;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zyl
 * @since 2020-11-27
 */
public interface IArticleService extends IService<Article> {

    /**
     * 获取所有文章
     */
    IPage<Article> getArticleList(IPage<Article> iPage, ArticlePageDTO articlePageDTO);

}

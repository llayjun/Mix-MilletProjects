package com.llayjun.millet.module.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.llayjun.millet.module.article.dto.ArticlePageDTO;
import com.llayjun.millet.module.article.entity.Article;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zyl
 * @since 2020-11-27
 */
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 获取文章列表分页
     */
    IPage<Article> getArticleList(IPage<Article> page, @Param("dto") ArticlePageDTO articlePageDTO);

}

package com.llayjun.millet.module.articleType.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.llayjun.millet.module.articleType.entity.ArticleType;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zyl
 * @since 2020-11-27
 */
public interface IArticleTypeService extends IService<ArticleType> {

    /**
     * 获取文章全部分类
     * @return
     */
    List<ArticleType> getArticleTypeList();

}

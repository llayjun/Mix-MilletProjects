package com.llayjun.millet.module.articleType.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llayjun.millet.module.articleType.entity.ArticleType;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zyl
 * @since 2020-11-27
 */
public interface ArticleTypeMapper extends BaseMapper<ArticleType> {

    List<ArticleType> getArticleTypeList();

}

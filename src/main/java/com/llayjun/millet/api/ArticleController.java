package com.llayjun.millet.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llayjun.millet.common.annotation.UserToken;
import com.llayjun.millet.common.entity.BaseResult;
import com.llayjun.millet.module.article.dto.AddArticleDTO;
import com.llayjun.millet.module.article.dto.ArticlePageDTO;
import com.llayjun.millet.module.article.entity.Article;
import com.llayjun.millet.module.article.service.IArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.llayjun.millet.common.constant.Constants.APP_URI_V1;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zyl
 * @since 2020-11-27
 */
@RestController
@RequestMapping(APP_URI_V1 +"/article")
@Api(tags = "文章信息")
public class ArticleController {

    @Autowired
    IArticleService iArticleService;

    /**
     * 新增文章类型
     */
    @PostMapping("/addArticle")
    @ApiOperation(value = "新增文章")
    @UserToken
    public BaseResult addArticle(@Validated @RequestBody AddArticleDTO addArticleDTO) {
        if (addArticleDTO.getArticleType() == 0) {
            return BaseResult.error("不可使用0类型");
        }
        Article article = new Article();
        BeanUtils.copyProperties(addArticleDTO, article);
        boolean state = iArticleService.save(article);
        if (state) {
            return BaseResult.success("新增成功");
        } else {
            return BaseResult.error("新增失败");
        }
    }

    /**
     * 获取所有文章类型
     */
    @ApiOperation(value = "获取所有文章")
    @PostMapping("/getArticleList")
    @UserToken
    public BaseResult<List<Article>> getArticleList(@Validated @RequestBody ArticlePageDTO articlePageDTO) {
        IPage<Article> page = new Page<>(articlePageDTO.getPageNum(), articlePageDTO.getPageSize());
        return BaseResult.success(iArticleService.getArticleList(page, articlePageDTO));
    }

}

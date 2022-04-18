package com.llayjun.millet.api;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.llayjun.millet.common.annotation.UserToken;
import com.llayjun.millet.common.entity.BaseResult;
import com.llayjun.millet.module.articleType.dto.AddArticleTypeDTO;
import com.llayjun.millet.module.articleType.entity.ArticleType;
import com.llayjun.millet.module.articleType.service.IArticleTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping(APP_URI_V1 +"/articleType")
@Api(tags = "文章类型接口")
public class ArticleTypeController {

    @Autowired
    private IArticleTypeService iArticleTypeService;

    /**
     * 新增文章类型
     */
    @PostMapping("/addArticleType")
    @ApiOperation(value = "新增文章类型")
    @UserToken
    public BaseResult addArticleType(@Validated @RequestBody AddArticleTypeDTO addArticleTypeDTO) {
        if (addArticleTypeDTO.getArticleType() == 0) {
            return BaseResult.error("不可使用0类型");

        }
        // 判断该类型是否存在
        LambdaQueryWrapper<ArticleType> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(ArticleType::getArticleType, addArticleTypeDTO.getArticleType());
        int count = iArticleTypeService.count(wrapper);
        if (count > 0) {
            return BaseResult.error("该类型已经存在");
        }
        ArticleType article = new ArticleType();
        BeanUtils.copyProperties(addArticleTypeDTO, article);
        boolean state = iArticleTypeService.save(article);
        if (state) {
            return BaseResult.success();
        } else {
            return BaseResult.error("新增失败");
        }
    }

    /**
     * 获取所有文章类型
     */
    @GetMapping("/getArticleTypeList")
    @ApiOperation(value = "获取所有文章类型")
    @UserToken
    public BaseResult<List<ArticleType>> getArticleTypeList() {
        return BaseResult.success(iArticleTypeService.getArticleTypeList());
    }

}

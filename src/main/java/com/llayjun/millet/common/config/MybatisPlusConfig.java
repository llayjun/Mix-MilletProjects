package com.llayjun.millet.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * MybatisPlus配置
 *
 * @author zyl
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * <p>设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
     * <p>paginationInterceptor.setOverflow(false);
     * <p>设置最大单页限制数量，默认 500 条，-1 不受限制
     * <p>paginationInterceptor.setLimit(500);
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 插入与更新时,自动填充字段 策略
     * @return 插入与更新时, 自动填充字段 策略
     */
    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new MetaObjectHandler() {
            @Override
            public void insertFill(MetaObject metaObject) {
//                ApiManager user = ApiManagerHolder.getUser();
//                if (user != null) {
//                    this.setInsertFieldValByName("createdId", user.getId(), metaObject);
//                    this.setInsertFieldValByName("createdName", user.getName(), metaObject);
//                }
                this.setInsertFieldValByName("createdTime", LocalDateTime.now(), metaObject);
            }

            @Override
            public void updateFill(MetaObject metaObject) {
//                ApiManager user = ApiManagerHolder.getUser();
//                if (user != null) {
//                    this.setUpdateFieldValByName("updatedId", user.getId(), metaObject);
//                    this.setUpdateFieldValByName("updatedName", user.getName(), metaObject);
//                }
                this.setUpdateFieldValByName("updatedTime", LocalDateTime.now(), metaObject);
            }
        };
    }

}

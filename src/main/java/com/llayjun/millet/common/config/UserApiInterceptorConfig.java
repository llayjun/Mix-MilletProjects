package com.llayjun.millet.common.config;

import com.llayjun.millet.common.constant.Constants;
import com.llayjun.millet.common.interceptor.UserApiInterceptor;
import com.llayjun.millet.common.utils.CurrentUserHandlerMethodArgResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Token配置
 */
@Configuration
public class UserApiInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns(Constants.APP_URI_V1 + "/**");
    }

    @Bean
    public UserApiInterceptor authenticationInterceptor() {
        return new UserApiInterceptor();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        // 注册@CurrentUser注解的实现类
        resolvers.add(new CurrentUserHandlerMethodArgResolver());
    }
}

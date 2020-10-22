package com.llayjun.millet.common.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableSwaggerBootstrapUi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * swagger config
 *
 * @author 111
 * @since 2019/9/28
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUi
public class SwaggerConfig {
    @Bean
    public Docket apiClient() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .groupName("App端API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.llayjun.millet.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Millet API",
                "API文档，有问题请联系我们 - Millet",
                "API TOS",
                "Terms of service",
                new Contact("Millet", "", ""),
                "License of API", "API license URL", Collections.emptyList());
    }

}

package com.zyz.springbootfastdfs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author: zyz
 * @date: 4/2/20 - 1:23 PM
 * @function:
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zyz.springbootfastdfs"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("仰天长啸出门去，我辈岂是蓬蒿人")
                .description("使用RestFul风格, build by:zyz")
                .termsOfServiceUrl("https://blog.csdn.net/yixinshark")
                .version("version 1.0")
                .build();
    }
}
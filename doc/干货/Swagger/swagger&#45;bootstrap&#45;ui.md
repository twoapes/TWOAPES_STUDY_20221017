# swagger&#45;bootstrap&#45;ui

[详情参考](https://www.w3cschool.cn/swaggerbootstrapui/swaggerbootstrapui-4cvg32hw.html)

## pom.xml

```Java
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>3.0.0</version>
        </dependency>
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>swagger-bootstrap-ui</artifactId>
            <version>1.9.6</version>
        </dependency>
```

## 配置文件

SwaggerConfig.java

```Java
package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author add by huyingzhao
 * 2022-06-01 12:37
 */
@Configuration
@EnableSwagger2
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("springboot.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("TWOAPES", "https://gitee.com/huyingzhao", "1005958794@qq.com");
        return new ApiInfoBuilder()
                .title("TWOAPES_SPRINGBOOT API说明文档")
                .description("本模块是纯SpringBoot项目")
                .termsOfServiceUrl("http://127.0.0.1:8084/doc.html")
                .contact(contact)
                .version("1.0.2")
                .build();
    }
}

```

## Application入口

```Java
package application;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.spring.web.SpringfoxWebMvcConfiguration;

/**
 * @author add by huyingzhao
 * 2022-09-26 15:09
 */
@ConditionalOnClass(SpringfoxWebMvcConfiguration.class)
public class SpringBootApplication implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}

```

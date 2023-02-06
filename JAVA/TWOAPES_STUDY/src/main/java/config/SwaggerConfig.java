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
        Contact contact = new Contact("TWOAPES_SPRINGBOOT", "https://gitee.com/huyingzhao", "1005958794@qq.com");
        return new ApiInfoBuilder()
                .title("TWOAPES_SPRINGBOOT API doc")
                .description("a pure SpringBoot project")
                .termsOfServiceUrl("http://127.0.0.1:8084/doc.html")
                .contact(contact)
                .version("1.0.2")
                .build();
    }
}

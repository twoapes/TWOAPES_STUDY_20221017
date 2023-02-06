package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.nio.charset.StandardCharsets;

/**
 * @author add by huyingzhao
 * 2022-06-01 12:04
 */
@Configuration
public class MultipartConfig {

    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding(StandardCharsets.UTF_8.name());
        resolver.setResolveLazily(true);
        int max = 20 * 1024 * 1024;
        resolver.setMaxInMemorySize(max);
        resolver.setMaxUploadSize(max);
        return resolver;
    }
}
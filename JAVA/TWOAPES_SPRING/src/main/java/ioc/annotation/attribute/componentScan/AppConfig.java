package ioc.annotation.attribute.componentScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author add by huyingzhao
 * 2022-08-07 16:57
 * includeFilter include
 * excludeFilters exclude
 */
@ComponentScan(value = "ioc.annotation.attribute.componentScan", includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ComponentScanAnnotation.class))
public class AppConfig {
}
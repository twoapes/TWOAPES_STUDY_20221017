package domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author huyingzhao
 * 2022-01-23 18:50:20
 * Returns the attribute value of the object by using the Component annotation
 */
@Component
@ConfigurationProperties(prefix = "url")
@Data
public class PropertiesDo {
    private String param;
    private int paramId;
}

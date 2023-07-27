package core.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author add by huyingzhao
 * 2023-07-21 09:49
 */
@Component
@Data
public class NamePOJO {
    @Value("${name.name1}")
    private String name1;
    @Value("${name.name2}")
    private String name2;
    @Value("${name.ming}")
    private String ming;
}

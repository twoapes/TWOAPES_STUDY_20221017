package spring.ioc.annotation.attribute.value;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author add by huyingzhao
 * 2022-08-07 0:20
 */
@Service
@Data
public class ValueService {
    @Value("${hyz.name}")
    private String value1;
    @Value("hyz.name")
    private String value2;
    @Value("#{valueSharp}")
    private ValueSharp value3;
    @ValueAnnotation
    private String value4;
}
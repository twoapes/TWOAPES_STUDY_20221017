package domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author add by huyingzhao
 * 2022-08-22 10:25
 */
@Component
@Data
public class MachineTranslationDo {
    @Value("${machine.id}")
    private String id;
    @Value("${machine.secret}")
    private String secret;
    @Value("${machine.key}")
    private String key;
}

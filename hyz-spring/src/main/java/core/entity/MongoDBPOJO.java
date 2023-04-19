package core.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author huyingzhao
 * 2022-05-18 10:01
 */
@Component
@Data
public class MongoDBPOJO {
    @Value("${mongodb.host}")
    private String host;
    @Value("${mongodb.port}")
    private int port;
    @Value("${mongodb.databaseName}")
    private String databaseName;
    @Value("${mongodb.username}")
    private String username;
    @Value("${mongodb.source}")
    private String source;
    @Value("${mongodb.password}")
    private String password;
}
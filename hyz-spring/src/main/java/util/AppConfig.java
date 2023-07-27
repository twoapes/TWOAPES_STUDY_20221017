package util;

import core.entity.JdbcPOJO;
import core.entity.MongoDBPOJO;
import core.entity.NamePOJO;
import core.entity.SftpPOJO;
import core.jdbc.mongodb.impl.MongodbServiceImpl;
import core.jdbc.primitive.impl.JdbcConnectServiceImpl;
import core.jdbc.primitive.impl.JdbcExecuteServiceImpl;
import core.jdbc.primitive.impl.JdbcSelectServiceImpl;
import core.name.impl.NameServiceImpl;
import core.sftp.impl.SftpServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author add by huyingzhao
 * 2022-08-07 15:41
 */
@ComponentScan({"core.jdbc.mongodb", "core.jdbc.primitive", "core.sftp", "core.entity",})
@PropertySource("classpath:hyz.properties")
public class AppConfig {
    @Bean
    public JdbcPOJO jdbcPOJO() {
        return new JdbcPOJO();
    }

    @Bean
    public MongoDBPOJO mongoDBPOJO() {
        return new MongoDBPOJO();
    }

    @Bean
    public MongodbServiceImpl mongodbServiceImpl(MongoDBPOJO mongoDBPOJO) {
        return new MongodbServiceImpl(mongoDBPOJO);
    }

    @Bean
    public JdbcConnectServiceImpl jdbcConnectServiceImpl(JdbcPOJO jdbcPOJO) {
        return new JdbcConnectServiceImpl(jdbcPOJO);
    }

    @Bean
    public JdbcExecuteServiceImpl jdbcExecuteServiceImpl(JdbcPOJO jdbcPOJO) {
        return new JdbcExecuteServiceImpl(jdbcPOJO);
    }

    @Bean
    public JdbcSelectServiceImpl jdbcSelectServiceImpl(JdbcPOJO jdbcPOJO) {
        return new JdbcSelectServiceImpl(jdbcPOJO);
    }

    @Bean
    public SftpServiceImpl sftpServiceImpl(SftpPOJO sftpPOJO) {
        return new SftpServiceImpl(sftpPOJO);
    }

    @Bean
    public NameServiceImpl nameServiceImpl(NamePOJO namePOJO) {
        return new NameServiceImpl(namePOJO);
    }
}
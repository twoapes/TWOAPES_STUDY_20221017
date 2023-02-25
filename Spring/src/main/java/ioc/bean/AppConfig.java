package ioc.bean;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

/**
 * @author add by huyingzhao
 * 2022-08-07 15:18
 */
@ComponentScan("ioc.bean")
public class AppConfig {
    /**
     * @return BeanService
     * @author add by huyingzhao
     * 2022-08-07 14:52
     */
//    @Autowired
//    @Bean(autowire = Autowire.BY_NAME)
    @Bean(autowire = Autowire.BY_TYPE)
    public BeanService BeanService() {
        return new BeanService();
    }

    /**
     *
     * @return BeanDao2
     * @author add by huyingzhao
     * 2022-08-07 15:33
     */
    @Bean(autowireCandidate = false)
    public BeanDao BeanDao1() {
        //The bean is still available, but it is not having an autowire effect
        return new BeanDao();
    }

    /**
     * @return BeanDao2
     * @author add by huyingzhao
     * 2022-08-07 15:32
     */
    @Bean(autowireCandidate = true)
    public BeanDao2 BeanDao2() {
        return new BeanDao2();
    }

    /**
     * @return BeanDao3
     * @author add by huyingzhao
     * 2022-08-07 15:32
     */
    @Bean
    @Scope("prototype")
    public BeanDao3 BeanDao3() {
        return new BeanDao3();
    }

    /**
     * @return BeanDao4
     * @author add by huyingzhao
     * 2022-08-07 15:32
     */
    @BeanAnnotation
    public BeanDao4 BeanDao4() {
        return new BeanDao4();
    }
}
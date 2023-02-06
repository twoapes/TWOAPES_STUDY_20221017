package spring.ioc.xml.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-09-30 23:33
 */
@Data
@Slf4j
public class LifeCycle2 {
    private String name;

    public LifeCycle2() {
        log.info("the first step:call ioc.xml.pojo.LifeCycle2.LifeCycle2");
    }

    public void setName(String name) {
        log.info("the second step:call ioc.xml.pojo.LifeCycle2.setName");
        this.name = name;
    }

    public void init() {
        log.info("The fourth step:call ioc.xml.pojo.LifeCycle2.init");
    }

    public void destroy() {
        log.info("The seventh step:call ioc.xml.pojo.LifeCycle2.destroy");
    }
}
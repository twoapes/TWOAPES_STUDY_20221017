package ioc.xml.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-09-30 23:33
 */
@Data
@Slf4j
public class LifeCycle {
    private String name;

    public LifeCycle() {
        log.info("the first step:call {}","ioc.xml.pojo.LifeCycle.LifeCycle");
    }

    public void setName(String name) {
        log.info("the second step:call {}","ioc.xml.pojo.LifeCycle.setName");
        this.name = name;
    }

    public void init() {
        log.info("the third step:call {}","ioc.xml.pojo.LifeCycle.init");
    }

    public void destroy() {
        log.info("The fifth step:call {}","ioc.xml.pojo.LifeCycle.destroy");
    }
}
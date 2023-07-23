package pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2023-02-24 13:19
 */
@Data
@Slf4j
public class UnLifeCycle {
    private String name;

    public UnLifeCycle() {
        log.info("the first step:pojo.UnLifeCycle.UnLifeCycle");
    }

    public void setName(String name) {
        log.info("the second step:call pojo.UnLifeCycle.setName");
        this.name = name;
    }

    public void init() {
        log.info("The fourth step:call pojo.LifeCycle2.init");
    }

    public void destroy() {
        log.info("The seventh step:call pojo.LifeCycle2.destroy");
    }
}
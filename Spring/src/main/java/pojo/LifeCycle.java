package pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2023-02-24 13:19
 */
@Data
@Slf4j
public class LifeCycle {
    private String name;

    public LifeCycle() {
        log.info("the first step:call pojo.LifeCycle.LifeCycle");
    }

    public void setName(String name) {
        log.info("the second step:call pojo.LifeCycle.setName");
        this.name = name;
    }

    public void init() {
        log.info("the third step:call pojo.LifeCycle.init");
    }

    public void destroy() {
        log.info("The fifth step:call pojo.LifeCycle.destroy ");
    }
}

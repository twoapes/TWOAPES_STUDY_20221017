package oop;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author add by huyingzhao
 * 2023-03-14 14:23
 */
@Slf4j
public class LifeCycleTest {
    /**
     * 对象的生命周期
     *
     * @author add by huyingzhao
     * 2023-03-14 14:28
     */
    @Test
    public void lifeCycle() {
        //创建 LifeCycle 对象
        LifeCycle lifeCycle1 = new LifeCycle("Alice");
        // 使用 LifeCycle 对象
        log.info("lifeCycle1:{}", lifeCycle1);
        LifeCycle lifeCycle2 = lifeCycle1;
        log.info("lifeCycle1:{}", lifeCycle1);
        log.info("lifeCycle2:{}", lifeCycle2);
        // 不再使用 LifeCycle 对象
        lifeCycle1 = null;
        log.info("lifeCycle1:{}", lifeCycle1);
        log.info("lifeCycle2:{}", lifeCycle2);
        // 强制调用垃圾回收器，销毁对象
        System.gc();
    }
}

@Slf4j
class LifeCycle {
    private String name; // 私有成员变量

    // 构造函数，在创建对象时调用
    public LifeCycle(String name) {
        this.name = name;
        log.info("Created a Person object with name {}", name);
    }

    // 公共方法来获取 name 变量的值
    public String getName() {
        return name;
    }
    // 公共方法来设置 name 变量的值
    public void setName(String name) {
        this.name = name;
    }
    // finalize() 方法，在对象被销毁时调用
    protected void finalize() {
        log.info("Destroyed a Person object with name {}", name);
    }
}
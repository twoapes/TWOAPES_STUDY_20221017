package oop;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author add by huyingzhao
 * 2023-03-13 16:09
 * 面向对象
 */
@Slf4j
public class OopTest {
    /**
     * 面向对象
     *
     * @author add by huyingzhao
     * 2023-03-13 16:11
     */
    @Test
    public void oop() {
        //2.创建Oop对象
        Oop oop = new Oop();
        //3.调用对象的结构:属性,方法
        //调用属性:"对象.属性"
        oop.name = "小明";
        oop.is = true;
        log.info(oop.name);
        //调用方法:"对象.方法"
        oop.oop();
    }
}

/**
 * 1.创建类，设计类的成员
 */
@Slf4j
class Oop {
    //属性
    String name;
    boolean is;
    public void oop() {
        log.info("oop");
    }
}
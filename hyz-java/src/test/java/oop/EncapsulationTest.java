package oop;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author add by huyingzhao
 * 2023-03-13 22:18
 * 数据域的封装
 */
@Slf4j
public class EncapsulationTest {

    @Test
    public void encapsulation() {
        // 实例化 Person 类
        Person person = new Person();
        // 使用 setName() 方法设置 name 变量的值
        person.setName("Alice");
        // 使用 getName() 方法获取 name 变量的值并输出
        log.info("person:{}", person.getName()); // 输出 "Name: Alice"
    }
}

class Person {
    private String name; // 私有成员变量

    // 公共方法来获取 name 变量的值
    public String getName() {
        return name;
    }

    // 公共方法来设置 name 变量的值
    public void setName(String name) {
        this.name = name;
    }
}
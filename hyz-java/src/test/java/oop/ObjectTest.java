package oop;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author add by huyingzhao
 * 2023-04-19 16:16
 */

public class ObjectTest {
    @Test
    public void objectDemo() {
        Animal animal = new Animal("动物", 1);
        Dog dog = new Dog("小狗", 2);
        Cat cat = new Cat("小猫", 3);

        animal.sayHello();
        dog.sayHello();
        cat.sayHello();

        animal.eat();
        dog.eat();
        cat.eat();

        animal.sleep();
        dog.sleep();
        cat.sleep();

        dog.bark();
        cat.meow();
    }
}

@Data
@Slf4j
class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        log.info(name + "正在吃东西");
    }

    public void sleep() {
        log.info(name + "正在睡觉");
    }

    public void sayHello() {
        log.info("我是一只动物，我的名字是" + name + "，我今年" + age + "岁了");
    }
}

@Slf4j
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    public void bark() {
        log.info(getName() + "正在汪汪叫");
    }
}

@Slf4j
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    public void meow() {
        log.info(getName() + "正在喵喵叫");
    }
}

# Class类

对象照镜子后可以得到的信息：某个类的属性、方法和构造器、某个类到底实现了哪些接口

对于每个类而言，JRE 都为其保留一个不变的 Class 类型的对象

一个 Class 对象包含了特定某个结构(`class/interface/enum/annotation/primitive type/void/[]`)的有关信息

- Class本身也是一个类

- Class 对象只能由系统建立对象

- 一个加载的类在 JVM 中只会有一个Class实例

- 一个Class对象对应的是一个加载到JVM中的一个.class文件

- 每个类的实例都会记得自己是由哪个 Class 实例所生成

- 通过Class可以完整地得到一个类中的所有被加载的结构

- Class类是Reflection的根源，针对任何你想动态加载、运行的类，唯有先获得相应的Class对象

在Object类中定义了以下的方法,此方法将所有子类继承

`public final Class getClass()`

以上的方法返回值的类型是一个Class类，此类是Java反射的源头， 实际上所谓反射从程序的运行结果来看也很好理解
即：可以通过对象反射求出类的名称

## Class类的常用方法

`java.lang.Class`类提供了许多方法来获取和操作类的信息。以下是`Class`类的一些常用方法：

1. `getName()`: 返回类的名称，包括包名。

2. `getSimpleName()`: 返回类的简单名称，不包括包名。

3. `getPackage()`: 返回表示类所在包的`Package`对象。

4. `getSuperclass()`: 返回类的父类。

5. `getInterfaces()`: 返回类实现的接口数组。

6. `getModifiers()`: 返回类的修饰符，以整数形式表示。

7. `isInterface()`: 判断当前类是否为接口。

8. `isArray()`: 判断当前类是否为数组。

9. `isPrimitive()`: 判断当前类是否为基本类型。

10. `getConstructors()`: 返回类的所有公共构造函数。

11. `getDeclaredConstructors()`: 返回类的所有构造函数，包括公共、保护、默认（包内可见）和私有构造函数。

12. `getMethod(String name, Class<?>... parameterTypes)`: 返回指定方法名和参数类型的公共方法。

13. `getDeclaredMethod(String name, Class<?>... parameterTypes)`: 返回指定方法名和参数类型的方法，包括公共、保护、默认（包内可见）和私有方法。

14. `getMethods()`: 返回类的所有公共方法，包括从父类继承的方法。

15. `getDeclaredMethods()`: 返回类的所有方法，包括公共、保护、默认（包内可见）和私有方法。

16. `getField(String name)`: 返回指定名称的公共字段。

17. `getDeclaredField(String name)`: 返回指定名称的字段，包括公共、保护、默认（包内可见）和私有字段。

18. `getFields()`: 返回类的所有公共字段，包括从父类继承的字段。

19. `getDeclaredFields()`: 返回类的所有字段，包括公共、保护、默认（包内可见）和私有字段。

20. `newInstance()`: 创建该类的一个新实例（要求类必须有一个无参数的构造函数）。

这些方法只是`Class`类提供的部分常用方法，还有其他更多方法可用于获取和操作类的信息。通过这些方法，可以动态地获取类的结构和成员，并进行相应的操作。

以下是使用`Class`类的一些常用方法的示例代码：

```java
import java.lang.reflect.*;

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        // 获取Class对象的方式一：使用.class语法
        Class<Person> personClass = Person.class;

        // 获取Class对象的方式二：使用Class.forName()方法
        Class<?> personClass2 = Class.forName("Person");

        // 获取Class对象的方式三：使用对象的getClass()方法
        Person person = new Person();
        Class<? extends Person> personClass3 = person.getClass();

        // 获取类的名称
        System.out.println("类的名称：" + personClass.getName());

        // 获取类的简单名称
        System.out.println("类的简单名称：" + personClass.getSimpleName());

        // 获取类的包信息
        Package pkg = personClass.getPackage();
        System.out.println("类所在包：" + pkg.getName());

        // 获取父类
        Class<?> superClass = personClass.getSuperclass();
        System.out.println("父类：" + superClass.getName());

        // 获取实现的接口
        Class<?>[] interfaces = personClass.getInterfaces();
        System.out.println("实现的接口：");
        for (Class<?> intf : interfaces) {
            System.out.println(intf.getName());
        }

        // 获取构造函数
        Constructor<?>[] constructors = personClass.getConstructors();
        System.out.println("构造函数：");
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }

        // 获取公共方法
        Method[] methods = personClass.getMethods();
        System.out.println("公共方法：");
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        // 获取公共字段
        Field[] fields = personClass.getFields();
        System.out.println("公共字段：");
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        // 创建对象实例
        Person personInstance = personClass.newInstance();
        System.out.println("创建的对象实例：" + personInstance);
    }
}

class Person {
    private String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello, I'm " + name);
    }
}
```

在上述示例中，我们使用了不同的方式来获取`Class`对象，并使用了各种方法来获取类的名称、父类、实现的接口、构造函数、方法和字段等信息。最后，我们还通过反射创建了一个`Person`类的对象实例，并输出了创建的对象实例。请注意，为了简化示例，省略了异常处理部分。实际使用中应该根据需要进行适当的异常处理。

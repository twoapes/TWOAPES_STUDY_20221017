# 获取Class类的实例

若已知具体的类，通过类的class属性获取，该方法最为安全可靠，程序性能最高

> `Class clazz = String.class;`

若已知某个类的实例，调用该实例的getClass()方法获取Class对象

> `Class clazz = "www.atguigu.com".getClass();`

若已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法forName()获取，可能抛出ClassNotFoundException

> `Class clazz = Class.forName("java.lang.String");`

```java
ClassLoader cl = this.getClass().getClassLoader();
Class clazz4 = cl.loadClass(“类的全类名”);
Class c1 = Object.class;
Class c2 = Comparable.class;
Class c3 = String[].class;
Class c4 = int[][].class;
Class c5 = ElementType.class;
Class c6 = Override.class;
Class c7 = int.class;
Class c8 = void.class;
Class c9 = Class.class;
int[] a = new int[10];
int[] b = new int[100];
Class c10 = a.getClass();
Class c11 = b.getClass();
// 只要元素类型与维度一样，就是同一个Class
System.out.println(c10 == c11);
```

下面是一个演示如何获取`Class`类的实例的示例代码：

```java
public class ClassInstanceDemo {
    public static void main(String[] args) throws Exception {
        // 获取Class对象的方式一：使用.class语法
        Class<Person> personClass = Person.class;
        System.out.println("方式一：" + personClass);

        // 获取Class对象的方式二：使用Class.forName()方法
        Class<?> personClass2 = Class.forName("Person");
        System.out.println("方式二：" + personClass2);

        // 获取Class对象的方式三：使用对象的getClass()方法
        Person person = new Person();
        Class<? extends Person> personClass3 = person.getClass();
        System.out.println("方式三：" + personClass3);
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

在上述示例中，我们使用了三种方式来获取`Class`类的实例，分别是使用`.class`语法、`Class.forName()`方法和对象的`getClass()`方法。每种方式都返回一个`Class`对象，代表了对应类的元数据信息。然后，我们将获取到的`Class`对象输出到控制台。

请注意，获取`Class`对象时可能会抛出`ClassNotFoundException`异常，因此在实际使用时需要进行适当的异常处理。

# Object类

- Object类是所有Java类的根父类

- 如果在类的声明中未使用extends关键字指明其父类，则默认父类

![image.png](https://flowus.cn/preview/acb9e075-f38f-49f8-b7ff-51fee10f7839)

`Object`类是Java中所有类的根类，它定义了一些通用的方法，可以在所有类中使用。下面是一些使用`Object`类的示例：

1.创建对象并打印字符串表示：

```java
public class MyClass {
    private int value;

    public MyClass(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyClass[value=" + value + "]";
    }
}

MyClass obj = new MyClass(10);
System.out.println(obj); // 输出：MyClass[value=10]
```

2.比较对象的相等性：

```java
MyClass obj1 = new MyClass(10);
MyClass obj2 = new MyClass(10);
MyClass obj3 = obj1;

System.out.println(obj1.equals(obj2)); // 输出：false
System.out.println(obj1.equals(obj3)); // 输出：true
```

3.获取对象的哈希码：

```java
MyClass obj = new MyClass(10);
int hashCode = obj.hashCode();
System.out.println("哈希码: " + hashCode);
```

4.克隆对象：

```java
public class MyClass implements Cloneable {
    private int value;

    public MyClass(int value) {
        this.value = value;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

MyClass obj1 = new MyClass(10);
MyClass obj2 = (MyClass) obj1.clone();
System.out.println(obj1 == obj2); // 输出：false
```

5.获取对象的运行时类：

```java
MyClass obj = new MyClass(10);
Class<?> clazz = obj.getClass();
System.out.println("运行时类: " + clazz.getName());
```

这些示例展示了一些常见的`Object`类的用法。`Object`类提供了一些通用的方法，如`toString()`、`equals()`、`hashCode()`、`clone()`和`getClass()`，这些方法可以在所有类中使用。其他许多Java类都是`Object`类的子类，因此它们继承了这些通用方法，并可以根据需要进行重写或扩展。

## toString()方法

`toString()`方法是`Object`类中定义的方法，用于返回对象的字符串表示。在默认情况下，`toString()`方法返回的是包含类名和哈希码的字符串。通常情况下，我们可以在自定义的类中重写`toString()`方法，以返回更有意义的对象字符串表示。下面是一个示例：

```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person[name=" + name + ", age=" + age + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        Person person = new Person("John Doe", 25);
        System.out.println(person.toString());
    }
}
```

输出结果为：`Person[name=John Doe, age=25]`。

在上述示例中，我们重写了`Person`类的`toString()`方法，以返回包含姓名和年龄的字符串表示。当我们调用`System.out.println(person.toString())`时，实际上会自动调用`toString()`方法并打印其返回值。

重写`toString()`方法可以方便我们在输出对象时得到更具可读性和信息性的字符串表示，方便调试和理解对象的内容。

## ==操作符与equals方法

### ==

基本类型比较值:只要两个变量的值相等，即为true

引用类型比较引用(是否指向同一个对象)：只有指向同一个对象时，==才返回true

用“==”进行比较时，符号两边的数据类型必须兼容(可自动转换的基本数据类型除外)，否则编译出错

### equals

equals()：所有类都继承了Object，也就获得了equals()方法。还可以重写

只能比较引用类型，其作用与“==”相同,比较是否指向同一个对象

```java
obj1.equals(obj2)
```

特例：当用equals()方法进行比较时，对类File、String、Date及包装类（Wrapper Class）来说，是比较类型及内容而不考虑引用的是否是同一个对象
原因：在这些类中重写了Object类的equals()方法
当自定义使用equals()时，可以重写。用于比较两个对象的“内容”是否都相等

重写equals()方法的原则

- 对称性：如果x.equals(y)返回是“true”，那么y.equals(x)也应该返回是“true”

- 自反性：x.equals(x)必须返回是“true”

- 传递性：如果x.equals(y)返回是“true”，而且y.equals(z)返回是“true”，那么z.equals(x)也应该返回是“true”

- 一致性：如果x.equals(y)返回是“true”，只要x和y内容一直不变，不管你重复x.equals(y)多少次，返回都是“true”

- 任何情况下，x.equals(null)，永远返回是“false”； x.equals(和x不同类型的对象)永远返回是“false

在Java中，`==`操作符和`equals()`方法都用于比较两个对象的相等性，但它们之间有一些重要的区别。

`==`操作符比较的是两个对象的引用是否相等，即判断两个对象是否指向同一块内存地址。如果两个对象的引用相同，即指向同一个内存地址，那么`==`操作符返回`true`；否则，返回`false`。`==`操作符通常用于比较基本类型的变量或判断两个对象是否是同一个对象的实例。

`equals()`方法用于比较两个对象的内容是否相等，即判断两个对象是否在逻辑上相等。默认情况下，`equals()`方法和`==`操作符的行为是一样的，即比较两个对象的引用是否相等。然而，许多类（如`String`、`Integer`等）重写了`equals()`方法，以便根据对象的内容来进行相等性判断。重写`equals()`方法的类可以根据自己的需求定义相等性的标准，比较对象的字段或属性是否相等。通常情况下，重写`equals()`方法时也需要重写`hashCode()`方法，以保持对象的一致性。

下面是一个示例，展示了`==`操作符和`equals()`方法的使用及区别：

```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("John Doe", 25);
        Person person2 = new Person("John Doe", 25);
        Person person3 = person1;

        System.out.println(person1 == person2); // false
        System.out.println(person1.equals(person2)); // true

        System.out.println(person1 == person3); // true
        System.out.println(person1.equals(person3)); // true
    }
}
```

在上述示例中，我们创建了两个`Person`对象，它们的内容相同但是引用不同。通过`==`操作符比较时，返回`false`，因为它们的引用不同。而通过`equals()`方法比较时，返回`true`，因为我们重写了`equals()`方法，根据对象的内容来进行相等性判断。

总结起来，`==`操作符比较的是两个对象的引用是否相等，而`equals()`方法比较的是两个对象的内容是否相等。对于自定义类，通常需要重写`equals()`方法来定义对象相

等的条件。

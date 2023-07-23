# 浅谈JavaBean

JavaBean是指符合一定规范的Java类，它是一种可重用的软件组件，可以用于在应用程序中存储数据。JavaBean通常用于表示实体对象，例如数据库表中的记录、业务逻辑中的数据结构等等。

JavaBean有一个基本的要求，就是它必须是可序列化的，这意味着它可以被存储在磁盘上或者通过网络传输。为了符合这个要求，JavaBean类必须实现Serializable接口。

以下是一个简单的JavaBean示例：

```java
public class Person implements Serializable {  
    private static final long serialVersionUID = 1L;  
    private String name;  
    private int age;  
      
    public Person() {}  
      
    public Person(String name, int age) {  
        this.name = name;  
        this.age = age;  
    }  
      
    public String getName() {  
        return name;  
    }  
      
    public void setName(String name) {  
        this.name = name;  
    }  
      
    public int getAge() {  
        return age;  
    }  
      
    public void setAge(int age) {  
        this.age = age;  
    }  
}
```

在这个示例中，Person类是一个JavaBean，它有两个属性（name和age），以及它们的访问器和设值器方法。这个类还实现了Serializable接口，表示它可以被序列化。

现在我们可以使用这个JavaBean来创建一个示例程序：

```java
public class Demo {  
    public static void main(String[] args) {  
        Person person = new Person("张三", 20);  
        System.out.println("姓名：" + person.getName());  
        System.out.println("年龄：" + person.getAge());  
    }  
}
```

在这个示例中，我们创建了一个Person对象，并使用它的访问器方法打印出了它的姓名和年龄。这个示例程序演示了如何使用JavaBean来存储和访问数据。

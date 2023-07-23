# JDK中的元注解

JDK 的元 Annotation 用于修饰其他 Annotation 定义

JDK5.0提供了4个标准的meta-annotation类型

JDK（Java Development Kit）中的元注解（Meta-Annotation）是用于定义注解的注解。通过使用元注解，我们可以定义新的注解，这些注解可以用于注解其他的Java元素，如类、方法、字段等。元注解提供了许多有用的特性，例如指定注解的保留时间、修饰位置、是否有文档、是否有继承性、是否可以重复使用等。

以下是JDK中常用的元注解：

@Target: 用于指定注解的应用目标。可以用来限制注解的使用范围，例如@Target(ElementType.METHOD)表示该注解只能用于方法上。
@Retention: 用于指定注解的保留时间。可以设置注解在源代码中保留、编译时保留或运行时保留。常见的保留时间策略有RetentionPolicy.SOURCE（注解只保留在源代码中）、RetentionPolicy.CLASS（注解保留在编译时的字节码中）和RetentionPolicy.RUNTIME（注解保留在运行时的字节码中）。
@Documented: 用于指定该注解应该被文档化。如果一个注解被标记为@Documented，那么它应该被包含在Java文档中。
@Inherited: 用于指定该注解是否可以被继承。如果一个注解被标记为@Inherited，那么它的子类将自动继承该注解。
@Repeatable: 用于指定该注解是否可以重复使用。如果一个注解被标记为@Repeatable，那么它可以在同一个元素上重复使用。

## @Retention

只能用于修饰一个Annotation定义, 用于指定该Annotation的生命周期, @Rentention包含一个RetentionPolicy类型的成员变量, 使用时必须为该value成员变量指定值

RetentionPolicy.SOURCE:在源文件中有效（即源文件保留），编译器直接丢弃这种策略的注释
RetentionPolicy.CLASS:在class文件中有效（即class保留） ， 当运行 Java 程序时, JVM不会保留注解。 这是默认值
RetentionPolicy.RUNTIME:在运行时有效（即运行时保留），当运行 Java 程序时, JVM 会保留注释。程序可以通过反射获取该注释

## @Target

用于修饰 Annotation 定义, 用于指定被修饰的 Annotation 能用于修饰哪些程序元素。

@Target 也包含一个名为 value 的成员变量

@Target 注解可以用于以下几个值：

ElementType.ANNOTATION_TYPE：表示该注解可以用于注解类型（也就是定义新的注解）。
ElementType.CONSTRUCTOR：表示该注解可以用于构造函数。
ElementType.FIELD：表示该注解可以用于字段（也就是成员变量）。
ElementType.LOCAL_VARIABLE：表示该注解可以用于局部变量。
ElementType.METHOD：表示该注解可以用于方法。
ElementType.PACKAGE：表示该注解可以用于包。
ElementType.PARAMETER：表示该注解可以用于方法参数。
ElementType.TYPE：表示该注解可以用于类、接口、枚举等类型声明。

## @Documented

用于指定被该元 Annotation 修饰的 Annotation 类将被javadoc 工具提取成文档

默认情况下，javadoc是不包括注解的。定义为Documented的注解必须设置Retention值为RUNTIME

## @Inherited

被它修饰的 Annotation 将具有继承性

如果某个类使用了被@Inherited 修饰的 Annotation, 则其子类将自动具有该注解

以下是一个使用JDK中的元注解的示例代码：

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyAnnotation {
    String value();
}

@MyAnnotation("示例注解")
public class MetaAnnotationDemo {
    public static void main(String[] args) {
        Class<?> clazz = MetaAnnotationDemo.class;
        
        // 检查类上是否存在指定的元注解
        boolean hasAnnotation = clazz.isAnnotationPresent(MyAnnotation.class);
        if (hasAnnotation) {
            MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);
            System.out.println("类上的注解值: " + annotation.value());
        }
    }
}
```

在示例代码中，我们定义了一个自定义注解`@MyAnnotation`。这个注解使用了两个元注解：

- `@Retention(RetentionPolicy.RUNTIME)`：指定注解的保留策略为运行时，即注解信息在运行时仍然可用。

- `@Target(ElementType.TYPE)`：指定注解的适用目标为类（包括接口、枚举等）。

然后，在`MetaAnnotationDemo`类上使用了`@MyAnnotation("示例注解")`注解，为该类添加了自定义注解，并传入了注解值。

在`main`方法中，我们通过`isAnnotationPresent()`方法检查`MetaAnnotationDemo`类上是否存在指定的元注解`@MyAnnotation`。如果存在该注解，我们使用`getAnnotation()`方法获取注解的实例，并打印注解值。

运行该示例代码，将会输出以下结果：

```java
类上的注解值: 示例注解
```

这说明通过使用元注解，我们可以定义和使用自定义注解，并在代码中通过反射机制获取注解信息。元注解可以用于指定注解的保留策略、适用目标等元数据，扩展了注解的功能和灵活性。

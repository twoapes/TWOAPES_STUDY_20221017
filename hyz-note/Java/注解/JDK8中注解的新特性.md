# JDK8中注解的新特性

Java 8对注解处理提供了两点改进：可重复的注解及可用于类型的注解
此外，反射也得到了加强，在Java8中能够得到方法参数的名称。这会简化标注在方法参数上的注解

## 可重复注解

1.声明Repeatable

2.Repeatable修饰的注解和另一个注解的元注解要一致

在Java中，您可以使用`@Repeatable`注解来创建可重复注解。下面是一个详细的示例，展示了如何实现可重复注解：

首先，定义一个可重复注解的容器注解：

```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CustomAnnotations {
    CustomAnnotation[] value();
}
```

在上述示例中，我们创建了一个名为`CustomAnnotations`的容器注解，用于容纳多个`CustomAnnotation`注解。

接下来，定义一个自定义注解`CustomAnnotation`：

```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(CustomAnnotations.class)
public @interface CustomAnnotation {
    String value();
}
```

在上述示例中，我们使用了`@Repeatable`注解，并指定了容器注解为`CustomAnnotations.class`。这样，我们就可以将`CustomAnnotation`注解应用于同一目标上多次。

现在，我们可以在代码中使用可重复注解。以下是一个示例：

```java
@CustomAnnotation("Annotation 1")
@CustomAnnotation("Annotation 2")
public class MyClass {
    // 类实现
}
```

在上述示例中，我们将`@CustomAnnotation`注解应用于`MyClass`类，并使用不同的值进行多次应用。

最后，我们可以使用反射来获取并打印可重复注解的值。以下是一个获取和处理可重复注解的示例：

```java
import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {
        Class<MyClass> clazz = MyClass.class;
        CustomAnnotations annotations = clazz.getAnnotation(CustomAnnotations.class);
        if (annotations != null) {
            CustomAnnotation[] customAnnotations = annotations.value();
            for (CustomAnnotation annotation : customAnnotations) {
                System.out.println("Value: " + annotation.value());
            }
        }
    }
}
```

在上述示例中，我们使用`getAnnotation()`方法来获取`CustomAnnotations`注解实例，然后获取其中的`CustomAnnotation`数组，并逐个处理每个注解实例。

通过这个示例，您可以实现可重复注解的功能，并通过反射访问和处理这些注解的值。

## 类型注解

- JDK1.8之后，关于元注解@Target的参数类型ElementType枚举值多了两个：TYPE_PARAMETER,TYPE_USE
在Java 8之前，注解只能是在声明的地方所使用，Java8开始，注解可以应用在任何地方

- ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）

- ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中

当你使用Java编程语言时，你可以使用Java 8引入的类型注解来增强代码的可读性和可维护性。类型注解是指在声明类型时对其进行注解，可以应用于类、接口、方法、字段等。下面是一个使用Java实现类型注解的详细示例：

首先，让我们定义一个简单的注解`@NonNull`，用于标记不允许为null的类型：

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
public @interface NonNull {
}
```

然后，让我们使用这个注解来修饰一个类和其中的字段：

```java
public class Person {
    @NonNull
    private String name;

    @NonNull
    private String address;

    public Person(@NonNull String name, @NonNull String address) {
        this.name = name;
        this.address = address;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getAddress() {
        return address;
    }

    public static void main(String[] args) {
        Person person = new Person(null, "123 Main St"); // 编译器会报错
        System.out.println(person.getName());
    }
}
```

在上面的代码中，我们使用`@NonNull`注解来标记`name`和`address`字段，以及构造函数和访问方法。这样一来，在使用`Person`类时，编译器会检查这些注解的约束条件，如果违反了约束条件，编译器会发出警告或错误。

在`main`方法中，我们尝试创建一个`Person`对象，并将`name`参数设置为`null`。由于`name`字段使用了`@NonNull`注解，编译器会在编译时检测到这个错误，并报告一个空指针异常。

请注意，在上述示例中，我们在注解上添加了`@Target(ElementType.TYPE_USE)`，表示该注解可以应用于类型使用的任何地方，例如字段、方法参数、局部变量等。同时，我们还在注解上添加了`@Retention(RetentionPolicy.RUNTIME)`，表示该注解在运行时仍然可用，以便在运行时通过反射来访问这些注解。

这只是一个简单的示例，你可以根据需要创建自己的注解，并在代码中使用它们来增强类型约束和可读性。希望对你有所帮助！

# Java8的新特性

Java 8 (又称为jdk 1.8) 是 Java 语言开发的一个主要版本
Java 8 是oracle公司于2014年3月发布，可以看成是自Java 5以来最具革命性的版本
Java 8为Java语言、编译器、类库、开发工具与JVM带来了大量新特性

- 速度更快

- 代码更少(增加了新的语法：Lambda 表达式)

- 强大的 Stream API

- 便于并行

- 最大化减少空指针异常：Optional

- Nashorn引擎，允许在JVM上运行JS应用

## Lambda表达式

Lambda 表达式是一种匿名函数的简洁表示方法，它可以被视为一种函数式编程的风格。Lambda 表达式可以作为参数传递给方法或函数，或者作为函数式接口的实现。

Lambda 表达式的语法形式如下：

```shell
(parameters) -> expression or { statements }
```

其中，`parameters` 指定了Lambda表达式的参数列表，`->` 是Lambda操作符，`expression` 或 `{ statements }` 是Lambda体，表示Lambda表达式要执行的操作。

下面是一个简单的示例来解释Lambda表达式：

```java
// 使用Lambda表达式实现了Runnable接口的run方法
Runnable runnable = () -> {
    for (int i = 0; i < 5; i++) {
        System.out.println("Hello, World!");
    }
};

// 调用Runnable对象的run方法
runnable.run();
```

在上述示例中，我们使用Lambda表达式实现了`Runnable`接口的`run`方法。Lambda表达式的参数列表为空，Lambda体中使用了一个循环，打印了5次"Hello, World!"。然后我们创建了一个`Runnable`对象`runnable`，并调用它的`run`方法。这样就能够执行Lambda表达式定义的操作。

Lambda表达式的优势在于它的简洁性和灵活性。通过Lambda表达式，我们可以直接定义行为，而不需要额外定义具名的实现类。Lambda表达式还可以与函数式接口一起使用，简化了函数式接口的实现和使用过程。

以下是另一个示例，展示了如何使用Lambda表达式对集合进行排序：

```java
List<String> names = Arrays.asList("John", "Alice", "Bob", "David");

// 使用Lambda表达式对names列表进行排序
Collections.sort(names, (a, b) -> a.compareTo(b));

// 打印排序后的列表
System.out.println(names);
```

在这个示例中，我们使用Lambda表达式作为参数传递给`Collections.sort`方法，对`names`列表进行排序。Lambda表达式的参数是两个字符串，`a` 和 `b`，Lambda体中使用了`a.compareTo(b)`来比较两个字符串的大小关系。通过Lambda表达式，我们实现了自定义的排序逻辑。

总结来说，Lambda表达式是一种简洁的匿名函数表示方法，它可以用于实现函数式接口或传递行为。它的语法形式简洁清晰，可以提高代码的可读性和简洁性。Lambda表达式在Java 8及更高版本中引入，并且广泛应用于函数式编程和Java集合框架中。

Lambda 是一个匿名函数，我们可以把 Lambda 表达式理解为是一段可以传递的代码（将代码像数据一样进行传递）。使用它可以写出更简洁、更灵活的代码。作为一种更紧凑的代码风格，使Java的语言表达能力得到了提升

### 从匿名类到 Lambda 的转换举例1

在Java中，从匿名类到Lambda的转换主要涉及函数式接口的使用。以下是一个简单的例子，说明如何将匿名类转换为Lambda表达式：

假设我们有一个接口定义如下：

```java
public interface MyInterface {  
    void doSomething(String str);  
}
```

现在，我们使用匿名类实现该接口如下：

```java
MyInterface myInterface = new MyInterface() {  
    @Override  
    public void doSomething(String str) {  
        System.out.println(str);  
    }  
};
```

我们可以将匿名类转换为Lambda表达式，如下所示：

```java
MyInterface myInterface = (str) -> System.out.println(str);
```

在这个例子中，Lambda表达式使用了箭头符号（->）来分隔参数列表和函数体。函数体只包含一行代码，用于打印字符串。

需要注意的是，Lambda表达式只能用于函数式接口。在Java 8之后，可以使用@FunctionalInterface注解来定义函数式接口。

### 从匿名类到 Lambda 的转换举例2

```java
import java.util.TreeSet;  
  
public class TreeSetExample {  
    public static void main(String[] args) {  
        // 创建一个包含一些整数的TreeSet  
        TreeSet<Integer> treeSet = new TreeSet<>();  
  
        // 向TreeSet中添加一些元素  
        treeSet.add(5);  
        treeSet.add(2);  
        treeSet.add(8);  
        treeSet.add(1);  
        treeSet.add(10);  
  
        // 使用Lambda表达式创建TreeSet的Comparator  
        treeSet.comparator = (o1, o2) -> o1.compareTo(o2);  
  
        // 打印TreeSet中的元素  
        System.out.println("TreeSet中的元素：");  
        for (Integer num : treeSet) {  
            System.out.print(num + " ");  
        }  
    }  
}
```

在上面的例子中，我们使用Lambda表达式创建了TreeSet的Comparator，而不是使用默认的比较器。通过指定Lambda表达式，我们可以自定义元素的比较方式。在这个例子中，我们使用`o1.compareTo(o2)`来比较两个整数的大小。最后，我们遍历TreeSet中的元素并将它们打印出来，这次TreeSet将按照我们指定的比较方式进行排序。

语法
Lambda 表达式：在Java 8 语言中引入的一种新的语法元素和操作符。这个操作符为 “->” ， 该操作符被称为 Lambda 操作符或箭头操作符。它将 Lambda 分为两个部分
左侧：指定了 Lambda 表达式需要的参数列表
右侧：指定了 Lambda 体，是抽象方法的实现逻辑，也即Lambda 表达式要执行的功能

![20230721134122](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/20230721134122.png)

Lambda 表达式是 Java 8 中引入的一种简洁的语法，用于创建匿名函数。以下是 Lambda 表达式的六种不同语法：

1.无参数，无返回值

```java
() -> System.out.println("Hello Lambda!");
```

2.有一个参数，无返回值

```java
(x) -> System.out.println(x)
```

3.有一个参数，有返回值

```java
(x) -> { return x; }
```

4.有两个或多个参数，无返回值

```java
(x, y) -> System.out.println(x + y)
```

5.有两个或多个参数，有返回值

```java
(x, y) -> { return x + y; }
```

6.使用花括号定义Lambda体

```java
{  
    // Lambda体  
}
```

以上是 Lambda 表达式的六种不同语法，它们可以根据实际情况进行组合和变形，以适应不同的场景。

## 类型推断

在Java 8中，类型推断（Type Inference）是指编译器能够根据上下文自动推断出表达式的类型，而无需显式地指定类型。这样可以简化代码，减少类型重复，提高代码的可读性和编写效率。

类型推断主要应用于以下几个方面：

7.变量声明和初始化：编译器可以根据变量的赋值推断出变量的类型。

```java
var message = "Hello, World!"; // 根据赋值推断出message的类型为String
```

8.方法调用：编译器可以根据方法的参数类型推断出实际参数的类型。

```java
List<String> names = List.of("Alice", "Bob", "John"); // 根据参数类型推断出List的泛型类型为String
```

9.Lambda 表达式：编译器可以根据上下文推断出 Lambda 表达式的参数类型和返回类型。

```java
Function<Integer, String> converter = (num) -> "Number: " + num; // 根据函数式接口 Function 的声明推断出 num 的类型为 Integer
```

10.泛型类型推断：编译器可以根据上下文推断出泛型类型的实际类型。

```java
Map<String, Integer> map = new HashMap<>(); // 根据左侧声明的类型推断出 HashMap 的泛型类型为 String 和 Integer
```

在上述示例中，我们使用了 `var` 关键字进行类型推断，或者直接省略了类型声明部分，让编译器根据上下文推断出类型。这样可以使代码更加简洁，减少了类型的重复。

需要注意的是，类型推断并不是完全自动的，它有一些限制和规则。例如，编译器需要能够通过上下文准确地推断出类型，且不能产生二义性。此外，类型推断只能在编译时发生，运行时并不会有类型推断的过程。

总结来说，Java 8中的类型推断是指编译器根据上下文自动推断表达式的类型，使代码更加简洁和可读。它应用于变量声明、方法调用、Lambda 表达式和泛型类型推断等场景，可以减少类型重复，提高代码编写效率。

上述 Lambda 表达式中的参数类型都是由编译器推断得出的。Lambda表达式中无需指定类型，程序依然可以编译，这是因为 javac 根据程序的上下文，在后台推断出了参数的类型。Lambda 表达式的类型依赖于上下文环境，是由编译器推断出来的。这就是所谓的“类型推断”

![20230721134929](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/20230721134929.png)

在 Java 8 中，引入了类型推断的功能，使得在某些情况下可以省略变量的类型声明。以下是一个使用类型推断的示例代码：

```java
import java.util.ArrayList;
import java.util.List;

public class TypeInferenceDemo {
    public static void main(String[] args) {
        // 声明一个 ArrayList 类型的变量，使用类型推断
        List<String> names = new ArrayList<>();

        // 添加元素到列表
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // 遍历列表并打印每个元素
        names.forEach(name -> System.out.println(name));

        // 声明一个整数类型的变量，使用类型推断
        var count = 10;

        // 打印变量的值
        System.out.println(count);

        // 声明一个字符串类型的变量，使用类型推断
        var message = "Hello, World!";

        // 打印变量的值
        System.out.println(message);
    }
}
```

在上述示例中，我们使用类型推断来声明了一个 ArrayList 类型的变量 `names`，以及整数类型的变量 `count` 和字符串类型的变量 `message`。在这些情况下，编译器能够根据变量的初始化值推断出变量的类型，从而省略了显式的类型声明。

请注意，类型推断并不意味着变量没有类型，而是由编译器根据上下文推断出变量的类型。在运行时，这些变量仍然具有明确的类型。使用类型推断可以简化代码并提高可读性，特别是在变量的类型是显而易见的情况下。然而，过度使用类型推断可能会降低代码的可读性，因此需要谨慎使用。

## Functional接口

Functional
什么是函数式(Functional)接口

- 只包含一个抽象方法的接口，称为函数式接口。

- 你可以通过 Lambda 表达式来创建该接口的对象。（若 Lambda 表达式抛出一个受检异常(即：非运行时异常)，那么该异常需要在目标接口的抽象方法上进行声明）。

- 我们可以在一个接口上使用 @FunctionalInterface 注解，这样做可以检查它是否是一个函数式接口。同时 javadoc 也会包含一条声明，说明这个接口是一个函数式接口。

- 在java.util.function包下定义了Java 8 的丰富的函数式接口
如何理解函数式接口

- Java从诞生日起就是一直倡导“一切皆对象”，在Java里面面向对象(OOP)编程是一切。但是随着python、scala等语言的兴起和新技术的挑战，Java不得不做出调整以便支持更加广泛的技术要求，也即java不但可以支持OOP还可以支持OOF（面向函数编程）

- 在函数式编程语言当中，函数被当做一等公民对待。在将函数作为一等公民的编程语言中，Lambda表达式的类型是函数。但是在Java8中，有所不同。在Java8中，Lambda表达式是对象，而不是函数，它们必须依附于一类特别的对象类型——函数式接口

- 简单的说，在Java8中，Lambda表达式就是一个函数式接口的实例。这就是Lambda表达式和函数式接口的关系。也就是说，只要一个对象是函数式接口的实例，那么该对象就可以用Lambda表达式来表示

- 所以以前用匿名实现类表示的现在都可以用Lambda表达式来写

在Java中，函数式编程是一种编程范式，它强调以函数为主要构建块来进行编程。函数式编程的核心思想是将计算视为函数求值，并避免状态和可变数据。在Java中，函数式编程得到了广泛支持，并引入了函数式接口来支持函数式编程。

函数式接口是指只定义了一个抽象方法的接口。Java中的函数式接口通过 `@FunctionalInterface` 注解进行标识，用于表示该接口是函数式接口，即可以用作Lambda表达式的目标类型。Java 8及以后的版本提供了一些内置的函数式接口，可以直接在函数式编程中使用。

以下是Java中的一些常见函数式接口以及它们的说明和示例：

11.`Predicate<T>`：接收一个参数，并返回一个布尔值结果。

```java
Predicate<String> isLongerThan5 = str -> str.length() > 5;
System.out.println(isLongerThan5.test("Hello"));  // false
System.out.println(isLongerThan5.test("Hello, World!"));  // true
```

12.`Consumer<T>`：接收一个参数并执行某些操作，没有返回值。

```java
Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
printUpperCase.accept("hello");  // HELLO
```

13.`Function<T, R>`：接收一个参数并返回一个结果。

```java
Function<Integer, String> convertToString = num -> String.valueOf(num);
System.out.println(convertToString.apply(42));  // "42"
```

14.`Supplier<T>`：无参数，返回一个结果。

```java
Supplier<Double> randomDouble = () -> Math.random();
System.out.println(randomDouble.get());  // 0.8133428026340117
```

15.`UnaryOperator<T>`：接收一个参数并返回与参数类型相同的结果。

```java
UnaryOperator<Integer> square = num -> num * num;
System.out.println(square.apply(5));  // 25
```

16.`BinaryOperator<T>`：接收两个参数并返回与参数类型相同的结果。

```java
BinaryOperator<Integer> sum = (a, b) -> a + b;
System.out.println(sum.apply(3, 4));  // 7
```

以上只是Java中的一些常见函数式接口示例，实际上还有更多的函数式接口可供使用。使用这些函数式接口可以更方便地进行函数式编程，编写简洁、可读性高的代码。

### 作为参数传递 Lambda 表达式

在Java中，Lambda表达式可以作为参数传递给方法或函数，这是函数式编程的一个重要特性。通过将Lambda表达式作为参数，我们可以将行为传递给方法，使方法更加灵活和可复用。

以下是一个示例，演示了如何将Lambda表达式作为参数传递给方法：

```java
interface MathOperation {
    int operation(int a, int b);
}

public class Calculator {
    public static int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    public static void main(String[] args) {
        int result;

        // 使用Lambda表达式作为参数传递给operate方法
        result = operate(5, 3, (a, b) -> a + b);
        System.out.println("5 + 3 = " + result);

        result = operate(5, 3, (a, b) -> a - b);
        System.out.println("5 - 3 = " + result);

        result = operate(5, 3, (a, b) -> a * b);
        System.out.println("5 * 3 = " + result);
    }
}
```

在上述示例中，我们定义了一个函数式接口 `MathOperation`，其中包含一个抽象方法 `operation`，用于执行数学操作。然后，在 `Calculator` 类中，我们定义了一个静态方法 `operate`，该方法接收两个整数和一个 `MathOperation` 接口类型的参数，执行传递的数学操作并返回结果。

在 `main` 方法中，我们使用Lambda表达式作为参数来调用 `operate` 方法，并传递不同的数学操作来进行计算。通过Lambda表达式，我们可以根据需要定义不同的行为，并将其传递给方法。

运行上述示例，将会输出以下结果：

```shell
5 + 3 = 8
5 - 3 = 2
5 * 3 = 15
```

可以看到，通过将Lambda表达式作为参数传递给方法，我们可以在调用方法时动态地传递行为，并根据需要改变方法的功能，使代码更加灵活和可复用。

需要注意的是，传递Lambda表达式的方法必须具有与Lambda表达式兼容的函数式接口类型的参数。这样，编译器才能根据Lambda表达式的签名进行类型推断，并确保Lambda表达式与方法的参数类型匹配。

### Java 内置四大核心函数式接口

Java内置的四大核心函数式接口是：

17.`Predicate<T>`：用于判断给定输入是否满足某个条件，返回一个布尔值。

```java
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = num -> num > 0;
        System.out.println(isPositive.test(5));  // true
        System.out.println(isPositive.test(-2)); // false
    }
}
```

18.`Function<T, R>`：接收一个参数并返回一个结果。

```java
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<String, Integer> strLength = str -> str.length();
        System.out.println(strLength.apply("Hello"));  // 5
    }
}
```

19.`Consumer<T>`：接收一个参数并执行某些操作，没有返回值。

```java
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
        printUpperCase.accept("hello");  // HELLO
    }
}
```

20.`Supplier<T>`：无参数，返回一个结果。

```java
import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<Double> randomDouble = () -> Math.random();
        System.out.println(randomDouble.get());  // 0.8133428026340117
    }
}
```

以上示例分别展示了 `Predicate`、`Function`、`Consumer` 和 `Supplier` 四个核心函数式接口的用法。通过使用这些函数式接口，可以更简洁地编写具有不同行为的代码，并实现函数式编程的思想。

![20230721135046](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/20230721135046.png)

其他接口

![20230721135155](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/20230721135155.png)

## 方法引用

- 当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！

- 方法引用可以看做是Lambda表达式深层次的表达。换句话说，方法引用就是Lambda表达式，也就是函数式接口的一个实例，通过方法的名字来指向一个方法，可以认为是Lambda表达式的一个语法糖

- 要求：实现接口的抽象方法的参数列表和返回值类型，必须与方法引用的方法的参数列表和返回值类型保持一致！

- 格式：使用操作符 “::” 将类(或对象) 与 方法名分隔开来

如下三种主要使用情况

对象::实例方法名
类::静态方法名
类::实例方法名

以下是一个使用方法引用的示例代码：

```java
import java.util.Arrays;  
import java.util.List;  
  
public class MethodReferenceDemo {  
    public static void main(String[] args) {  
        // 创建一个包含字符串的列表  
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");  
  
        // 使用方法引用调用forEach方法  
        names.forEach(name -> System.out.println(name));  
  
        // 使用方法引用调用静态方法  
        Math::pow;  
  
        // 使用方法引用调用实例方法  
        String::toUpperCase;  
    }  
}
```

在上面的示例代码中，我们创建了一个包含字符串的列表`names`，然后使用方法引用调用`forEach`方法，打印列表中的每个字符串。接下来，我们使用方法引用调用`Math`类的静态方法`pow`，以及`String`类的实例方法`toUpperCase`。

需要注意的是，方法引用是Lambda表达式的一种形式，它可以使代码更加简洁和易读。在使用方法引用时，需要注意引用的方法是静态方法还是实例方法，以及引用的对象是否需要传入参数。

## 构造器引用

以下是一个使用Lambda表达式方式实现构造器引用的示例：

```java
import java.util.ArrayList;  
  
public class LambdaConstructorReferenceDemo {  
    public static void main(String[] args) {  
        // 使用Lambda表达式创建ArrayList对象  
        ArrayList<String> list = new ArrayList<>((str) -> {  
            list.add(str);  
        });  
  
        // 使用方法引用调用add方法  
        list.add("Alice");  
        list.add("Bob");  
        list.add("Charlie");  
  
        // 使用方法引用调用get方法  
        System.out.println(list.get(0));  
    }  
}
```

在上面的示例代码中，我们使用Lambda表达式创建了一个`ArrayList`对象，并在构造函数中使用了Lambda表达式。Lambda表达式中的代码块调用了`add`方法，将传入的字符串添加到列表中。接下来，我们使用方法引用调用`add`方法和`get`方法，向列表中添加元素并获取第一个元素。输出结果与之前的示例相同。

## 数组引用

以下是一个使用Lambda表达式方式实现数组引用的示例：

```java
import java.util.Arrays;  
  
public class LambdaArrayReferenceDemo {  
    public static void main(String[] args) {  
        // 创建一个包含字符串的数组  
        String[] names = {"Alice", "Bob", "Charlie"};  
  
        // 使用Lambda表达式创建数组引用  
        Arrays.sort(names, (s1, s2) -> s1.compareTo(s2));  
  
        // 打印排序后的数组  
        System.out.println(Arrays.toString(names));  
    }  
}
```

在上面的示例代码中，我们创建了一个包含字符串的数组`names`，然后使用Lambda表达式创建了一个数组引用，用于排序。Lambda表达式中的代码块使用了`compareTo`方法比较两个字符串的大小关系。接下来，我们使用`Arrays.sort`方法对数组进行排序，并打印排序后的数组。输出结果为`[Alice, Bob, Charlie]`。

需要注意的是，Lambda表达式可以用于创建各种类型的引用，包括函数引用、对象引用和数组引用等。在使用Lambda表达式创建引用时，需要指定引用的参数类型和返回类型，并编写相应的代码块。

## Optional类

- 到目前为止，臭名昭著的空指针异常是导致Java应用程序失败的最常见原因。以前，为了解决空指针异常，Google公司著名的Guava项目引入了Optional类，Guava通过使用检查空值的方式来防止代码污染，它鼓励程序员写更干净的代码。受到Google Guava的启发，Optional类已经成为Java 8类库的一部分。

- Optional\<T> 类(java.util.Optional) 是一个容器类，它可以保存类型T的值，代表这个值存在。或者仅仅保存null，表示这个值不存在。原来用 null 表示一个值不存在，现在 Optional 可以更好的表达这个概念。并且可以避免空指针异常。

- Optional类的Javadoc描述如下：这是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象

- Optional提供很多有用的方法，这样我们就不用显式进行空值检测。

```java
Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
Optional.empty() : 创建一个空的 Optional 实例
Optional.ofNullable(T t)：t可以为null
```

```java
boolean isPresent() : 判断是否包含对象
void ifPresent(Consumer<? super T> consumer) ：如果有值，就执行Consumer接口的实现代码，并且该值会作为参数传给它
```

```txt
T get(): 如果调用对象包含值，返回该值，否则抛异常
T orElse(T other) ：如果有值则将其返回，否则返回指定的other对象。
T orElseGet(Supplier<? extends T> other) ：如果有值则将其返回，否则返回由Supplier接口实现提供的对象。
T orElseThrow(Supplier<? extends X> exceptionSupplier) ：如果有值则将其返回，否则抛出由Supplier接口实现提供的异常
```

## 并行流与串行流

并行流就是把一个内容分成多个数据块，并用不同的线程分别处理每个数据块的流。相比较串行的流，并行的流可以很大程度上提高程序的执行效率。Java 8 中将并行进行了优化，我们可以很容易的对数据进行并行操作

Stream API 可以声明性地通过 parallel() 与 sequential() 在并行流与顺序流之间进行切换。

## Stream 的操作三个步骤

1- 创建 Stream
一个数据源(如: 集合、数组)，获取一个流
2- 中间操作
一个中间操作链，对数据源的数据进行处理
3- 终止操作(终端操作)
一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用

### 创建 Stream方式一：通过集合

Java8 中的 Collection 接口被扩展，提供了两个获取流的方法

```java
default Stream<E> stream() : 返回一个顺序流
default Stream<E> parallelStream() : 返回一个并行流
```

### 创建 Stream方式二：通过数组

Java8 中的 Arrays 的静态方法 stream() 可以获取数组流

```txt
static <T> Stream<T> stream(T[] array): 返回一个流
重载形式，能够处理对应基本类型的数组：
public static IntStream stream(int[] array)
public static LongStream stream(long[] array)
public static DoubleStream stream(double[] array)
```

### 创建 Stream方式三：通过Stream的of()

可以调用Stream类静态方法 of(), 通过显示值创建一个流。它可以接收任意数量的参数

```java
public static<T> Stream<T> of(T... values) : 返回一个流
```

### 创建 Stream方式四：通过Stream的empty()

```java
Stream<String> emptyStream = Stream.empty();
```

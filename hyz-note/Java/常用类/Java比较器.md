# Java比较强

在Java中经常会涉及到对象数组的排序问题，那么就涉及到对象之间的比较问题Java实现对象排序的方式有两种

- 自然排序：java.lang.Comparable

- 定制排序：java.util.Comparator

## java.lang.Comparable

- Comparable接口强行对实现它的每个类的对象进行整体排序。这种排序被称为类的自然排序

- 实现 Comparable 的类必须实现 compareTo(Object obj) 方法，两个对象即通过 compareTo(Object obj) 方法的返回值来比较大小。如果当前对象this大于形参对象obj，则返回正整数，如果当前对象this小于形参对象obj，则返回负整数，如果当前对象this等于形参对象obj，则返回零

- 实现Comparable接口的对象列表（和数组）可以通过 Collections.sort 或Arrays.sort进行自动排序。实现此接口的对象可以用作有序映射中的键或有序集合中的元素，无需指定比较器

- 对于类 C 的每一个 e1 和 e2 来说，当且仅当 e1.compareTo(e2) == 0 与e1.equals(e2) 具有相同的 boolean 值时，类 C 的自然排序才叫做与 equals一致。建议（虽然不是必需的）最好使自然排序与 equals 一致

Comparable 的典型实现：(默认都是从小到大排列的)

- String：按照字符串中字符的Unicode值进行比较

- Character：按照字符的Unicode值来进行比较

- 数值类型对应的包装类以及BigInteger、BigDecimal：按照它们对应的数值大小进行比较

- Boolean：true 对应的包装类实例大于 false 对应的包装类实例

- Date、Time等：后面的日期时间比前面的日期时间大

## java.util.Comparator

- 当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，那么可以考虑使用 Comparator 的对象来排序，强行对多个对象进行整体排序的比较。

- 重写compare(Object o1,Object o2)方法，比较o1和o2的大小：如果方法返回正整数，则表示o1大于o2；如果返回0，表示相等；返回负整数，表示o1小于o2。

- 可以将 Comparator 传递给 sort 方法（如 Collections.sort 或 Arrays.sort），从而允许在排序顺序上实现精确控制。

- 还可以使用 Comparator 来控制某些数据结构（如有序 set或有序映射）的顺序，或者为那些没有自然顺序的对象 collection 提供排序

`Comparable`和`Comparator`是Java中用于对象比较的两个接口。下面是它们的详细示例：

1. Comparable接口示例：

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Student other) {
        // 按照年龄进行比较
        return Integer.compare(this.age, other.age);
    }
}

public class ComparableDemo {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Alice", 20));
        studentList.add(new Student("Bob", 18));
        studentList.add(new Student("Charlie", 22));

        Collections.sort(studentList); // 使用Comparable进行排序

        for (Student student : studentList) {
            System.out.println(student.getName() + " - " + student.getAge());
        }
    }
}
```

输出结果：

```shell
Bob - 18
Alice - 20
Charlie - 22
```

2.Comparator接口示例：

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alice", 20));
        employeeList.add(new Employee("Bob", 18));
        employeeList.add(new Employee("Charlie", 22));

        // 使用Comparator按照年龄进行比较
        Comparator<Employee> ageComparator = Comparator.comparingInt(Employee::getAge);
        Collections.sort(employeeList, ageComparator);

        for (Employee employee : employeeList) {
            System.out.println(employee.getName() + " - " + employee.getAge());
        }
    }
}
```

输出结果：

```shell
Bob - 18
Alice - 20
Charlie - 22
```

以上示例展示了使用`Comparable`和`Comparator`接口进行对象比较的基本用法。通过实现`Comparable`接口，对象可以定义默认的比较规则。而使用`Comparator`接口，可以在不修改对象类的情况下定义多个不同的比较规则。这些接口提供了灵活的方式来实现对象的比较和排序操作。

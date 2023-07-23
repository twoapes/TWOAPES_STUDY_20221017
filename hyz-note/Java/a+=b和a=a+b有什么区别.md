# a+=b和a=a+b有什么区别

a += b 和 a = a + b 是两种不同的赋值表达式,它们在功能上是等价的,但在语义和执行效率上有一些微小的区别

1. 语义上的区别
   1) a += b 是复合赋值运算符,表示将 a 和 b 相加的结果赋值给 a,相当于 a = a + b
   2) a = a + b 是赋值语句,先计算 a + b 的结果,然后将结果赋值给 a

2. 执行效率上的区别
   1) a += b 执行效率可能会稍微高于 a = a + b
   2) 这是因为 a += b 是原地修改 a 的值,不需要创建一个新的临时变量来存储 a + b 的结果
   3) a = a + b 执行效率稍低一些,因为它需要分配额外的内存来存储 a + b 的结果,并且需要执行赋值操作
   4) 总的来说,这两种表达式的功能是相同的,但由于 a += b 不需要额外的内存分配和赋值操作,它通常被认为更加简洁和高效
   5) 在实际使用中,选择使用哪种表达式可以根据个人偏好和代码风格进行决定

```java
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
/**
 * @author add by huyingzhao
 * 2023-02-25 11:49
 */
@Slf4j
public class InterviewTest {
    /**
     * a+=b和a=a+b有什么区别
     *
     * @author add by huyingzhao
     * 2023-02-25 11:51
     */
    @Test
    public void aAb() {
        int a = 10;
        int b = 5;
        a += b; // 等同于 a = a + b;
        log.info("a += b 的值为:{}", a);
        a = 10;
        b = 5;
        a = a + b;
        log.info("a = a + b 的值为:{}", a);
        long c = 1000L;
        float d = 3.14f;
        // 使用 a += b 进行类型转换
        a += c; // 等同于 a = (int)(a + c);
        log.info("a += c 的值为:{}", a);
        // 使用 a = a + b 进行类型转换
        a = (int) (a + d);
        log.info("a = a + d 的值为:{}", a);
    }
}
```

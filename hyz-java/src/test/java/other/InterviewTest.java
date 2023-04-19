package other;

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
        log.info("a += b 的值为：{}", a);

        a = 10;
        b = 5;

        a = a + b;
        log.info("a = a + b 的值为：{}", a);

        long c = 1000L;
        float d = 3.14f;

        // 使用 a += b 进行类型转换
        a += c; // 等同于 a = (int)(a + c);
        log.info("a += c 的值为：{}", a);

        // 使用 a = a + b 进行类型转换
        a = (int) (a + d);
        log.info("a = a + d 的值为：{}", a);
    }
}

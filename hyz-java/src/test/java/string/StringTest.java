package string;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Locale;

/**
 * @author add by huyingzhao
 * 2023-03-10 12:43
 */
@Slf4j
public class StringTest {
    /**
     * @author add by huyingzhao
     * 2023-03-10 12:43
     * String实例化方式
     */
    @Test
    public void string() {
        // 直接赋值方式
        String str1 = "Hello World";
        log.info("str1: {}", str1);

        // 使用String构造函数
        String str2 = new String("Hello World");
        log.info("str2: {}", str2);

        // 使用字符数组
        char[] charArray = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'};
        String str3 = new String(charArray);
        log.info("str3: {}", str3);

        // 使用字节数组
        byte[] byteArray = {72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100};
        String str4 = new String(byteArray);
        log.info("str4: {}", str4);
    }

    /**
     * @author add by huyingzhao
     * 2023-03-10 12:43
     * String常用的方法
     */
    @Test
    public void stringMethod() {
        String str = " abcdefg ";

        // 长度
        log.info("length方法:{}", str.length());

        // 截取
        log.info("charAt方法:{}", str.charAt(0));

        // 是否为空
        log.info("isEmpty方法:{}", str.isEmpty());

        // 小写
        log.info("toLowerCase方法:{}", str.toLowerCase(Locale.ROOT));

        // 大写
        log.info("toUpperCase方法:{}", str.toUpperCase(Locale.ROOT));

        // 去除前后空格
        log.info("trim方法:{}", str.trim());

        // 比较内容(不忽略大小写)
        log.info("equals方法:{}", str.trim().equals("Abcdefg"));

        // 比较内容(忽略大小写)
        log.info("equalsIgnoreCase方法:{}", str.trim().equalsIgnoreCase("Abcdefg"));

        // 连接字符串
        log.info("concat方法:{}", str.trim().concat("hijk"));

        // 字符串排序,0:true,否则false
        log.info("compareTo方法:{}", str.compareTo(" abcdefg "));

        // 截取,int beginIndex, int endIndex [)
        log.info("substring方法:{}", str.substring(1, 2));

        // 判断是否是指定字符串开始
        log.info("startsWith方法:{}", str.startsWith(" "));

        // 从toffset开始判断是否是指定字符串开始
        log.info("startsWith方法:{}", str.startsWith("a", 1));

        // 判断是否是指定字符串结束
        log.info("endsWith方法:{}", str.endsWith(" "));

        // 判断是否包含指定字符串
        log.info("contains方法:{}", str.contains("d"));

        // 指定字符串首次出现的位置 从前往后
        log.info("indexOf方法:{}", str.indexOf("d"));

        // fromIndex开始查找,指定字符串首次出现的位置 从前往后
        log.info("indexOf方法:{}", str.indexOf("d", 5));

        // 指定字符串最后出现的位置 从后往前
        log.info("lastIndexOf方法:{}", str.lastIndexOf("d"));

        // fromIndex开始查找,指定字符串最后出现的位置 从后往前
        log.info("lastIndexOf方法:{}", str.lastIndexOf("d", 3));

        // 替换方法
        log.info("replace方法:{}", str.replace("fg", "fgh"));

        // 正则表达式替换
        String str2 = "a1b2c";
        log.info("replaceAll方法:{}", str2.replaceAll("\\d+", ","));

        // 匹配正则表达式
        String str3 = "123";
        log.info("matches方法:{}", str2.matches("\\d+"));
        log.info("matches方法:{}", str3.matches("\\d+"));
    }

    /**
     * StringBuffer和StringBuilder类
     *
     * @author add by huyingzhao
     * 2023-03-11 15:40
     */
    @Test
    public void builderAndBuffer() {
        long startTime;
        long endTime;
        String text = "";
        StringBuffer buffer = new StringBuffer();
        StringBuilder builder = new StringBuilder();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(i);
        }
        log.info(buffer.toString());
        endTime = System.currentTimeMillis();
        log.info("StringBuffer的执行时间:{}", (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(i);
        }
        log.info(builder.toString());
        endTime = System.currentTimeMillis();
        log.info("StringBuilder的执行时间:{}", (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text += i;
        }
        log.info(text);
        endTime = System.currentTimeMillis();
        log.info("String的执行时间:{}", (endTime - startTime));
    }
}

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author add by huyingzhao
 * 2022-10-08 16:28
 * case test
 */
@Slf4j
public class CaseTest {
    /**
     * test encrypt easy
     *
     * @author method add by huyingzhao
     * 2022-10-08 18:26
     */
    @Test
    public void encryptEasyTest() {
        String str = "encryption/decryption";
        log.info("old:{}", str);
        char[] strings = str.toCharArray();
        List<Character> stringsList=new ArrayList<>();
        for (char s : strings) {
            s = (char) (s ^ 20000);
            stringsList.add(s);
        }

        log.info("stringsList:{}", stringsList);
        log.info("strings:{}", Arrays.toString(strings));
    }

    /**
     * test not multiplication
     *
     * @author method add by huyingzhao
     * 2022-10-08 18:27
     */
    @Test
    public void notMultiplicationTest() {
        log.info("2*2={}", (2 << 1));
        log.info("2*4={}", (2 << 2));
        log.info("2*8={}", (2 << 3));
        log.info("2*16={}", (2 << 4));
    }

    /**
     * test variable swap
     *
     * @author method add by huyingzhao
     * 2022-10-08 18:27
     */
    @Test
    public void variableSwap() {
        int a = 2;
        int b = 3;
        log.info("before replacement\ta:{}\tb:{}", a, b);
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        log.info("after replacement\ta:{}\tb:{}", a, b);
    }

    /**
     * test leap year
     *
     * @author method add by huyingzhao
     * 2022-10-08 18:27
     */
    @Test
    public void leapYearTest() {
        int year = (int) (Math.random() * 5 + 2012);
        log.info(year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? "leap year" : "non leap year");
    }

    /**
     * test pascal triangle
     *
     * @author method add by huyingzhao
     * 2022-10-08 18:35
     */
    @Test
    public void pascalTriangleTest() {
        int index = 15;
        int[][] arr = new int[index][index];
        StringBuilder stringBuilder = new StringBuilder("\n");
        for (int i = 0; i < index; i++) {
            stringBuilder.append("\t".repeat(index - i + 1));
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                    stringBuilder.append("\t\t");
                    stringBuilder.append(arr[i][j]);
                } else {
                    stringBuilder.append("\t\t");
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                    stringBuilder.append(arr[i][j]);
                }
            }
            stringBuilder.append("\n");
        }

        log.info("stringBuilder:{}", stringBuilder);
    }

    /**
     * test factorial
     *
     * @author method add by huyingzhao
     * 2022-10-09 9:38
     */
    @Test
    public void factorialTest() {
        int index = 10;
        int sum = 0;
        StringBuilder string1 = new StringBuilder("\n");
        StringBuilder string2 = new StringBuilder("\n");
        for (int i = index; i > 0; i--) {
            int mul = 1;
            for (int j = 1; j <= i; j++) {
                mul *= j;
                if (j == 1) {
                    string2.append(j);
                } else {
                    string2.append("*").append(j);
                }
            }

            string1.append(i).append("!+");
            string2.append("+");
            sum += mul;
        }

        log.info("string:{}={}", string1, sum);
        log.info("string2:{}={}", string2, sum);
    }
}

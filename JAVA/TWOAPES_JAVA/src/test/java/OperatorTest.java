import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;

/**
 * @author add by huyingzhao
 * 2022-09-13 10:48
 * operator test
 */
@Slf4j
public class OperatorTest {
    /**
     * test type operator
     *
     * @author add by huyingzhao
     * 2022-09-13 10:48
     */
    @Test
    public void TypeOperatorTest() {
        Object a = Long.MAX_VALUE;
        //out for false
        if (a instanceof Integer) {
            a = (Integer) a * 100;
            log.info("a :{}", a);
        } else {
            log.info("Integer :{}", false);
        }


        //out for true
        if (a instanceof Long) {
            a = (Long) a * 100;
            log.info("a :{}", a);
        } else {
            log.info("Long :{}", false);
        }

        //a = (Integer) a * 100;
    }

    /**
     * test bit operator
     * @author add by huyingzhao
     * 2022-09-13 10:52
     */
    @Test
    public void bitOperatorTest(){
        StringBuilder stringBuilder = new StringBuilder("\n");
        int a = 3;
        int b = 4;
        String x = "3";
        String y = "4";

        stringBuilder.append("x:").append(x).append("\n");
        stringBuilder.append("y:").append(y).append("\n");
        //bite operator only used for number
        stringBuilder.append("a & b:").append(a & b).append("\n");
        stringBuilder.append("a | b:").append(a | b).append("\n");
        stringBuilder.append("~b:").append(~b).append("\n");
        stringBuilder.append("~a:").append(~a).append("\n");
        stringBuilder.append("a ^ b:").append(a ^ b).append("\n");
        //Either a string or an object causes an error
        ///stringBuilder.append(x^y);
        // stringBuilder.append(x|y);
        /*import:import java.util.Random;*/
        Random random = new Random(47);
        int i = random.nextInt(100);
        int j = random.nextInt(100);
        stringBuilder.append("i:").append(i).append("\n");
        stringBuilder.append("j:").append(j).append("\n");
        stringBuilder.append("i>j is ").append((i > j)).append("\n");
        stringBuilder.append("i<j is ").append((i < j)).append("\n");
        stringBuilder.append("i>=j is ").append((i >= j)).append("\n");
        stringBuilder.append("i<=j is ").append(i <= j).append("\n");
        stringBuilder.append("i==j is ").append((i == j)).append("\n");
        stringBuilder.append("i!=j is ").append(i != j).append("\n");
        //following is wrong
        //stringBuilder.append("i$$j is " + (i && j));
        //stringBuilder.append("i||j is " + (i || j));
        //stringBuilder.append("!i is " + (!i);
        stringBuilder.append("(i<10)&&(j<10) is ").append((i < 10) && (j < 10)).append("\n");
        stringBuilder.append("(i<10)||(j<10) is ").append((i < 10) || (j < 10)).append("\n");
        //top:operator number using bit operator,operator relation using logical operator
        log.info("stringBuilder :{}",stringBuilder);
    }
}

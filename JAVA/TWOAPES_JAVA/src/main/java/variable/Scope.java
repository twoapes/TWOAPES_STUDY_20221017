package variable;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author add by huyingzhao
 * 2022-08-04 14:04
 * scope
 */
@Slf4j
public class Scope {
    public static void scope() {
        int sumI = 0;
        for (int i = 0; i < 10; i++) {
            sumI += i;
        }

        log.info("sumI:" + sumI);

        // log.info("i:"+i);//Can't be used outside the block
        String[] args = new String[20];
        int sumJ = 0;
        for (int j = 0; j < 20; j++) {
//            sumJ += i + j;//i is outside
            sumJ += j;
            args[j] = String.valueOf(sumJ);
        }

        log.info(Arrays.toString(args));
    }
}

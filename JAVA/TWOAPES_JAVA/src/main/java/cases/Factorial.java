package cases;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-10-09 9:34
 * factorial accumulation
 */
@Slf4j
public class Factorial {
    public static void factorial() {
        int index = 10;
        int sum = 0;
        StringBuilder string = new StringBuilder("\n");
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

            string.append(i).append("!+");
            string2.append("+");
            sum += mul;
        }

        log.info(string + "=" + sum);
        log.info(string2 + "=" + sum);
    }
}

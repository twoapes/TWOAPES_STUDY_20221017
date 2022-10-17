package cases;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-10-09 9:29
 * multiplication table
 */
@Slf4j
public class MultiplicationTable {
    public static void multiplicationTable() {
        StringBuilder string = new StringBuilder("\n");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                string.append(i).append("*").append(j).append("=").append(i * j).append("\t");
            }
            string.append("\n");
        }

        log.info(string.toString());
    }
}

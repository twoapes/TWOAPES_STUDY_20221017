package variable;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-08-04 14:06
 * block scope
 */
@Slf4j
public class BlockScope {
    private static final int k = 10;

    public static void blockScope() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        int k = 100;
        {
            int j = 0;
            stringBuilder.append(j).append("\n");
        }

        stringBuilder.append(k).append("\n");
        stringBuilder.append(BlockScope.k).append("\n");
        // stringBuilder.append(j);
        log.info(stringBuilder.toString());
    }
}

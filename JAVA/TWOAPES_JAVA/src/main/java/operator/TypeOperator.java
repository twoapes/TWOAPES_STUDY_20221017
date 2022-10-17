package operator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-07-10 18:26
 * type operator
 */
@Slf4j
public class TypeOperator {
    public static void typeOperator() {
        Object a = Long.MAX_VALUE;
        //out for false
        if (a instanceof Integer) {
            a = (Integer) a * 100;
            log.info(String.valueOf(a));
        } else {
            log.info(String.valueOf(false));
        }


        //out for true
        if (a instanceof Long) {
            a = (Long) a * 100;
            log.info(String.valueOf(a));
        } else {
            log.info(String.valueOf(false));
        }

        //a = (Integer) a * 100;
    }
}

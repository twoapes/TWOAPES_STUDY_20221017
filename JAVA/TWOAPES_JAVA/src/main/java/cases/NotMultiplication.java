package cases;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-10-08 17:52
 * Do not use multiplication 2*16
 */
@Slf4j
public class NotMultiplication {
    public static void notMultiplication(){
        log.info("2*2:"+(2<<1));
        log.info("2*4:"+(2<<2));
        log.info("2*8:"+(2<<3));
        log.info("2*16:"+(2<<4));
    }
}

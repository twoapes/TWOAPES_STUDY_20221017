package cases;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-10-08 16:37
 * general and error message output
 */
@Slf4j
public class InformationOutput {
    public static void informationOutput() {
        log.info("info message output");
        log.debug("debug message output");
        log.error("error message output");
        log.warn("warn message output");
    }
}

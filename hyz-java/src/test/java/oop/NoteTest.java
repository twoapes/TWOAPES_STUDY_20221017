package oop;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author add by huyingzhao
 * 2023-03-12 22:09
 */
@Slf4j
public class NoteTest {
    /**
     * 文档注释
     *
     * @author add by huyingzhao
     * 2023-03-12 22:10
     */
    @Test
    public void note() {
        /*
        多行注释
        */
        log.info("多行注释");
        //单行注释
        log.info("单行注释");
    }
}

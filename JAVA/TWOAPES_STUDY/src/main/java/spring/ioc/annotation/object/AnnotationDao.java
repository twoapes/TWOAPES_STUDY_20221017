package spring.ioc.annotation.object;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-10-01 14:02
 */
@Slf4j
public class AnnotationDao {
    public void annotation(String str) {
        log.info("using " + str + " annotation call annotationDao.annotation");
    }
}
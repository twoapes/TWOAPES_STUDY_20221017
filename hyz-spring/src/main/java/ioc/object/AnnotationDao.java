package ioc.object;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2023-02-24 14:48
 */
@Slf4j
public class AnnotationDao {
    public void annotation(String str) {
        log.info("using " + str + " annotation call ioc.object.AnnotationDao.annotation");
    }
}

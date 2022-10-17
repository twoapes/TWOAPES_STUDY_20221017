package ioc.annotation.object;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author add by huyingzhao
 * 2022-10-01 13:39
 */
@Service
@Slf4j
public class AnnotationService {
    @Autowired
    @Qualifier("annotationDao")
    private AnnotationDao annotationDao;
    @Resource
    private AnnotationDao annotationDao2;

    public void autowired() {
        annotationDao.annotation("autowired");
    }

    public void qualifier() {
        annotationDao.annotation("qualifier");
    }

    public void resource() {
        annotationDao2.annotation("resource");
    }

    public void annotation() {
        log.info("call ioc.annotation.object.AnnotationService.annotation");
    }
}
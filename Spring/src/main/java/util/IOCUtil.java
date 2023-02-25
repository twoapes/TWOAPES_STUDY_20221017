package util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

@Slf4j
public class IOCUtil {
    /**
     * @param fileName fileName
     * @return xml
     * @author add by huyingzhao
     * 2022-10-01 23:47
     */
    private static ApplicationContext ioc(String fileName) {
        return ApplicationUtil.open("ioc/" + fileName + ".xml");
    }

    /**
     * @param tClass tClass
     * @param id     id
     * @param <T>    T
     * @return T
     * @author add by huyingzhao
     * 2023-02-24 12:48
     */
    protected <T> T getBean(Class<T> tClass, String id) {
        ApplicationContext applicationContext = ioc(id);
        T t = applicationContext.getBean(id, tClass);
        ApplicationUtil.close(applicationContext);
        return t;
    }

    /**
     * @param tClass   tClass
     * @param fileName fileName
     * @param id       id
     * @param <T>      T
     * @return T
     * @author add by huyingzhao
     * 2023-02-24 12:48
     */
    protected <T> T getBean(Class<T> tClass, String fileName, String id) {
        ApplicationContext applicationContext = ioc(fileName);
        T t = applicationContext.getBean(id, tClass);
        ApplicationUtil.close(applicationContext);
        return t;
    }

    protected <T> T getBean(Class<T> tClass, Class<?>... basePackages) {
        ApplicationContext applicationContext = ApplicationUtil.openClass(basePackages);
        T t = applicationContext.getBean(tClass);
        ApplicationUtil.close(applicationContext);
        return t;
    }
}

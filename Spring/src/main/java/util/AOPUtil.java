package util;

import org.springframework.context.ApplicationContext;

/**
 * @author add by huyingzhao
 * 2023-02-24 16:22
 */
public class AOPUtil {
    /**
     * @param fileName fileName
     * @return xml
     * @author add by huyingzhao
     * 2022-10-01 23:47
     */
    private static ApplicationContext aop(String fileName) {
        return ApplicationUtil.open("aop/" + fileName + ".xml");
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
        ApplicationContext applicationContext = aop(id);
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

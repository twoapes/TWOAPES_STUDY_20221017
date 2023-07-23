package util;

import org.springframework.context.ApplicationContext;

public class BeanUtil {
    /**
     * @param tClass   tClass
     * @param path     path
     * @param fileName fileName
     * @param <T>      T
     * @return T
     * @author add by huyingzhao
     * 2023-02-24 12:48
     */
    protected <T> T getBean(Class<T> tClass, String path, String fileName) {
        ApplicationContext applicationContext = ApplicationUtil.open(path + "/" + fileName + ".xml");
        T t = applicationContext.getBean(fileName, tClass);
        ApplicationUtil.close(applicationContext);
        return t;
    }

    /**
     * @param tClass   tClass
     * @param path     path
     * @param fileName fileName
     * @param id       id
     * @param <T>      T
     * @return T
     * @author add by huyingzhao
     * 2023-02-24 12:48
     */
    protected <T> T getBean(Class<T> tClass, String path, String fileName, String id) {
        ApplicationContext applicationContext = ApplicationUtil.open(path + "/" + fileName + ".xml");
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

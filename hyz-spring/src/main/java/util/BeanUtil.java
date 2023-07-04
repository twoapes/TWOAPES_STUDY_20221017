package util;

import org.springframework.context.ApplicationContext;

/**
 * @author add by huyingzhao
 * 2023-06-23 22:25
 */
public class BeanUtil {
    /**
     * @author add by huyingzhao
     * 2023-06-23 22:24 Friday
     * @param tClass tClass
     * @param basePackages basePackages
     * @return getBean
     * @param <T> <T>
     */
    protected <T> T getBean(Class<T> tClass, Class<?>... basePackages) {
        ApplicationContext applicationContext = ApplicationUtil.openClass(basePackages);
        T t = applicationContext.getBean(tClass);
        ApplicationUtil.close(applicationContext);
        return t;
    }
}

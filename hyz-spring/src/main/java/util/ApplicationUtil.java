package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationUtil {
    /**
     * @param configLocations configLocations
     * @return ApplicationContext using xml
     */
    public static ApplicationContext open(String... configLocations) {
        return new ClassPathXmlApplicationContext(configLocations);
    }

    /**
     * @param configLocations configLocations
     * @return ApplicationContext using file path
     */
    public static ApplicationContext openFilesystem(String... configLocations) {
        return new FileSystemXmlApplicationContext(configLocations);
    }

    /**
     * @param basePackages basePackages
     * @return ApplicationContext using bean
     */
    public static ApplicationContext openClass(Class<?>... basePackages) {
        return new AnnotationConfigApplicationContext(basePackages);
    }

    public static void close(ApplicationContext applicationContext) {
        if (applicationContext instanceof ClassPathXmlApplicationContext) {
            ClassPathXmlApplicationContext classPathXmlApplicationContext = (ClassPathXmlApplicationContext) applicationContext;
            classPathXmlApplicationContext.close();
        } else if (applicationContext instanceof AnnotationConfigApplicationContext) {
            AnnotationConfigApplicationContext configApplicationContext = (AnnotationConfigApplicationContext) applicationContext;
            configApplicationContext.close();
        }
    }
}

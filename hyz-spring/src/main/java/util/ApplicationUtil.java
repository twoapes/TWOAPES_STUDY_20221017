package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class ApplicationUtil {
    /**
     * @param configLocations configLocations
     * @return ApplicationContext using xml
     */
    static ApplicationContext open(String... configLocations) {
        return new ClassPathXmlApplicationContext(configLocations);
    }

    /**
     * @param basePackages basePackages
     * @return ApplicationContext using bean
     */
    static ApplicationContext openClass(Class<?>... basePackages) {
        return new AnnotationConfigApplicationContext(basePackages);
    }


    static void close(ApplicationContext applicationContext) {
        if (applicationContext instanceof ClassPathXmlApplicationContext) {
            ClassPathXmlApplicationContext classPathXmlApplicationContext = (ClassPathXmlApplicationContext) applicationContext;
            classPathXmlApplicationContext.close();
        } else if (applicationContext instanceof AnnotationConfigApplicationContext) {
            AnnotationConfigApplicationContext configApplicationContext = (AnnotationConfigApplicationContext) applicationContext;
            configApplicationContext.close();
        }
    }
}

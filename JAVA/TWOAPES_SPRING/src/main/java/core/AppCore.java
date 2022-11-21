package core;

// import org.springframework.beans.factory.xml.XmlBeanFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
// import org.springframework.core.io.ClassPathResource;

public class AppCore {
    /// /**
    //  * @param configLocations configLocations
    //  * @return ApplicationContext using xml
    //  */
    /// public static XmlBeanFactory openFactory(String configLocations) {
    //     ClassPathResource  classPathResource= new ClassPathResource(configLocations);
    //     return new XmlBeanFactory(classPathResource);
    // }

    /**
     * @param configLocations configLocations
     * @return ApplicationContext using xml
     */
    public static ApplicationContext open(String... configLocations) {
        return new ClassPathXmlApplicationContext(configLocations);
    }

///    /**
//     * @param configLocations configLocations
//     * @return ApplicationContext using file path
//     */
///    public static ApplicationContext openFilesystem(String... configLocations) {
//        return new FileSystemXmlApplicationContext(configLocations);
//    }

///    /**
//     * @param //configLocations configLocations
//     * @return ApplicationContext using file path
//     */
///   public static ApplicationContext openWebXml(String... configLocations) {
//        return new WebXmlApplicationContext(configLocations);
//    }

    /**
     * @param basePackages basePackages
     * @return ApplicationContext using bean
     */
    public static ApplicationContext openClass(Class<?>... basePackages) {
        return new AnnotationConfigApplicationContext(basePackages);
    }

    public static void close(ApplicationContext applicationContext) {
        if (applicationContext instanceof ClassPathXmlApplicationContext classPathXmlApplicationContext) {
            classPathXmlApplicationContext.close();
        } else if (applicationContext instanceof AnnotationConfigApplicationContext configApplicationContext) {
            configApplicationContext.close();
        }
    }
}

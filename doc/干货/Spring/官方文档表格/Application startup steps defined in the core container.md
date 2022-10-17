# Application startup steps defined in the core container

Name|Description|Tags
--|--|--
spring.beans.instantiate|Instantiation of a bean and its dependencies.|beanName the name of the bean, beanType the type required at the injection point.
spring.beans.smart&#45;initialize|Initialization of SmartInitializingSingleton beans.|beanName the name of the bean.
spring.context.annotated&#45;bean&#45;reader.create|Creation of the AnnotatedBeanDefinitionReader.|
spring.context.base&#45;packages.scan|Scanning of base packages.|packages array of base packages for scanning.
spring.context.beans.post&#45;process|Beans post&#45;processing phase.|
spring.context.bean&#45;factory.post&#45;process|Invocation of the BeanFactoryPostProcessor beans.|postProcessor the current post&#45;processor.
spring.context.beandef&#45;registry.post&#45;process|Invocation of the BeanDefinitionRegistryPostProcessor beans.|postProcessor the current post&#45;processor.
spring.context.component&#45;classes.register|Registration of component classes through AnnotationConfigApplicationContext#register.|classes array of given classes for registration.
spring.context.config&#45;classes.enhance|Enhancement of configuration classes with CGLIB proxies.|classCount count of enhanced classes.
spring.context.config&#45;classes.parse|Configuration classes parsing phase with the ConfigurationClassPostProcessor.|classCount count of processed classes.
spring.context.refresh|Application context refresh phase.|

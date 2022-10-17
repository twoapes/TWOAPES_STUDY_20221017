# Aware interfaces Name

Name|Injected Dependency|Explained in…​
--|--|--
ApplicationContextAware|Declaring ApplicationContext.|ApplicationContextAware and BeanNameAware
ApplicationEventPublisherAware|Event publisher of the enclosing ApplicationContext.|Additional Capabilities of the ApplicationContext
BeanClassLoaderAware|Class loader used to load the bean classes.|Instantiating Beans
BeanFactoryAware|Declaring BeanFactory.|The BeanFactory API
BeanNameAware|Name of the declaring bean.|ApplicationContextAware and BeanNameAware
LoadTimeWeaverAware|Defined weaver for processing class definition at load time.|Load&#45;time Weaving with AspectJ in the Spring Framework
MessageSourceAware|Configured strategy for resolving messages (with support for parametrization and internationalization).|Additional Capabilities of the ApplicationContext
NotificationPublisherAware|Spring JMX notification publisher.|Notifications
ResourceLoaderAware|Configured loader for low&#45;level access to resources.|Resources
ServletConfigAware|Current ServletConfig the container runs in. Valid only in a web&#45;aware Spring ApplicationContext.|Spring MVC
ServletContextAware|Current ServletContext the container runs in. Valid only in a web&#45;aware Spring ApplicationContext.|Spring MVC

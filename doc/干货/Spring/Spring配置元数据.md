# Spring配置元数据

有下面三个重要的方法把配置元数据提供给Spring容器

- 基于XML的配置文件
- 基于注解的配置
- 基于Java的配置

```XML
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <!-- A simplebeandefinition -->
   <bean id="..." class="...">
       <!-- collaborators and configuration for thisbeango here -->
   </bean>

   <!-- Abeandefinition with lazy init set on -->
   <bean id="..." class="..." lazy-init="true">
       <!-- collaborators and configuration for thisbeango here -->
   </bean>

   <!-- Abeandefinition with initialization method -->
   <bean id="..." class="..." init-method="...">
       <!-- collaborators and configuration for thisbeango here -->
   </bean>

   <!-- Abeandefinition with destruction method -->
   <bean id="..." class="..." destroy-method="...">
       <!-- collaborators and configuration for thisbeango here -->
   </bean>

   <!-- morebeandefinitions go here -->

</beans>
```

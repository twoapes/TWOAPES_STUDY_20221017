# singelton和prototype对比

||singleton|prototype
--|--|--
对象数量|全局唯一|存在多个
实例化时机|IOC容器启动时|getBean()或对象注入时
线程安全问题|存在|不存在
执行效率|高|低

prototype在容器中多实例, 占用更多资源, 不存在线程安全问题

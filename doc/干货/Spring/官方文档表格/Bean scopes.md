# Bean scopes

scope属性

Scope|Description
--|--
singleton|(Default) Scopes a single bean definition to a single object instance for each Spring IoC container.
prototype|Scopes a single bean definition to any number of object instances.
request|Scopes a single bean definition to the lifecycle of a single HTTP request. That is, each HTTP request has its own instance of a bean created off the back of a single bean definition. Only valid in the context of a web&#45;aware Spring ApplicationContext.
session|Scopes a single bean definition to the lifecycle of an HTTP Session. Only valid in the context of a web&#45;aware Spring ApplicationContext.
application|Scopes a single bean definition to the lifecycle of a ServletContext. Only valid in the context of a web&#45;aware Spring ApplicationContext.
websocket|Scopes a single bean definition to the lifecycle of a WebSocket. Only valid in the context of a web&#45;aware Spring ApplicationContext.

scope属性|说明
--|--
singleton|单例(默认值),每一个容器有且只有唯一的实例,实例被全局共享
prototype|多例,每次使用时都是创建一个实例
request|web环境下,每一次独立请求存在唯一实例
session|web环境下, 每一个session存在有唯一实例
application|web环境下, ServletContext存在唯一实例
websocket|每一次WebSocket连接中存在唯一实例

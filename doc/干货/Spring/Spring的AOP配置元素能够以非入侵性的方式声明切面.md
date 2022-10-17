# Spring的AOP配置元素能够以非入侵性的方式声明切面

AOP配置元素|用途
--|--
&#60;aop&#58;advisor&#62;|定义AOP通知器
&#60;aop&#58;after&#62;|定义后置通知
&#60;aop&#58;after-returning&#62;|定义AOP返回通知
&#60;aop&#58;after-throwing&#62;|定义AOP异常通知
&#60;aop&#58;around&#62;|定义AOP环绕通知
&#60;aop&#58;aspect&#62;|定义一个切面
&#60;aop&#58;aspectj-autoproxy&#62;|启用@AspectJ注解驱动的切面
&#60;aop&#58;before&#62;|定义AOP前置通知
&#60;aop&#58;config&#62;|顶层的AOP配置元素.大多数的&#60;aop&#58;&#42;&#62;元素必须包含在&#60;aop&#58;config&#62;内
&#60;aop&#58;declare-parent&#62;|以透明的方式为被通知的对象引入额外的接口
&#60;aop&#58;pointcut&#62;|定义一个切点

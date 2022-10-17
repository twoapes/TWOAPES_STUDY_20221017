# SpringBootApplication注解

@SpringBootApplication是一个组合注解,它组合了3个其他的注解.

- @SpringBootConfiguration：将该类声明为配置类.尽管这个类目前还没有太多的配置,但是后续我们可以按需添加基于Java的Spring框架配置.这个注解实际上是@Configuration注解的特殊形式.
- @EnableAutoConfiguration：启用SpringBoot的自动配置.我们随后会介绍自动配置的更多功能.就现在来说,我们只需要知道这个注解会告诉SpringBoot自动配置它认为我们会用到的组件.
- @ComponentScan：启用组件扫描.这样我们能够通过像@Component,@Controller,@Service这样的注解声明其他类,Spring会自动发现它们并将它们注册为Spring应用上下文中的组件.

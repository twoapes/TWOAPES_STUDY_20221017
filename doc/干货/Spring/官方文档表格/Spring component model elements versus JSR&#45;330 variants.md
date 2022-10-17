# Spring component model elements versus JSR&#45;330 variants

Spring|javax.inject.&#42;|javax.inject restrictions&#47;comments
--|--|--
@Autowired|@Inject|@Inject has no 'required' attribute. Can be used with Java 8’s Optional instead.
@Component|@Named&#47;@ManagedBean|JSR&#45;330 does not provide a composable model, only a way to identify named components.
@Scope("singleton")|@Singleton|The JSR&#45;330 default scope is like Spring’s prototype. However, in order to keep it consistent with Spring’s general defaults, a JSR&#45;330 bean declared in the Spring container is a singleton by default. In order to use a scope other than singleton, you should use Spring’s @Scope annotation. javax.inject also provides a @Scope annotation. Nevertheless, this one is only intended to be used for creating your own annotations.
@Qualifier|@Qualifier&#47;@Named|javax.inject.Qualifier is just a meta&#45;annotation for building custom qualifiers. Concrete String qualifiers (like Spring’s @Qualifier with a value) can be associated through javax.inject.Named.
@Value|&#45;|no equivalent
@Required|&#45;|no equivalent
@Lazy|&#45;|no equivalent
ObjectFactory|Provider|javax.inject.Provider is a direct alternative to Spring’s ObjectFactory, only with a shorter get() method name. It can also be used in combination with Spring’s @Autowired or with non&#45;annotated constructors and setter methods.

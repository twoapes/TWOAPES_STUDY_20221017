# DefaultContextLoadTimeWeaver LoadTimeWeavers

Runtime Environment|LoadTimeWeaver implementation
--|--
Running in Apache Tomcat|TomcatLoadTimeWeaver
Running in GlassFish (limited to EAR deployments)|GlassFishLoadTimeWeaver
Running in Red Hat’s JBoss AS or WildFly|JBossLoadTimeWeaver
Running in IBM’s WebSphere|WebSphereLoadTimeWeaver
Running in Oracle’s WebLogic|WebLogicLoadTimeWeaver
JVM started with Spring InstrumentationSavingAgent (java &#45;javaagent&#58;path&#47;to&#47;spring&#45;instrument.jar)|InstrumentationLoadTimeWeaver
Fallback, expecting the underlying ClassLoader to follow common conventions (namely addTransformer and optionally a getThrowawayClassLoader method)|ReflectiveLoadTimeWeaver

# Attributes of the JMS &#60;listener&#45;container&#62; element

Attribute|Description
--|--
container&#45;type|The type of this listener container. The available options are default, simple, default102, or simple102 (the default option is default).
container&#45;class|A custom listener container implementation class as a fully qualified class name. The default is Spring’s standard DefaultMessageListenerContainer or SimpleMessageListenerContainer, according to the container&#45;type attribute.
factory&#45;id|Exposes the settings defined by this element as a JmsListenerContainerFactory with the specified id so that they can be reused with other endpoints.
connection&#45;factory|A reference to the JMS ConnectionFactory bean (the default bean name is connectionFactory).
task&#45;executor|A reference to the Spring TaskExecutor for the JMS listener invokers.
destination&#45;resolver|A reference to the DestinationResolver strategy for resolving JMS Destination instances.
message&#45;converter|A reference to the MessageConverter strategy for converting JMS Messages to listener method arguments. The default is a SimpleMessageConverter.
error&#45;handler|A reference to an ErrorHandler strategy for handling any uncaught exceptions that may occur during the execution of the MessageListener.
destination&#45;type|The JMS destination type for this listener&#58; queue, topic, durableTopic, sharedTopic, or sharedDurableTopic. This potentially enables the pubSubDomain, subscriptionDurable and subscriptionShared properties of the container. The default is queue (which disables those three properties).
response&#45;destination&#45;type|The JMS destination type for responses&#58; queue or topic. The default is the value of the destination&#45;type attribute.
client&#45;id|The JMS client ID for this listener container. You must specify it when you use durable subscriptions.
cache|The cache level for JMS resources&#58; none, connection, session, consumer, or auto. By default (auto), the cache level is effectively consumer, unless an external transaction manager has been specified — in which case, the effective default will be none (assuming Java EE&#45;style transaction management, where the given ConnectionFactory is an XA&#45;aware pool).
acknowledge|The native JMS acknowledge mode&#58; auto, client, dups&#45;ok, or transacted. A value of transacted activates a locally transacted Session. As an alternative, you can specify the transaction&#45;manager attribute, described later in table. The default is auto.
transaction&#45;manager|A reference to an external PlatformTransactionManager (typically an XA&#45;based transaction coordinator, such as Spring’s JtaTransactionManager). If not specified, native acknowledging is used (see the acknowledge attribute).
concurrency|The number of concurrent sessions or consumers to start for each listener. It can either be a simple number indicating the maximum number (for example, 5) or a range indicating the lower as well as the upper limit (for example, 3&#45;5). Note that a specified minimum is just a hint and might be ignored at runtime. The default is 1. You should keep concurrency limited to 1 in case of a topic listener or if queue ordering is important. Consider raising it for general queues.
prefetch|The maximum number of messages to load into a single session. Note that raising this number might lead to starvation of concurrent consumers.
receive&#45;timeout|The timeout (in milliseconds) to use for receive calls. The default is 1000 (one second). &#45;1 indicates no timeout.
back&#45;off|Specifies the BackOff instance to use to compute the interval between recovery attempts. If the BackOffExecution implementation returns BackOffExecution#STOP, the listener container does not further try to recover. The recovery&#45;interval value is ignored when this property is set. The default is a FixedBackOff with an interval of 5000 milliseconds (that is, five seconds).
recovery&#45;interval|Specifies the interval between recovery attempts, in milliseconds. It offers a convenient way to create a FixedBackOff with the specified interval. For more recovery options, consider specifying a BackOff instance instead. The default is 5000 milliseconds (that is, five seconds).
phase|The lifecycle phase within which this container should start and stop. The lower the value, the earlier this container starts and the later it stops. The default is Integer.MAX_VALUE, meaning that the container starts as late as possible and stops as soon as possible.

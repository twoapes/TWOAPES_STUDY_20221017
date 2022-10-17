# Attributes of the JMS &#60;jca&#45;listener&#45;container&#47;&#62; element

Attribute|Description
--|--
factory&#45;id|Exposes the settings defined by this element as a JmsListenerContainerFactory with the specified id so that they can be reused with other endpoints.
resource&#45;adapter|A reference to the JCA ResourceAdapter bean (the default bean name is resourceAdapter).
activation&#45;spec&#45;factory|A reference to the JmsActivationSpecFactory. The default is to autodetect the JMS provider and its ActivationSpec class (see DefaultJmsActivationSpecFactory).
destination&#45;resolver|A reference to the DestinationResolver strategy for resolving JMS Destinations.
message&#45;converter|A reference to the MessageConverter strategy for converting JMS Messages to listener method arguments. The default is SimpleMessageConverter.
destination&#45;type|The JMS destination type for this listener&#58; queue, topic, durableTopic, sharedTopic. or sharedDurableTopic. This potentially enables the pubSubDomain, subscriptionDurable, and subscriptionShared properties of the container. The default is queue (which disables those three properties).
response&#45;destination&#45;type|The JMS destination type for responses&#58; queue or topic. The default is the value of the destination&#45;type attribute.
client&#45;id|The JMS client ID for this listener container. It needs to be specified when using durable subscriptions.
acknowledge|The native JMS acknowledge mode&#58; auto, client, dups&#45;ok, or transacted. A value of transacted activates a locally transacted Session. As an alternative, you can specify the transaction&#45;manager attribute described later. The default is auto.
transaction&#45;manager|A reference to a Spring JtaTransactionManager or a javax.transaction.TransactionManager for kicking off an XA transaction for each incoming message. If not specified, native acknowledging is used (see the acknowledge attribute).
concurrency|The number of concurrent sessions or consumers to start for each listener. It can either be a simple number indicating the maximum number (for example 5) or a range indicating the lower as well as the upper limit (for example, 3&#45;5). Note that a specified minimum is only a hint and is typically ignored at runtime when you use a JCA listener container. The default is 1.
prefetch|The maximum number of messages to load into a single session. Note that raising this number might lead to starvation of concurrent consumers.

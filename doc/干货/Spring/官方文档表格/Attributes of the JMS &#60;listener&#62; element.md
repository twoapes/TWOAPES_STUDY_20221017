# Attributes of the JMS &#60;listener&#62; element

Attribute|Description
--|--
id|A bean name for the hosting listener container. If not specified, a bean name is automatically generated.
destination (required)|The destination name for this listener, resolved through the DestinationResolver strategy.
ref (required)|The bean name of the handler object.
method|The name of the handler method to invoke. If the ref attribute points to a MessageListener or Spring SessionAwareMessageListener, you can omit this attribute.
response&#45;destination|The name of the default response destination to which to send response messages. This is applied in case of a request message that does not carry a JMSReplyTo field. The type of this destination is determined by the listener&#45;container’s response&#45;destination&#45;type attribute. Note that this applies only to a listener method with a return value, for which each result object is converted into a response message.
subscription|The name of the durable subscription, if any.
selector|An optional message selector for this listener.
concurrency|The number of concurrent sessions or consumers to start for this listener. This value can either be a simple number indicating the maximum number (for example, 5) or a range indicating the lower as well as the upper limit (for example, 3&#45;5). Note that a specified minimum is only a hint and might be ignored at runtime. The default is the value provided by the container.

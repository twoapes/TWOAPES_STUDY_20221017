# Event SpEL available metadata

Name|Location|Description|Example
--|--|--|--
Event|root object|The actual ApplicationEvent.|&#35;root.event or event
Arguments array|root object|The arguments (as an object array) used to invoke the method.|&#35;root.args or args; args&#91;0&#93; to access the first argument, etc.
Argument name|evaluation context|The name of any of the method arguments. If, for some reason, the names are not available (for example, because there is no debug information in the compiled byte code), individual arguments are also available using the &#35;a&#60;#arg&#62; syntax where &#60;&#35;arg&#62; stands for the argument index (starting from 0).|&#35;blEvent or &#35;a0 (you can also use &#35;p0 or &#35;p&#60;&#35;arg&#62; parameter notation as an alias)

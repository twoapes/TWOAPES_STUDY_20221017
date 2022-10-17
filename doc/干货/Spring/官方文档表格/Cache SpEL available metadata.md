# Cache SpEL available metadata

Name|Location|Description|Example
--|--|--|--
methodName|Root object|The name of the method being invoked|&#35;root.methodName
method|Root object|The method being invoked|&#35;root.method.name
target|Root object|The target object being invoked|&#35;root.target
targetClass|Root object|The class of the target being invoked|&#35;root.targetClass
args|Root object|The arguments (as array) used for invoking the target|&#35;root.args&#91;0&#93;
caches|Root object|Collection of caches against which the current method is run|&#35;root.caches&#91;0&#93;.name
Argument name|Evaluation context|Name of any of the method arguments. If the names are not available (perhaps due to having no debug information), the argument names are also available under the &#35;a&#60;&#35;arg&#62; where &#35;arg stands for the argument index (starting from 0).|&#35;iban or &#35;a0 (you can also use &#35;p0 or &#35;p&#60;&#35;arg&#62; notation as an alias).
result|Evaluation context|The result of the method call (the value to be cached). Only available in unless expressions, cache put expressions (to compute the key), or cache evict expressions (when beforeInvocation is false). For supported wrappers (such as Optional), &#35;result refers to the actual object, not the wrapper.|&#35;result

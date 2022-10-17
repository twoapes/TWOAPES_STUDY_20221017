# Filter Types

Filter Type|Example Expression|Description
--|--|--
annotation (default)|org.example.SomeAnnotation|An annotation to be present or meta&#45;present at the type level in target components.
assignable|org.example.SomeClass|A class (or interface) that the target components are assignable to (extend or implement).
aspectj|org.example..&#42;Service&#43;|An AspectJ type expression to be matched by the target components.
regex|org&#92;.example&#92;.Default.&#42;|A regex expression to be matched by the target components' class names.
custom|org.example.MyTypeFilter|A custom implementation of the org.springframework.core.type.TypeFilter interface.

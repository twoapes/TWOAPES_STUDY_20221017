# Source&#45;level metadata types

Purpose|Annotation|Annotation Type
--|--|--
Mark all instances of a Class as JMX managed resources.|@ManagedResource|Class
Mark a method as a JMX operation.|@ManagedOperation|Method
Mark a getter or setter as one half of a JMX attribute.|@ManagedAttribute|Method (only getters and setters)
Define descriptions for operation parameters.|@ManagedOperationParameter and @ManagedOperationParameters|Method

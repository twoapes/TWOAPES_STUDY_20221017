# Registration Behaviors

Registration behavior|Explanation
--|--
FAIL_ON_EXISTING|This is the default registration behavior. If an MBean instance has already been registered under the same ObjectName, the MBean that is being registered is not registered, and an InstanceAlreadyExistsException is thrown. The existing MBean is unaffected.
IGNORE_EXISTING|If an MBean instance has already been registered under the same ObjectName, the MBean that is being registered is not registered. The existing MBean is unaffected, and no Exception is thrown. This is useful in settings where multiple applications want to share a common MBean in a shared MBeanServer.
REPLACE_EXISTING|If an MBean instance has already been registered under the same ObjectName, the existing MBean that was previously registered is unregistered, and the new MBean is registered in its place (the new MBean effectively replaces the previous instance).

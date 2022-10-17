# &#60;tx&#58;method&#47;&#62; settings

Attribute|Required?|Default|Description
--|--|--|--
name|Yes||Method names with which the transaction attributes are to be associated. The wildcard (&#42;) character can be used to associate the same transaction attribute settings with a number of methods (for example, get&#42;, handle&#42;, on&#42;Event, and so forth).
propagation|No|REQUIRED|Transaction propagation behavior.
isolation|No|DEFAULT|Transaction isolation level. Only applicable to propagation settings of REQUIRED or REQUIRES_NEW.
timeout|No|&#45;1|Transaction timeout (seconds). Only applicable to propagation REQUIRED or REQUIRES_NEW.
read&#45;only|No|FALSE|Read&#45;write versus read&#45;only transaction. Applies only to REQUIRED or REQUIRES_NEW.
rollback&#45;for|No||Comma&#45;delimited list of Exception instances that trigger rollback. For example, com.foo.MyBusinessException,ServletException.
no&#45;rollback&#45;for|No||Comma&#45;delimited list of Exception instances that do not trigger rollback. For example, com.foo.MyBusinessException,ServletException.

# AspectJ weaving attribute values

Annotation Value|XML Value|Explanation
--|--|--
ENABLED|on|AspectJ weaving is on, and aspects are woven at load&#45;time as appropriate.
DISABLED|off|LTW is off. No aspect is woven at load&#45;time.
AUTODETECT|autodetect|If the Spring LTW infrastructure can find at least one META&#45;INF&#47;aop.xml file, then AspectJ weaving is on. Otherwise, it is off. This is the default value.

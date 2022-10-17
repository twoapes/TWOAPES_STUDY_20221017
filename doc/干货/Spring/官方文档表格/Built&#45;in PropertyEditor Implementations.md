# Built&#45;in PropertyEditor Implementations

Class|Explanation
--|--
ByteArrayPropertyEditor|Editor for byte arrays. Converts strings to their corresponding byte representations. Registered by default by BeanWrapperImpl.
ClassEditor|Parses Strings that represent classes to actual classes and vice&#45;versa. When a class is not found, an IllegalArgumentException is thrown. By default, registered by BeanWrapperImpl.
CustomBooleanEditor|Customizable property editor for Boolean properties. By default, registered by BeanWrapperImpl but can be overridden by registering a custom instance of it as a custom editor.
CustomCollectionEditor|Property editor for collections, converting any source Collection to a given target Collection type.
CustomDateEditor|Customizable property editor for java.util.Date, supporting a custom DateFormat. NOT registered by default. Must be user&#45;registered with the appropriate format as needed.
CustomNumberEditor|Customizable property editor for any Number subclass, such as Integer, Long, Float, or Double. By default, registered by BeanWrapperImpl but can be overridden by registering a custom instance of it as a custom editor.
FileEditor|Resolves strings to java.io.File objects. By default, registered by BeanWrapperImpl.
InputStreamEditor|One&#45;way property editor that can take a string and produce (through an intermediate ResourceEditor and Resource) an InputStream so that InputStream properties may be directly set as strings. Note that the default usage does not close the InputStream for you. By default, registered by BeanWrapperImpl.
LocaleEditor|Can resolve strings to Locale objects and vice&#45;versa (the string format is &#91;language&#93;&#95;&#91;country&#93;&#95;&#91;variant&#93;, same as the toString() method of Locale). Also accepts spaces as separators, as an alternative to underscores. By default, registered by BeanWrapperImpl.
PatternEditor|Can resolve strings to java.util.regex.Pattern objects and vice&#45;versa.
PropertiesEditor|Can convert strings (formatted with the format defined in the javadoc of the java.util.Properties class) to Properties objects. By default, registered by BeanWrapperImpl.
StringTrimmerEditor|Property editor that trims strings. Optionally allows transforming an empty string into a null value. NOT registered by default &#45; must be user&#45;registered.
URLEditor|Can resolve a string representation of a URL to an actual URL object. By default, registered by BeanWrapperImpl.

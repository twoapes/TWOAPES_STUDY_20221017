# DispatcherServlet initialization parameters

Parameter|Explanation
--|--
contextClass|Class that implements ConfigurableWebApplicationContext, to be instantiated and locally configured by this Servlet. By default, XmlWebApplicationContext is used.
contextConfigLocation|String that is passed to the context instance (specified by contextClass) to indicate where contexts can be found. The string consists potentially of multiple strings (using a comma as a delimiter) to support multiple contexts. In the case of multiple context locations with beans that are defined twice, the latest location takes precedence.
namespace|Namespace of the WebApplicationContext. Defaults to &#91;servlet&#45;name&#93;&#45;servlet.
throwExceptionIfNoHandlerFound|Whether to throw a NoHandlerFoundException when no handler was found for a request. The exception can then be caught with a HandlerExceptionResolver (for example, by using an @ExceptionHandler controller method) and handled as any others. By default, this is set to false, in which case the DispatcherServlet sets the response status to 404 (NOT_FOUND) without raising an exception. Note that, if default servlet handling is also configured, unresolved requests are always forwarded to the default servlet and a 404 is never raised.

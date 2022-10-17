
# Spring的一些异常会默认映射为HTTP状态码

Spring异常|HTTP状态码
--|--
BindException|400 - Bad Request
ConversionNotSupportedException|500 - Internal Server Error
HttpMediaTypeNotAcceptableException|406 - Not Acceptable
HttpMediaTypeNotSupportedException|415 - Unsupported Media Type
HttpMessageNotReadableException|400 - Bad Request
HttpMessageNotWritableException|500 - Internal Server Error
HttpRequestMethodNotSupportedException|405 - Method Not Allowed
MethodArgumentNotValidException|400 - Bad Request
MissingServletRequestParameterException|400 - Bad Request
MissingServletRequestPartException|400 - Bad Request
NoSuchRequestHandlingMethodException|404 - Not Found
TypeMismatchException|400 - Bad Request

# CookieLocaleResolver properties

Property|Default|Description
--|--|--
cookieName|classname &#43; LOCALE|The name of the cookie
cookieMaxAge|Servlet container default|The maximum time a cookie persists on the client. If &#45;1 is specified, the cookie will not be persisted. It is available only until the client shuts down the browser.
cookiePath|&#47;|Limits the visibility of the cookie to a certain part of your site. When cookiePath is specified, the cookie is visible only to that path and the paths below it.

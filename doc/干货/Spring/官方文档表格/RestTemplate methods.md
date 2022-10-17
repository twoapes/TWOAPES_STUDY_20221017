# RestTemplate methods

Method group|Description
--|--
getForObject|Retrieves a representation via GET.
getForEntity|Retrieves a ResponseEntity (that is, status, headers, and body) by using GET.
headForHeaders|Retrieves all headers for a resource by using HEAD.
postForLocation|Creates a new resource by using POST and returns the Location header from the response.
postForObject|Creates a new resource by using POST and returns the representation from the response.
postForEntity|Creates a new resource by using POST and returns the representation from the response.
put|Creates or updates a resource by using PUT.
patchForObject|Updates a resource by using PATCH and returns the representation from the response. Note that the JDK HttpURLConnection does not support PATCH, but Apache HttpComponents and others do.
delete|Deletes the resources at the specified URI by using DELETE.
optionsForAllow|Retrieves allowed HTTP methods for a resource by using ALLOW.
exchange|More generalized (and less opinionated) version of the preceding methods that provides extra flexibility when needed. It accepts a RequestEntity (including HTTP method, URL, headers, and body as input) and returns a ResponseEntity.These methods allow the use of ParameterizedTypeReference instead of Class to specify a response type with generics.
execute|The most generalized way to perform a request, with full control over request preparation and response extraction through callback interfaces.

# Spring vs. JSR&#45;107 caching annotations

Spring|JSR&#45;107|Remark
--|--|--
@Cacheable|@CacheResult|Fairly similar. @CacheResult can cache specific exceptions and force the execution of the method regardless of the content of the cache.
@CachePut|@CachePut|While Spring updates the cache with the result of the method invocation, JCache requires that it be passed it as an argument that is annotated with @CacheValue. Due to this difference, JCache allows updating the cache before or after the actual method invocation.
@CacheEvict|@CacheRemove|Fairly similar. @CacheRemove supports conditional eviction when the method invocation results in an exception.
@CacheEvict(allEntries=true)|@CacheRemoveAll|See @CacheRemove.
@CacheConfig|@CacheDefaults|Lets you configure the same concepts, in a similar fashion.

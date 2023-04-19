package util;

import lombok.extern.slf4j.Slf4j;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.xml.XmlConfiguration;

import java.net.URL;
import java.time.Duration;
import java.util.function.Function;

/**
 * @author add by huyingzhao
 * 2022-09-06 9:48
 */
@Slf4j
public class CacheUtil {
    private static volatile CacheManager cacheManager;


    /**
     * @return create cache
     */
    private static CacheManager getCacheManager() {
        if (cacheManager == null) {
            synchronized (CacheUtil.class) {
                URL xmlUrl = CacheUtil.class.getClassLoader().getResource("ehcache.xml");
                if (cacheManager == null && xmlUrl != null) {
                    Configuration xmlConfig = new XmlConfiguration(xmlUrl);
                    cacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
                    cacheManager.init();
                }
            }
        }
        return cacheManager;
    }

    /**
     * @param cacheName cacheName
     * @param keyType   keyType
     * @param valueType valueType
     * @return getCache
     */
    public static <K, V> Cache<K, V> getCache(String cacheName, Class<K> keyType, Class<V> valueType) {
        // Map<String, Cache<K, V>> cacheMap = new ConcurrentHashMap<>();
        Cache<K, V> cache= getCacheManager().getCache(cacheName, keyType, valueType);
        if (cache == null) {
            CacheConfigurationBuilder<K, V> builder = CacheConfigurationBuilder
                    .newCacheConfigurationBuilder(keyType, valueType, ResourcePoolsBuilder.heap(1_0000))
                    .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofMinutes(30)));
            cache = getCacheManager().createCache(cacheName, builder);
        }
//        reloadCacheData(cache, cacheName);
        // cacheMap.put(cacheName, cache);
        return cache;
    }

    /**
     * for (String cacheName : cacheMap.keySet()) {
     * Cache cache = cacheMap.get(cacheName);
     * File file = new File(NConst.CACHE_PATH + cacheName + ".txt");
     * JsonUtil.writeValue(file, cache.iterator());
     * }
     *
     * @param cache     cache
     * @param cacheName cacheName
     */
    public static <K, V> void reloadCacheData(String path, String cacheName, Cache<K, V> cache) {
        try {
            // if (cacheMap.get(cacheName) == null) {
                // File file = new File(path, cacheName + ".txt");
//                if (file.exists() && System.currentTimeMillis() - file.lastModified() > 3600_000) {
//                    List list = JsonUtil.toList(file, List.class);
//                    for (Object obj : list) {
//                        Map map = (Map) obj;
//                        cache.put((K) map.get("key"), (V) map.get("value"));
//                    }
//                }
            // }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public static <K, V> V getValue(String cacheName,K k, Class<K> key, Class<V> valueType) {
        Cache<K, V> cache = getCache(cacheName, key, valueType);
        return cache.get(k);
    }

    public static <K, V> void putValue(String cacheName,K k,V v, Class<K> key, Class<V>  value) {
        Cache<K, V> cache = (Cache<K, V>) getCache(cacheName, key, value);
        cache.put(k, v);
    }

    public static <K, V> V getValue(Cache<K, V> cache, K key, Function<K, V> function) {
        V v = cache.get(key);
        if (v == null) {
            v = function.apply(key);
            cache.put(key, v);
        }
        return v;
    }
}

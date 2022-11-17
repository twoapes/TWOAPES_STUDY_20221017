package util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * 这个json工具类null也会序列化
 *
 * @author: yuez
 * @date: 2020/12/10 10:41
 */
@Slf4j
public class JacksonUtil {
    public final static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        mapper.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
    }

    /**
     * @return getMapper
     * @author add by huyingzhao
     * 2022-11-16 10:21
     */
    public static ObjectMapper getMapper() {
        return mapper.copy();
    }

    /**
     * @param parametrized     parametrized
     * @param parameterClasses parameterClasses
     * @return constructParametricType
     * @author add by huyingzhao
     * 2022-11-16 10:21
     */
    public static Type constructParametricType(Class<?> parametrized, Class<?>... parameterClasses) {
        return mapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
    }

    /**
     * @param obj obj
     * @return toJson
     * @author add by huyingzhao
     * 2022-11-16 10:21
     */
    public static String toJson(Object obj) {
        String json = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        try {
            json = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        return json;
    }

    /**
     * @param file   file
     * @param tClass tClass
     * @param <T>    <T>
     * @return toClass
     * @author add by huyingzhao
     * 2022-11-16 10:21
     */
    public static <T> T toClass(File file, Class<T> tClass) {
        try {
            return mapper.readValue(file, tClass);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * @param file file
     * @param type type
     * @param <T>  <T>
     * @return toClass
     * @author add by huyingzhao
     * 2022-11-16 10:21
     */
    public static <T> T toClass(File file, Type type) {
        try {
            return mapper.readValue(file, mapper.constructType(type));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * @param in     in
     * @param tClass tClass
     * @param <T>    <T>
     * @return toClass
     * @author add by huyingzhao
     * 2022-11-16 10:21
     */
    public static <T> T toClass(InputStream in, Class<T> tClass) {
        try {
            return mapper.readValue(in, tClass);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * @param json json
     * @param type type
     * @param <T>  <T>
     * @return toClass
     * @author add by huyingzhao
     * 2022-11-16 10:21
     */
    public static <T> T toClass(InputStream json, Type type) {
        try {
            return mapper.readValue(json, mapper.constructType(type));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * @param bytes  bytes
     * @param tClass tClass
     * @param <T>    <T>
     * @return toClass
     * @author add by huyingzhao
     * 2022-11-16 10:21
     */
    public static <T> T toClass(byte[] bytes, Class<T> tClass) {
        try {
            return mapper.readValue(bytes, tClass);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * @param bytes bytes
     * @param type  type
     * @param <T>   <T>
     * @return <T> T
     * @author add by huyingzhao
     * 2022-11-16 10:19
     */
    public static <T> T toClass(byte[] bytes, Type type) {
        try {
            return mapper.readValue(bytes, mapper.constructType(type));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * @param json   json
     * @param tClass tClass
     * @param <T>    <T>
     * @return <T> T
     * @author add by huyingzhao
     * 2022-11-16 10:16
     */
    public static <T> T toClass(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json, tClass);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * @param json json
     * @param type type
     * @param <T>  <T>
     * @return <T> T
     * @author add by huyingzhao
     * 2022-11-16 10:16
     */
    public static <T> T toClass(String json, Type type) {
        try {
            return mapper.readValue(json, mapper.constructType(type));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * @param obj    obj
     * @param kClazz kClazz
     * @param vClazz vClazz
     * @param <K>    <K>
     * @param <V>    <V>
     * @return <K, V>
     * @author add by huyingzhao
     * 2022-11-16 10:08
     */
    public static <K, V> Map<K, V> toMap(Object obj, Class<K> kClazz, Class<V> vClazz) {
        try {
            MapType tClass = mapper.getTypeFactory().constructMapType(Map.class, kClazz, vClazz);
            if (obj instanceof InputStream) {
                return mapper.readValue((InputStream) obj, tClass);
            } else if (obj instanceof File) {
                return mapper.readValue((File) obj, tClass);
            } else if (obj instanceof byte[]) {
                return mapper.readValue((byte[]) obj, tClass);
            } else {
                return mapper.readValue(toJson(obj), tClass);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * @param obj    obj
     * @param kClazz kClazz
     * @param <T>    <T>
     * @return T
     * @author add by huyingzhao
     * 2022-11-16 10:07
     */
    public static <T> List<T> toList(Object obj, Class<T> kClazz) {
        try {
            CollectionType tClass = mapper.getTypeFactory().constructCollectionType(List.class, kClazz);
            if (obj instanceof InputStream) {
                return mapper.readValue((InputStream) obj, tClass);
            } else if (obj instanceof File) {
                return mapper.readValue((File) obj, tClass);
            } else if (obj instanceof byte[]) {
                return mapper.readValue((byte[]) obj, tClass);
            } else {
                return mapper.readValue(toJson(obj), tClass);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * @param obj    obj
     * @param tClass tClass
     * @param <T>    <T>
     * @return T
     * @author add by huyingzhao
     * 2022-11-16 10:07
     */
    public static <T> T toBean(Object obj, Class<T> tClass) {
        if (obj instanceof InputStream) {
            return toClass((InputStream) obj, tClass);
        } else if (obj instanceof File) {
            return toClass((File) obj, tClass);
        } else if (obj instanceof byte[]) {
            return toClass((byte[]) obj, tClass);
        }
        return toClass(toJson(obj), tClass);
    }

    /**
     * @param obj  obj
     * @param type type
     * @param <T>  <T>
     * @return T
     * @author add by huyingzhao
     * 2022-11-16 10:07
     */
    public static <T> T toBean(Object obj, Type type) {
        if (obj instanceof InputStream) {
            return toClass((InputStream) obj, type);
        } else if (obj instanceof File) {
            return toClass((File) obj, type);
        } else if (obj instanceof byte[]) {
            return toClass((byte[]) obj, type);
        }
        return toClass(toJson(obj), type);
    }
}

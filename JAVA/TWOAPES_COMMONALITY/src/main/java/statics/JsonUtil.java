package statics;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author add by huyingzhao
 * 2022-10-08 9:41
 */
@Slf4j
public class JsonUtil {
    public final static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

    }

    /**
     * @param file           file
     * @param elementClasses elementClasses
     * @param <T>            <T>
     * @return toList
     * @author add by huyingzhao
     * 2022-09-20 22:42
     */
    public static <T> List<T> toList(File file, Class<T> elementClasses) {
        try {
            return mapper.readValue(file, mapper.getTypeFactory().constructParametricType(List.class, elementClasses));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}

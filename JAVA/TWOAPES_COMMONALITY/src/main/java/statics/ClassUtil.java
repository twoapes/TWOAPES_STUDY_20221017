package statics;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;

/**
 * @author add by huyingzhao
 * 2022-06-29 14:52
 * invoke method
 */
@Slf4j
public class ClassUtil {

    /**
     * using invoke
     *
     * @param className  class name
     * @param methodName class method
     * @param args       closs args
     * @return invoke
     * @author add by huyingzhao
     * 2022-06-29 15:00
     */
    public static Object invoke(String className, String methodName, Object... args) {
        try {
            Class<?> aClass = Class.forName(className);
            Method method = aClass.getDeclaredMethod(methodName, MappedByteBuffer.class);
            method.setAccessible(true);
            return method.invoke(aClass, args);
        } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException
                 | IllegalAccessException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}

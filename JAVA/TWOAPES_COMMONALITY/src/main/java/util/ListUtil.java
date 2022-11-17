package util;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * list copy
 */
@Slf4j
public class ListUtil {

    /**
     * @param src src
     * @param <T> T
     * @return copy
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> listCopy(List<T> src) {
        try (ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(byteOut);
             ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
             ObjectInputStream in = new ObjectInputStream(byteIn)) {
            out.writeObject(src);
            return (List<T>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }

        return new ArrayList<>();
    }
}

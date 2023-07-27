package core.sftp;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author add by huyingzhao
 *         2022-06-06 23:00
 */
public interface SftpService {
    /**
     * open server
     */
    void open();

    /**
     * close server
     */
    void close();

    /**
     * is connected success
     *
     * @return isConnected
     * @author add by huyingzhao
     * 2022-06-06 23:07
     */
    boolean isConnected();

    /**
     * is directory exists
     *
     * @param path path
     * @return exists
     * @author add by huyingzhao
     * 2022-06-06 23:07
     */
    boolean exists(String path);

    /**
     * is created directory
     * @author method add by huyingzhao
     * 2022-10-13 16:28
     * @param path path
     * @return mkdir
     */
    boolean mkdir(String path);

    /**
     * uploadFile=basePath+directory
     * @param file      file
     * @param directory directory
     * @param name      name
     * @return upload
     */
    boolean upload(File file, String directory, String name);

    /**
     * download a file
     * @author method add by huyingzhao
     * 2022-10-13 16:30
     * @param file file
     * @param save save
     * @param name name
     * @return download
     */
    boolean download(File file, String save, String name);

    /**
     * delete a directory
     * @param directory directory
     * @return delete
     */
    boolean delete(String directory);

    /**
     * delete a file
     * @param directory directory
     * @param fileName  fileName
     * @return delete
     * @author add by huyingzhao
     * 2022-06-06 23:05
     */
    boolean delete(String directory, String fileName);

    /**
     * rename as file
     * @author method add by huyingzhao
     * 2022-10-13 16:33
     * @param directory directory
     * @param oldName oldName
     * @param newName newName
     * @return rename
     */
    boolean rename(String directory, String oldName, String newName);

    /**
     * list for directory
     * @author method add by huyingzhao
     * 2022-10-13 16:34
     * @param directory directory
     * @param is is
     * @return listFiles
     */
    List<Map<String, Object>> listFiles(String directory, boolean is);
}
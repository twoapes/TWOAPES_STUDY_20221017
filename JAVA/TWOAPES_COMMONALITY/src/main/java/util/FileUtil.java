package util;

import enums.FileEnum;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author add by huyingzhao
 * 2022-05-27 22:23
 * only file
 */
@Slf4j
public class FileUtil extends Document {
    /**
     * file/directory list
     *
     * @param file file
     * @return directorList
     * @author method add by huyingzhao
     * 2022-10-13 14:40
     */
    public static Map<String, List<File>> directorList(File file) {
        Map<String, List<File>> map = new HashMap<>();
        if (file == null || !file.isDirectory()) {
            return map;
        }

        getDirectorList(file);
        map.put(FileEnum.FILE_LIST.value(), fileList);
        map.put(FileEnum.DIRECTORY_LIST.value(), directoryList);
        return map;
    }

    /**
     * file execute(only txt) for String
     *
     * @param file    file
     * @param charset charset
     * @return readerStringFile
     * @author method add by huyingzhao
     * 2022-10-13 14:41
     */
    public static String readerStringFile(File file, Charset charset) {
        if (file == null || !file.isFile() || !file.canRead() || file.length() == 0) {
            return "";
        }

        return readString(file, charset);
    }

    /**
     * file execute(only txt) for List
     *
     * @param file    file
     * @param charset charset
     * @return readerStringFileLine
     */
    public static List<String> readerStringFileLine(File file, Charset charset) {
        List<String> strings = new ArrayList<>();
        if (file == null || !file.isFile() || !file.canRead() || file.length() == 0) {
            return strings;
        }

        strings = readList(file, charset);
        return strings;
    }

    /**
     * delete dirs
     *
     * @param file   file
     * @param isRoot isRoot
     */
    public static void deleteDirs(File file, boolean isRoot) {
        if (file == null || !file.isDirectory()) {
            return;
        }

        deleteCatalogs(file, isRoot);
    }

    /**
     * delete file
     *
     * @param file file
     */
    public static void delete(File file) {
        if (file == null || !file.isFile()) {
            return;
        }

        deleteFile(file);
    }

    /**
     * MD5 SHA1
     *
     * @param algorithm algorithm
     * @param file      file
     * @return getFileMd5
     */
    public static String getFileMd5(File file, FileEnum algorithm) {
        if (file == null || !file.isFile()) {
            return "";
        }

        if (!(FileEnum.MD5.name().equals(algorithm.name())
                || FileEnum.MD2.name().equals(algorithm.name())
                || FileEnum.SHA1.name().equals(algorithm.name())
                || FileEnum.SHA_384.name().equals(algorithm.name()))) {
            return "";
        }

        String md = "encryption:" + algorithm + ",file(" + file.getName() + ")";
        String value = "";
        long begin = System.currentTimeMillis();
        try (FileInputStream in = new FileInputStream(file)) {
            byte[] bytes = toDigest(in, algorithm.name(), file);
            if (bytes.length != 0) {
                BigInteger bi = new BigInteger(1, bytes);
                value = bi.toString(16);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            ComputerUtil.end(begin, md+"-statics.FileUtil.getFileMd5");
        }
        return value;
    }

    /**
     * file/directory property
     *
     * @param file file
     * @return property
     */
    public static Map<String, Object> property(File file) {
        Map<String, Object> map = new HashMap<>();
        if (file == null) {
            return map;
        }

        if (file.isFile()) {
            String name = file.getName();
            map.put(FileEnum.FILE_NAME.value(), name);
            if (name.contains(".")) {
                String nameSt = (name.substring(name.lastIndexOf('.') + 1));
                map.put(FileEnum.FILE_TYPE.value(), nameSt.toUpperCase() + " file(." + nameSt + ")");
            } else {
                map.put(FileEnum.FILE_TYPE.value(), "file");
            }

            map.put(FileEnum.FILE_POSITION.value(), file.getParent());
            map.put(FileEnum.FILE_LONG_SIZE.value(), file.length());
            map.put(FileEnum.FILE_SIZE.value(),
                    ComputerUtil.unit(BigDecimal.valueOf(file.length())) + "(" + file.length() + "字节)");
            map.put(FileEnum.FILE_CONTAIN.value(), "");
            map.put(FileEnum.FILE_READ.value(), file.canRead());
            map.put(FileEnum.FILE_WRITE.value(), file.canWrite());
            map.put(FileEnum.FILE_HIDDEN.value(), file.isHidden());
            map.put(FileEnum.FILE_LAST_MODIFIED.value(), file.lastModified());
        } else if (file.isDirectory()) {
            getDirectorList(file);
            BigDecimal bigDecimal = BigDecimal.valueOf(0);
            for (File file1 : fileList) {
                bigDecimal = bigDecimal.add(BigDecimal.valueOf(file1.length()));
            }

            map.put(FileEnum.FILE_NAME.value(), file.getName());
            map.put(FileEnum.FILE_TYPE.value(), "folder");
            map.put(FileEnum.FILE_POSITION.value(), file.getParent());
            map.put(FileEnum.FILE_LONG_SIZE.value(), bigDecimal);
            map.put(FileEnum.FILE_SIZE.value(), ComputerUtil.unit(bigDecimal) + "(" + bigDecimal + " byte)");
            map.put(FileEnum.FILE_CONTAIN.value(), fileList.size() + " file," + directoryList.size() + " folder");
            map.put(FileEnum.FILE_READ.value(), file.canRead());
            map.put(FileEnum.FILE_WRITE.value(), file.canWrite());
            map.put(FileEnum.FILE_HIDDEN.value(), file.isHidden());
            map.put(FileEnum.FILE_LAST_MODIFIED.value(), file.lastModified());
        }

        return map;
    }

    /**
     * file create
     *
     * @param file file
     * @return fileCreate
     */
    public static Map<String, Object> fileCreate(File file) {
        Map<String, Object> map = new HashMap<>();

        if (file == null || file.exists() || file.isFile()) {
            return map;
        }

        if (file.mkdirs()) {
            log.info("directory [{}] crate success",file.getPath());
            return property(file);
        } else {
            return map;
        }
    }

    /**
     * create file and content
     * if file not exist,create first write later
     *
     * @param file    file
     * @param charset charset
     * @param content content
     * @return fileCreate
     */
    public static Map<String, Object> fileCreate(File file, Charset charset, String content) {
        Map<String, Object> map = new HashMap<>();
        if (file == null || content == null || content.trim().isEmpty()) {
            return map;
        }

        File parentFile = file.getParentFile();
        try {
            if (file.exists()) {
                BasicFileAttributes basicFileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                if (basicFileAttributes.isRegularFile()) {
                    if (basicFileAttributes.size() > 0) {
                        readWrite(file, content, charset);
                        return property(file);
                    } else {
                        return map;
                    }
                } else {
                    log.error("[" + file.getPath() + "]file fail");
                }
            } else {
                if (parentFile.isDirectory()) {
                    if (file.createNewFile()) {
                        readWrite(file, content, charset);
                    } else {
                        log.error("[" + file.getPath() + "]create fail");
                    }
                } else {
                    if (parentFile.mkdirs()) {
                        if (file.createNewFile()) {
                            readWrite(file, content, charset);
                        } else {
                            log.error("[" + file.getPath() + "]create fail");
                        }
                    } else {
                        log.error("[" + parentFile.getPath() + "]create fail");
                    }
                }
            }

            return property(file);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return map;
        }
    }

    /**
     * split out of the file
     *
     * @param file    file
     * @param top     top
     * @param end     end
     * @param size    size
     * @param charset charset
     * @return split
     */

    public static List<Map<String, Object>> split(File file, String top, String end, int size, Charset charset) {
        List<Map<String, Object>> listMap = new ArrayList<>();
        if (file == null || top == null || end == null || !file.isFile() || file.length() == 0 || size <= 0) {
            return listMap;
        }

        StringBuilder stringBuilder = new StringBuilder("\n");
        Map<String, Object> map = property(file);
        if (file.isFile() && size <= 20 && file.length() > 0) {
            top = top + "\n";
            String name = (String) map.get(FileEnum.FILE_NAME.name());
            String path = file.getParent();
            List<String> strings = readerStringFileLine(file, charset);
            if (strings.size() >= size) {
                int count = 0;
                int fileSize = 0;
                int split = strings.size() / size;
                for (String s : strings) {
                    if (++count == split && fileSize < size - 1) {
                        stringBuilder.append(s).append("\n");
                        File subFile = new File(path, "[" + ++fileSize + "]_" + name);
                        if (fileSize == 1) {
                            listMap.add(fileCreate(subFile, charset, stringBuilder + end));
                        } else if (fileSize == size - 1) {
                            listMap.add(fileCreate(subFile, charset, top + stringBuilder));
                        } else {
                            listMap.add(fileCreate(subFile, charset, top + stringBuilder + end));
                        }
                        stringBuilder.setLength(0);
                        count = 0;
                    } else {
                        stringBuilder.append(s).append("\n");
                    }
                }

                if (stringBuilder.length() > 0) {
                    File subFile = new File(path, "[" + ++fileSize + "]_" + name);
                    listMap.add(fileCreate(subFile, charset, top + stringBuilder));
                    stringBuilder.setLength(0);
                }

                log.info("split success: {}",listMap);
            } else {
                log.error("split max size :" + strings.size());
            }
        }
        return listMap;
    }
}

/**
 * @author add by huyingzhao
 * 2022-01-31 23:46:53
 */
@Slf4j
class Document {
    static List<File> directoryList = new ArrayList<>();
    static List<File> fileList = new ArrayList<>();

    static void getDirectorList(File file) {
        fileList.clear();
        directoryList.clear();
        all(file);
    }

    /**
     * delete for catalogs
     *
     * @param file   file
     * @param isRoot isRoot
     */
    static void deleteCatalogs(File file, boolean isRoot) {
        if (file != null && file.isDirectory()) {
            deleteFolders(file);
            if (isRoot) {
                if (!file.delete()) {
                    log.error("directory [{}] delete fail",file.getPath());
                } else {
                    log.info("directory [{}] delete success",file.getPath());
                }
            }
        }
    }

    /**
     * if file exist write it
     *
     * @param file    file
     * @param content content
     * @param charset charset
     */
    static void readWrite(File file, String content, Charset charset) {
        if (file.canWrite() && file.canRead()) {
            if (file.renameTo(file)) {
                try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                    fileOutputStream.flush();
                    fileOutputStream.write(content.getBytes(charset));
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                } finally {
                    log.info("file [{}] write success",file.getPath());
                }
            } else {
                log.error("file [{}] write error",file.getPath());
            }
        } else {
            log.error("file [{}] error",file.getPath());
        }
    }

    /**
     * read for list
     *
     * @param file    file
     * @param charset charset
     * @return readList
     */
    static List<String> readList(File file, Charset charset) {
        List<String> list = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(file);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, charset);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader, 524288000)) {
            String read;
            while ((read = bufferedReader.readLine()) != null) {
                list.add(read);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return list;
    }

    /**
     * read for String
     *
     * @param file    file
     * @param charset charset
     * @return readString
     */
    static String readString(File file, Charset charset) {
        StringBuilder stringBuilder = new StringBuilder("\n");
        String read;
        // 改成try-with-resource
        try (FileInputStream fileInputStream = new FileInputStream(file);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, charset);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader, 524288000)) {
            while ((read = bufferedReader.readLine()) != null) {
                stringBuilder.append(read).append("\n");
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return stringBuilder.toString();
    }

    /**
     * delete file
     *
     * @param file file
     */
    static void deleteFile(File file) {
        if (file != null && file.isFile()) {
            if (!file.delete()) {
                log.error("file [{}] delete fail",file.getPath());
            } else {
                log.info("file [{}] delete success",file.getPath());
            }
        } else {
            log.error("file is not null and must exist");
        }
    }

    /**
     * covert the byte to a 6 digit ciphertext
     *
     * @param in        in
     * @param algorithm algorithm
     * @param file      file
     * @return toDigest
     */
    static byte[] toDigest(FileInputStream in, String algorithm, File file) {
        MappedByteBuffer byteBuffer = null;
        try (FileChannel fileChannel = in.getChannel()) {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            byteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            messageDigest.update(byteBuffer);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException | IOException e) {
            log.error(e.getMessage(), e);
            return new byte[0];
        } finally {
            if (byteBuffer != null) {
                byteBuffer.clear();
                //free the memory
                Object o = ClassUtil.invoke("sun.nio.ch.FileChannelImpl", "unmap", byteBuffer);
                if (o != null) {
                    log.info("o: {}",o);
                }
            }
        }
    }

    /**
     * clear folders
     *
     * @param folder folder
     */
    private static void deleteFolders(File folder) {
        getDirectorList(folder);
        for (File file : fileList) {
            if (!file.delete()) {
                log.error("file [{}] clear fail",file.getPath());
            } else {
                log.info("file [{}] clear success",file.getPath());
            }
        }
        Collections.reverse(directoryList);
        for (File file : directoryList) {
            if (!file.delete()) {
                log.error("directory [{}] clear fail",file.getPath());
            } else {
                log.info("directory [{}] clear success",file.getPath());
            }
        }
    }

    /**
     * foreach for all(file and directory)
     */
    private static void all(File file) {
        File[] directories = null;
        if (file != null)
            directories = file.listFiles();
        if (directories != null && directories.length > 0)
            for (File directory : directories) {
                if (directory.isFile()) {
                    fileList.add(directory);
                } else if (directory.isDirectory()) {
                    directoryList.add(directory);
                    all(directory);
                }
            }
    }
}

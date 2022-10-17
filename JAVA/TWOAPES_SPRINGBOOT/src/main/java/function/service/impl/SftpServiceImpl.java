package function.service.impl;

import com.jcraft.jsch.*;
import domain.SftpDo;
import enums.SftpEnum;
import function.service.SftpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

/**
 * @author add by huyingzhao
 * 2022-10-13 10:13
 */
@Slf4j
@Service
public class SftpServiceImpl extends SSH implements SftpService {
    @Autowired
    private SftpDo sftpDo;

    public SftpServiceImpl() {
        super.sftpDo = sftpDo;
    }

    /**
     * is connected success
     *
     * @return isConnected
     * @author add by huyingzhao
     * 2022-06-06 23:07
     */
    public boolean isConnected() {
        return sftp == null || !sftp.isConnected();
    }

    /**
     * is directory exists
     *
     * @param path path
     * @return exists
     * @author add by huyingzhao
     * 2022-06-06 23:07
     */
    public boolean exists(String path) {
        try {
            return exists(sftp, path);
        } catch (SftpException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    /**
     * is created directory
     *
     * @param path path
     * @return mkdir
     * @author add by huyingzhao
     * 2022-06-06 23:06
     */
    public boolean mkdir(String path) {
        path = directory(path);
        try {
            boolean is = exists(sftp, path);
            if (!is)
                is = mark(path);
            return is;
        } catch (SftpException e) {
            return mark(path);
        }
    }

    /**
     * uploadFile=basePath+directory
     *
     * @param file      file
     * @param directory directory
     * @param name      name
     * @return upload
     */
    public boolean upload(File file, String directory, String name) {
        boolean result = false;
        if (isConnected()) {
            return false;
        }

        try (InputStream inputStream = new FileInputStream(file)) {
            if (exists(sftp, directory)) {
                if (file.isFile() && file.canRead()) {
                    directory = directory(directory);

                    sftp.cd(directory);
                    sftp.put(inputStream, name);
                    result = true;
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            log.info("file[" + file.getPath() + "]upload");
        }
        return result;
    }

    /**
     * download a file
     *
     * @param file file
     * @param save save
     * @param name name
     * @return download
     * @author method add by huyingzhao
     * 2022-10-13 16:30
     */
    public boolean download(File file, String save, String name) {
        if (isConnected()) {
            return false;
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(save, name))) {
            String directory = directory(file.getParent());
            if (exists(sftp, directory)) {
                sftp.cd(directory);
                sftp.get(file.getName(), fileOutputStream);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        } finally {
            log.info("file[" + file.getPath() + "]download");
        }
    }

    /**
     * delete a directory
     *
     * @param directory directory
     * @return delete
     */
    public boolean delete(String directory) {
        try {
            if (isConnected()) {
                return false;
            }

            if (exists(sftp, directory)) {
                sftp.cd(directory);
                sftp.rmdir(directory);
                return true;
            } else {
                return false;
            }
        } catch (SftpException e) {
            log.error(e.getMessage(), e);
            return false;
        } finally {
            log.info("directory[" + directory + "]delete");
        }
    }

    /**
     * delete a file
     *
     * @param directory directory
     * @param fileName  fileName
     * @return delete
     * @author add by huyingzhao
     * 2022-06-06 23:05
     */
    public boolean delete(String directory, String fileName) {
        try {
            if (isConnected()) {
                return false;
            }

            if (exists(sftp, directory)) {
                directory = directory(directory);
                sftp.cd(directory);
                sftp.rm(fileName);
                return true;
            } else {
                return false;
            }
        } catch (SftpException e) {
            log.error(e.getMessage(), e);
            return false;
        } finally {
            log.info("file[" + fileName + "]delete");
        }
    }

    /**
     * rename as file
     *
     * @param directory directory
     * @param oldName   oldName
     * @param newName   newName
     * @return rename
     * @author method add by huyingzhao
     * 2022-10-13 16:33
     */
    public boolean rename(String directory, String oldName, String newName) {
        try {
            if (isConnected()) {
                return false;
            }

            if (exists(sftp, directory)) {
                directory = directory(directory);
                sftp.cd(directory);
                sftp.rename(oldName, newName);
                return true;
            } else {
                return false;
            }
        } catch (SftpException e) {
            log.error(e.getMessage(), e);
            return false;
        } finally {
            log.info("file[" + oldName + "]rename");
        }
    }

    /**
     * list for directory
     *
     * @param directory directory
     * @param is        is
     * @return listFiles
     * @author method add by huyingzhao
     * 2022-10-13 16:34
     */
    public List<Map<String, Object>> listFiles(String directory, boolean is) {
        List<Map<String, Object>> hashMap = new ArrayList<>();
        try {
            if (isConnected()) {
                return hashMap;
            }
            if (exists(sftp, directory)) {
                directory = directory(directory);
                files(hashMap, directory, is);
            }
        } catch (SftpException e) {
            log.error(e.getMessage(), e);
        } finally {
            log.info("directory[" + directory + "]");
        }

        return hashMap;
    }
}

/**
 * @author huyingzhao
 * 2022-01-31 23:10:24
 */
@Slf4j
class SSH {
    SftpDo sftpDo;
    ChannelSftp sftp;
    Session session;
    Channel channel;

    public void open() {
        try {
            if ((session == null || channel == null || !channel.isConnected()) && (sftpDo.getSftpUserName() != null
                    && sftpDo.getSftpHost() != null && sftpDo.getSftpPort() != null)) {
                JSch jsch = new JSch();

                if (sftpDo.getSftpPrivateKey() == null || !sftpDo.getSftpPrivateKey().equals("null")) {
                    jsch.addIdentity(sftpDo.getSftpPrivateKey());
                }

                session = jsch.getSession(sftpDo.getSftpUserName(), sftpDo.getSftpHost(),
                        Integer.parseInt(sftpDo.getSftpPort()));
                session.setPassword(sftpDo.getSftpPassword());
                Properties config = new Properties();
                config.put("StrictHostKeyChecking", "no");
                config.put("kex",
                        "Ciphers aes128-cbc,aes256-cbc,aes256-ctr,3des-cbc,arcfour128,arcfour256,arcfour,blowfish-cbc,cast128-cbc\n"
                                +
                                "MACs hmac-md5,hmac-sha1,umac-64@openssh.com,hmac-ripemd160,hmac-sha1-96,hmac-md5-96\n"
                                +
                                "KexAlgorithms diffie-hellman-group1-sha1,diffie-hellman-group14-sha1,diffie-hellman-group-exchange-sha1,diffie-hellman-group-exchange-sha256,ecdh-sha2-nistp256,ecdh-sha2-nistp384,ecdh-sha2-nistp521,diffie-hellman-group1-sha1,curve25519-sha256@libssh.org");
                session.setConfig(config);
                session.connect();
                channel = session.openChannel("sftp");
                channel.connect();
                sftp = (ChannelSftp) channel;
            }
        } catch (JSchException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * close server
     */
    public void close() {
        if (sftp != null && sftp.isConnected()) {
            sftp.disconnect();
        } else {
            log.debug("sftp closed");
        }

        if (session != null && session.isConnected()) {
            session.disconnect();
        } else {
            log.debug("session closed");
        }

        if (channel != null && channel.isConnected()) {
            channel.disconnect();
        } else {
            log.debug("channel closed");
        }
    }

    /**
     * is existed file/directory
     *
     * @param channelSftp channelSftp
     * @param path        path
     */
    boolean exists(ChannelSftp channelSftp, String path) throws SftpException {
        try {
            if (channelSftp == null || path == null) {
                return false;
            }

            if (channelSftp.isConnected()) {
                path = directory(path);
                sftp.cd(path);
                return true;
            } else {
                return false;
            }
        } catch (SftpException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    /**
     * list for file
     *
     * @param hashMaps  hashMaps
     * @param directory directory
     * @param is        is
     */
    void files(List<Map<String, Object>> hashMaps, String directory, boolean is) throws SftpException {
        Vector<?> vector = sftp.ls(directory);
        for (Object o : vector) {
            if (o instanceof ChannelSftp.LsEntry) {
                ChannelSftp.LsEntry lsEntry = (ChannelSftp.LsEntry) o;
                if (is) {
                    getChannelSftp(hashMaps, directory, true, lsEntry);
                } else {
                    if (isFile(lsEntry.getFilename())) {
                        getChannelSftp(hashMaps, directory, false, lsEntry);
                    }
                }
            }
        }
    }

    /**
     * get a ChannelSftp
     *
     * @param directory directory
     * @param is        is
     * @param lsEntry   lsEntry
     * @throws SftpException SftpException
     */

    void getChannelSftp(List<Map<String, Object>> hashMaps, String directory, boolean is, ChannelSftp.LsEntry lsEntry)
            throws SftpException {
        Map<String, Object> hashMap = new HashMap<>();
        SftpATTRS sftpATTRS = lsEntry.getAttrs();
        hashMap.put(SftpEnum.SFTP_PATH.value(), directory + "/" + lsEntry.getFilename());
        if (sftpATTRS.toString().startsWith("-")) {
            // file
            hashMap.put(SftpEnum.SFTP_POSITION.value(), directory + "/");
            hashMap.put(SftpEnum.SFTP_NAME.value(), lsEntry.getFilename());
            hashMap.put(SftpEnum.SFTP_UPDATE_TIME.value(), sftpATTRS.getMTime() * 1000L);
            hashMap.put(SftpEnum.SFTP_SIZE.value(), sftpATTRS.getSize());
            hashMap.put(SftpEnum.SFTP_TYPE.value(), "file");
            hashMaps.add(hashMap);
        } else if (sftpATTRS.toString().startsWith("d")) {
            // directory
            hashMap.put(SftpEnum.SFTP_POSITION.value(), directory + "/");
            hashMap.put(SftpEnum.SFTP_NAME.value(), lsEntry.getFilename());
            hashMap.put(SftpEnum.SFTP_UPDATE_TIME.value(), sftpATTRS.getMTime() * 1000L);
            hashMap.put(SftpEnum.SFTP_SIZE.value(), sftpATTRS.getSize());
            hashMap.put(SftpEnum.SFTP_TYPE.value(), "directory");
            hashMaps.add(hashMap);
            if (is) {
                if (isFile(lsEntry.getFilename()))
                    files(hashMaps, directory + "/" + lsEntry.getFilename(), true);
            } else {
                files(hashMaps, directory + "/" + lsEntry.getFilename(), false);
            }
        }
    }

    /**
     * @return is file/folder
     */
    boolean isFile(String fileName) {
        return !(fileName.equals(".") || fileName.equals("..")) && !fileName.startsWith(".");
    }

    /**
     * @param directory directory
     * @return directory a directory
     */
    String directory(String directory) {
        if (directory.contains("\\")) {
            directory = directory.replace("\\", "/");
        }

        if (directory.equals("/"))
            return directory;
        if (directory.endsWith("/")) {
            directory = directory.substring(0, directory.length() - 1);
        }
        return directory;
    }

    /**
     * create directory
     *
     * @param path path
     */
    boolean mark(String path) {
        try {
            sftp.mkdir(path);
            log.info("create directory[" + path + "]success");
            return true;
        } catch (SftpException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }
}

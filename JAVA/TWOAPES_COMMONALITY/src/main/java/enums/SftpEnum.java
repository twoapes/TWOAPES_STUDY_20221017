package enums;
/**
 * sftp execute
 * @author add by huyingzhao
 * 2022-09-25 11:37
 */
public enum SftpEnum {
    /*
     * file path
     */
    SFTP_PATH("path"),
    /*
     * file in the position
     */
    SFTP_POSITION("position"),
    /*
     * file/directory name
     */
    SFTP_NAME("name"),
    /*
     * update time
     */
    SFTP_UPDATE_TIME("updateTime"),
    /*
     * type
     */
    SFTP_TYPE("type"),
    /*
     * size
     */
    SFTP_SIZE("size"),
    ;

    /*
     * value
     */
    private final String value;

    /**
     * SftpEnum
     * @param value value
     */
    SftpEnum(String value) {
        this.value = value;
    }

    /**
     * value
     */
    public String value() {
        return value;
    }
}

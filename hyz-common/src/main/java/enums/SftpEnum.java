package enums;
/**
 * sftp execute
 * @author add by huyingzhao
 * 2022-09-25 11:37
 */
public enum SftpEnum {
    SFTP_PATH("path"),//file path
    SFTP_POSITION("position"),//file in the position
    SFTP_NAME("name"),//file/directory name
    SFTP_UPDATE_TIME("updateTime"),//update time
    SFTP_TYPE("type"),//type
    SFTP_SIZE("size"),//size
    ;

    private final String value;

    SftpEnum(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}

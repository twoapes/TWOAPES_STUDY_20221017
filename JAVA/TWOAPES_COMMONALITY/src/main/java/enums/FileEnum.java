package enums;

/**
 * file enum
 * @author add by huyingzhao
 * 2022-09-25 11:37
 */
public enum FileEnum{
    /*
     * file list
     */
    FILE_LIST("fileList"),
    /*
     * directory list
     */
    DIRECTORY_LIST("directory_list"),
    /*
     * file/directory name
     */
    FILE_NAME("name"),
    /*
     * file type
     */
    FILE_TYPE("type"),
    /*
     * file in the position
     */
    FILE_POSITION("position"),
    /*
     * file/directory size(no unit)
     */
    FILE_LONG_SIZE("longSize"),
    /*
     * file/directory size
     */
    FILE_SIZE("size"),
    /*
     * file/directory count
     */
    FILE_CONTAIN("contain"),
    /*
     * is reading
     */
    FILE_READ("read"),
    /*
     * is writing
     */
    FILE_WRITE("write"),
    /*
     * is hidden
     */
    FILE_HIDDEN("hidden"),
    /*
     * lastModified
     */
    FILE_LAST_MODIFIED("lastModified"),
    /*
     * MD5 encryption
     */
    MD5("MD5"),
    /*
     * SHA1 encryption
     */
    SHA1("SHA1"),
    /*
     * SHA1 encryption
     */
    SHA_384("SHA-384"),
    /*
     * MD2 encryption
     */
    MD2("MD2"),
    ;

    /*
     * value
     */
    private final String value;

    /**
     * FileEnum
     * @param value value
     */
    FileEnum(String value) {
        this.value = value;
    }

    /**
     * @return value
     */
    public String value() {
        return value;
    }
}

package enums;

/**
 * file enum
 * @author add by huyingzhao
 * 2022-09-25 11:37
 */
public enum FileEnum{
    FILE_LIST("fileList"),//file list
    DIRECTORY_LIST("directory_list"),//directory list
    FILE_NAME("name"),//file/directory name
    FILE_TYPE("type"),//file type
    FILE_POSITION("position"),//file in the position
    FILE_LONG_SIZE("longSize"),//file/directory size(no unit)
    FILE_SIZE("size"),//file/directory size
    FILE_CONTAIN("contain"),//file/directory count
    FILE_READ("read"),//is reading
    FILE_WRITE("write"),//is writing
    FILE_HIDDEN("hidden"),//is hidden
    FILE_LAST_MODIFIED("lastModified"),//lastModified

    MD5("MD5"),//MD5 encryption
    SHA1("SHA1"),//SHA1 encryption
    SHA_384("SHA-384"),//SHA1 encryption
    MD2("MD2"),//MD2 encryption
    ;

    private final String value;

    /**
     * @param value value
     */
    FileEnum(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}

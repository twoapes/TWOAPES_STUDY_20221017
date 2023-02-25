package enums;

/**
 * GBT7408-2005
 * Data elements and interchange formats- Information interchange-Representation of dates and times
 * @author add by huyingzhao
 * 2022-07-02 12:51
 */
public enum ISO8601 {
    YYYY_MM_DD_HE_HMS_S_S("yyyy-MM-dd HH:mm:ss SSS"),
    ;
    private final String value;

    ISO8601(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
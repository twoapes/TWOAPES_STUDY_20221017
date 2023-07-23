package enums;

/**
 * GBT7408-2005
 * Data elements and interchange formats- Information interchange-Representation of dates and times
 *
 * @author add by huyingzhao
 * 2022-07-02 12:51
 */
public enum ISO8601 {
    YYYY_MM_DD_UEE_HMS("yyyy_MM_dd(HH_mm_ss)"),
    YYYY_MM_DD_UE_HMS("yyyy_MM_dd HH:mm:ss"),
    YYYY_MM_DD_UE_HM("yyyy_MM_dd HH:mm"),
    YYYY_MM_DD_UE("yyyy_MM_dd"),

    YYYY_MM_DD_HMS("yyyy/MM/dd HH:mm:ss"),
    YYYY_MM_DD_HM("yyyy/MM/dd HH:mm"),
    YYYY_MM_DD("yyyy/MM/dd"),

    YYYY_MM_DD_HE_HMS_SSS("yyyy-MM-dd HH:mm:ss SSS"),
    YYYY_MM_DD_HE_HMS("yyyy-MM-dd HH:mm:ss"),
    YYYY_MM_DD_HE_HM("yyyy-MM-dd HH:mm"),
    YYYY_MM_DD_HE("yyyy-MM-dd"),

    YYYYMMDD_HMS("yyyyMMdd HH:mm:ss"),
    YYYYMMDD_HM("yyyyMMdd HH:mm"),
    YYYYMMDDHMS("yyyyMMddHHmmss"),
    YYYYMMDDHM("yyyyMMddHHmm"),
    YYYYMMDD("yyyyMMdd"),
    DD_HMS("dd HH:mm:ss"),

    EEE_DD_MMM_YYYY_HH_MM_SS_Z("EEE, dd MMM yyyy HH:mm:ss z"),
    ;
    private final String value;

    ISO8601(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
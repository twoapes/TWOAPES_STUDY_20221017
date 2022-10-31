package enums;

/**
 * GBT7408-2005
 * Data elements and interchange formats- Information interchange-Representation of dates and times
 * @author add by huyingzhao
 * 2022-07-02 12:51
 */
public enum ISO8601 {
    /*
     * yyyy/MM/dd
     */
    YYYY_MM_DD("yyyy/MM/dd"),
    /*
     * yyyy/MM/dd HH:mm:ss
     */
    YYYY_MM_DD_HMS("yyyy/MM/dd HH:mm:ss"),
    /*
     * yyyy/MM/dd HH:mm
     */
    YYYY_MM_DD_HM("yyyy/MM/dd HH:mm"),
    /*
     * yyyy_MM_dd
     */
    YYYY_MM_DD_UE("yyyy_MM_dd"),
    /*
     * yyyy_MM_dd HH:mm:ss
     */
    YYYY_MM_DD_UE_HMS("yyyy_MM_dd HH:mm:ss"),
    /*
     * yyyy_MM_dd HH:mm
     */
    YYYY_MM_DD_UE_HM("yyyy_MM_dd HH:mm"),
    /*
     * yyyy-MM-dd
     */
    YYYY_MM_DD_HE("yyyy-MM-dd"),
    /*
     * yyyy-MM-dd HH:mm:ss
     */
    YYYY_MM_DD_HE_HMS("yyyy-MM-dd HH:mm:ss"),
    /*
     * yyyy-MM-dd HH:mm:ss SSS
     */
    YYYY_MM_DD_HE_HMS_S_S("yyyy-MM-dd HH:mm:ss SSS"),
    /*
     * yyyy-MM-dd HH:mm
     */
    YYYY_MM_DD_HE_HM("yyyy-MM-dd HH:mm"),
    /*
     * yyyyMMdd
     */
    YYYYMMDD("yyyyMMdd"),
    /*
     * yyyyMMdd HH:mm:ss
     */
    YYYYMMDD_HMS("yyyyMMdd HH:mm:ss"),
    /*
     * yyyyMMddHHmmss
     */
    YYYYMMDD_HMS_UN("yyyyMMddHHmmss"),
    /*
     * yyyyMMdd HH:mm
     */
    YYYYMMDD_HM("yyyyMMdd HH:mm"),
    /*
     * dd HH:mm:ss
     */
    DD_HMS("dd HH:mm:ss"),
    /*
     * yyyy_MM_dd
     */
    UNDERLINE("yyyy_MM_dd"),
    /*
     * yyyy_MM_dd(HH_mm_ss)
     */
    UNDERLINE24("yyyy_MM_dd(HH_mm_ss)"),
    /*
     * EEE, dd MMM yyyy HH:mm:ss z
     */
    EEE_DD_MMM_YYYY_HH_MM_SS_Z("EEE, dd MMM yyyy HH:mm:ss z"),
    ;
    /*
     * value
     */
    private final String value;

    /**
     * ISO8601
     * @param value
     */
    ISO8601(String value) {
        this.value = value;
    }

    /**
     * value
     */
    public String value() {
        return value;
    }

    /**
     * @param type type
     * @return ISO8601
     * @author add by huyingzhao
     * 2022-07-02 14:02
     */
    public static ISO8601 iso8601(String type) {
        ISO8601 iso8601 = null;
        if (type.equals(ISO8601.YYYY_MM_DD.value())) {
            iso8601 = ISO8601.UNDERLINE;
        } else if (type.equals(ISO8601.YYYY_MM_DD_HMS.value())) {
            iso8601 = ISO8601.YYYY_MM_DD_HMS;
        } else if (type.equals(ISO8601.YYYY_MM_DD_HM.value())) {
            iso8601 = ISO8601.YYYY_MM_DD_HM;
        } else if (type.equals(ISO8601.YYYY_MM_DD_UE.value())) {
            iso8601 = ISO8601.YYYY_MM_DD_UE;
        } else if (type.equals(ISO8601.YYYY_MM_DD_UE_HMS.value())) {
            iso8601 = ISO8601.YYYY_MM_DD_UE_HMS;
        } else if (type.equals(ISO8601.YYYY_MM_DD_UE_HM.value())) {
            iso8601 = ISO8601.YYYY_MM_DD_UE_HM;
        } else if (type.equals(ISO8601.YYYY_MM_DD_HE.value())) {
            iso8601 = ISO8601.YYYY_MM_DD_HE;
        } else if (type.equals(ISO8601.YYYY_MM_DD_HE_HMS.value())) {
            iso8601 = ISO8601.YYYY_MM_DD_HE_HMS;
        } else if (type.equals(ISO8601.YYYY_MM_DD_HE_HM.value())) {
            iso8601 = ISO8601.YYYY_MM_DD_HE_HM;
        } else if (type.equals(ISO8601.YYYYMMDD.value())) {
            iso8601 = ISO8601.YYYYMMDD;
        } else if (type.equals(ISO8601.YYYYMMDD_HMS.value())) {
            iso8601 = ISO8601.YYYYMMDD_HMS;
        } else if (type.equals(ISO8601.YYYYMMDD_HMS_UN.value())) {
            iso8601 = ISO8601.YYYYMMDD_HMS_UN;
        } else if (type.equals(ISO8601.YYYYMMDD_HM.value())) {
            iso8601 = ISO8601.YYYYMMDD_HM;
        } else if (type.equals(ISO8601.UNDERLINE.value())) {
            iso8601 = ISO8601.UNDERLINE;
        } else if (type.equals(ISO8601.UNDERLINE24.value())) {
            iso8601 = ISO8601.UNDERLINE24;
        }

        return iso8601;
    }
}
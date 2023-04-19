package enums;

/**
 * database execute
 *
 * @author add by huyingzhao
 * 2022-09-25 11:37
 */
public enum JdbcEnum {
    //database type
    ORACLE, POSTGRES, MYSQL, SQL_SERVER2005, SQL_SERVER2000, DB2, SYBASE,
    /*
    database order
    ORIGINAL_DATA:only metadata
    DATA:date
    DATA:skip BLOB/CLOB
     */
    ORIGINAL_DATA, DATA, SKIP,
    //column type
    DATE, BLOB, CLOB, NUMBER, TIMESTAMP, LONG, CHAR, VARCHAR2, VARCHAR,
}

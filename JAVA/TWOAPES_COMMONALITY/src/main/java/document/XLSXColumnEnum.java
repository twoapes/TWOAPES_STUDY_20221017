package document;

import enums.ISO8601Enum;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author add by huyingzhao
 *         2022-10-13 13:51
 *         only for column
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface XLSXColumnEnum {
    /**
     * 
     * @return column name
     * @author add by huyingzhao
     *         2022-10-24 14:51
     */
    String name();

    /**
     * 
     * @return row index
     * @author add by huyingzhao
     *         2022-10-24 14:51
     */
    int index();

    /**
     * 
     * @return row wight
     * @author add by huyingzhao
     *         2022-06-27 9:59
     */
    double wight() default 20.0D;

    /**
     * 
     * @return is wrapped
     * @author add by huyingzhao
     *         2022-10-24 14:51
     */
    boolean isWrapped() default false;

    /**
     * 
     * @return auto wight adjustment
     * @author add by huyingzhao
     *         2022-10-24 14:51
     */
    boolean autoWeight() default false;

    /**
     * 
     * @return date formart
     * @author add by huyingzhao
     *         2022-06-27 10:14
     */
    ISO8601Enum format() default ISO8601Enum.YYYY_MM_DD_HE_HMS;

    /**
     * 
     * horizontal
     * 
     * @author add by huyingzhao
     *         2022-10-24 14:51
     */
    HorizontalAlignment horizontal() default HorizontalAlignment.CENTER;

    /**
     * 
     * vertical
     * 
     * @author add by huyingzhao
     *         2022-10-24 14:51
     */
    VerticalAlignment vertical() default VerticalAlignment.TOP;

    /**
     * 
     * map
     * 
     * @author add by huyingzhao
     *         2022-10-24 14:51
     */
    String map() default "";
}

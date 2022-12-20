package document;

import enums.ISO8601;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author add by huyingzhao
 * 2022-10-13 13:51
 * only for column
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface XLSXColumnEnum {
    /**
     * @return column name
     */
    String name();

    /**
     * row index
     */

    int index();

    /**
     * @return row wight
     * @author add by huyingzhao
     * 2022-06-27 9:59
     */
    double wight() default 20.0D;


    /**
     * @return is wrapped
     */
    boolean isWrapped() default false;

    /**
     * @return auto wight adjustment
     */
    boolean autoWeight() default false;

    /**
     * @return date formart
     * @author add by huyingzhao
     * 2022-06-27 10:14
     */
    ISO8601 format() default ISO8601.YYYY_MM_DD_HE_HMS;

    /*
     *horizontal
     */
    HorizontalAlignment horizontal() default HorizontalAlignment.CENTER;

    /*
     *vertical
     */
    VerticalAlignment vertical() default VerticalAlignment.TOP;

    /**
     * map
     */
    String map() default "";
}

package document;

import org.apache.poi.xssf.usermodel.XSSFFont;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author add by huyingzhao
 * 2022-01-30 14:14
 * only for font
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface XLSXFontEnum {
    /*
     *font size
     */
    short size() default 11;

    /*
     * font type
     */
    String fontName() default "Arial";

    /*
     *font for charset
     */
    byte charset() default XSSFFont.DEFAULT_CHARSET;

    /*
     *is italic
     */
    boolean isItalic() default false;

    /*
     *is bold
     */
    boolean isBold() default false;

    /*
     *is adding strikeout
     */
    boolean isAddStrikeout() default false;

    /*
     * default IndexedColors.BLACK.getIndex()
     * color for IndexedColors.class
     */
    short color() default 8;
}

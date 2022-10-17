package statics;

import document.XLSXColumnEnum;
import document.XLSXDropEnum;
import document.XLSXFontEnum;
import document.XLSXLinkEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Xlsx Util
 *
 * @author add by huyingzhao
 * 2022-05-27 22:05
 */
@Slf4j
public class XlsxUtils extends Workbook {
    private static int startX = 0;// x
    private static int startY = 0;// y
    private static int fontSize = 12;
    private static int color = IndexedColors.LIGHT_ORANGE.getIndex();

    public static void setStartX(int startX) {
        XlsxUtils.startX = startX;
    }

    public static void setStartY(int startY) {
        XlsxUtils.startY = startY;
    }

    public static void setFontSize(int fontSize) {
        XlsxUtils.fontSize = fontSize;
    }

    public static void setColor(int color) {
        XlsxUtils.color = color;
    }

    /**
     * @param sheetName sheetName
     * @param objects   objects
     */
    public static void writXlsx(String sheetName, List<?> objects) {
        if (xssfWorkbook == null || objects == null || objects.size() == 0) {
            return;
        }
        Class<?> aClass = objects.get(0).getClass();
        Field[] fields = aClass.getDeclaredFields();
        Cell cell;
        for (Field field : fields) {
            field.setAccessible(true);
            XLSXColumnEnum xlsxColumnEnum = field.getAnnotation(XLSXColumnEnum.class);
            if (xlsxColumnEnum != null) {
                cell = createRowCell(sheetName, startX, startY, xlsxColumnEnum, xlsxColumnEnum.name());
                if (cell != null) {
                    XSSFCellStyle cellStyle = xssfWorkbook.createCellStyle();
                    cellStyle.setAlignment(HorizontalAlignment.CENTER);
                    cellStyle.setVerticalAlignment(VerticalAlignment.TOP);
                    cellStyle.setWrapText(false);
                    cellStyle.setFillForegroundColor((short) color);
                    cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    cellStyle.setBorderBottom(BorderStyle.THIN);
                    cellStyle.setBorderLeft(BorderStyle.THIN);
                    cellStyle.setBorderTop(BorderStyle.THIN);
                    cellStyle.setBorderRight(BorderStyle.THIN);
                    cell.setCellStyle(cellStyle);
                    XSSFFont font = xssfWorkbook.createFont();
                    font.setFontHeightInPoints((short) fontSize);
                    font.setFontName("Arial");
                    font.setCharSet(XSSFFont.DEFAULT_CHARSET);
                    font.setItalic(false);
                    font.setBold(true);
                    font.setStrikeout(false);
                    font.setColor(XSSFFont.DEFAULT_FONT_COLOR);
                    cellStyle.setFont(font);
                }
                xssfSheet.autoSizeColumn(xlsxColumnEnum.index(), true);
            }
            field.setAccessible(false);
        }

        try {
            startX++;
            for (Object object : objects) {
                aClass = object.getClass();
                fields = aClass.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    XLSXColumnEnum xlsxColumnEnum = field.getAnnotation(XLSXColumnEnum.class);
                    XLSXDropEnum xlsxDropEnum = field.getAnnotation(XLSXDropEnum.class);
                    XLSXFontEnum xlsxFontEnum = field.getAnnotation(XLSXFontEnum.class);
                    XLSXLinkEnum xlsxLinkEnum = field.getAnnotation(XLSXLinkEnum.class);
                    Object o = field.get(object);
                    if (xlsxColumnEnum != null) {
                        cell = createRowCell(sheetName, startX, startY, xlsxColumnEnum, o);
                        if (cell != null) {
                            setColumn(cell, xlsxColumnEnum);
                            setLink(cell, xlsxLinkEnum);
                            setFont(cell, xlsxFontEnum);
                            if (xlsxDropEnum != null && xlsxDropEnum.values().length < 255) {
                                setDropDownBox(xlsxDropEnum.values(), startX, startX, xlsxColumnEnum.index(),
                                        xlsxColumnEnum.index());
                            }
                        }
                    }

                    field.setAccessible(false);
                }

                startX++;
            }

            xssfWorkbook.setPrintArea(0, 0, fields.length - 1, 0, startX - 1);
            xssfSheet.getPrintSetup().setPaperSize(XSSFPrintSetup.A4_PAPERSIZE);
            xssfSheet.setDisplayGridlines(true);
        } catch (IllegalAccessException e) {
            log.error(e.getMessage(), e);
        } finally {
            startX = 0;
            startY = 0;
            fontSize = 12;
            color = IndexedColors.LIGHT_ORANGE.getIndex();
        }
    }

    /**
     * set dropDown
     *
     * @param values   values
     * @param firstRow firstRow
     * @param lastRow  lastRow
     * @param firstCol firstCol
     * @param lastCol  lastCol
     */
    private static void setDropDownBox(String[] values, Integer firstRow, Integer lastRow, Integer firstCol,
                                       Integer lastCol) {
        XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper(xssfSheet);
        XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint) dvHelper
                .createExplicitListConstraint(values);
        CellRangeAddressList addressList = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
        DataValidation validation = dvHelper.createValidation(dvConstraint, addressList);
        validation.setSuppressDropDownArrow(true);
        validation.setShowErrorBox(true);
        xssfSheet.addValidationData(validation);
    }

    /**
     * set font
     *
     * @param cell         cell
     * @param xlsxFontEnum xlsxFontEnum
     * @author add by huyingzhao
     * 2022-06-21 18:11
     */
    private static void setFont(Cell cell, XLSXFontEnum xlsxFontEnum) {
        CellStyle cellStyle = cell.getCellStyle();
        if (xlsxFontEnum != null) {
            XSSFFont font = xssfWorkbook.createFont();
            font.setFontHeightInPoints(xlsxFontEnum.size());
            font.setFontName(xlsxFontEnum.fontName());
            font.setCharSet(xlsxFontEnum.charset());
            font.setItalic(xlsxFontEnum.isItalic());
            font.setBold(xlsxFontEnum.isBold());
            font.setStrikeout(xlsxFontEnum.isAddStrikeout());
            font.setColor(xlsxFontEnum.color());
            cellStyle.setFont(font);
        }
    }

    /**
     * set cell
     *
     * @param cell         cell
     * @param xlsxLinkEnum xlsxLinkEnum
     * @author add by huyingzhao
     * 2022-06-21 18:08
     */
    private static void setLink(Cell cell, XLSXLinkEnum xlsxLinkEnum) {
        if (xlsxLinkEnum != null) {
            XSSFCreationHelper xssfCreationHelper = xssfWorkbook.getCreationHelper();
            if (xlsxLinkEnum.url() != null && !xlsxLinkEnum.url().isEmpty()) {
                XSSFHyperlink xssfHyperlink = xssfCreationHelper.createHyperlink(HyperlinkType.URL);
                xssfHyperlink.setAddress(xlsxLinkEnum.url());
                cell.setHyperlink(xssfHyperlink);
            }

            if (xlsxLinkEnum.email() != null && !xlsxLinkEnum.email().isEmpty()) {
                XSSFHyperlink xssfHyperlinkEmail = xssfCreationHelper.createHyperlink(HyperlinkType.EMAIL);
                xssfHyperlinkEmail.setAddress(xlsxLinkEnum.email());
                cell.setHyperlink(xssfHyperlinkEmail);
            }

            if (xlsxLinkEnum.file() != null && !xlsxLinkEnum.file().isEmpty()) {
                XSSFHyperlink xssfHyperlinkFile = xssfCreationHelper.createHyperlink(HyperlinkType.FILE);
                xssfHyperlinkFile.setAddress(xlsxLinkEnum.file());
                cell.setHyperlink(xssfHyperlinkFile);
            }
        }
    }

    /**
     * set column
     *
     * @param cell           cell
     * @param xlsxColumnEnum xlsxColumnEnum
     * @author add by huyingzhao
     * 2022-06-21 18:08
     */
    private static void setColumn(Cell cell, XLSXColumnEnum xlsxColumnEnum) {
        // 设置列样式
        XSSFCellStyle cellStyle = xssfWorkbook.createCellStyle();
        cellStyle.setAlignment(xlsxColumnEnum.horizontal());
        cellStyle.setVerticalAlignment(xlsxColumnEnum.vertical());
        cellStyle.setWrapText(xlsxColumnEnum.isWrapped());
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cell.setCellStyle(cellStyle);

        xssfSheet.setColumnWidth(xlsxColumnEnum.index(), (int) ((xlsxColumnEnum.wight() + 0.72) * 256));
        if (xlsxColumnEnum.autoWeight()) {
            xssfSheet.autoSizeColumn(xlsxColumnEnum.index(), true);
        }
    }
}

@Slf4j
class Workbook {
    static XSSFSheet xssfSheet;
    static XSSFWorkbook xssfWorkbook;
    private static HashMap<String, XSSFRow> rowMap;
    private static HashMap<String, XSSFSheet> sheetHashMap;

    /**
     * init table object
     *
     * @author add by huyingzhao
     * 2022-05-27 22:19
     */
    public static void start() {
        xssfWorkbook = new XSSFWorkbook();
        if (rowMap == null) {
            rowMap = new HashMap<>();
        } else {
            rowMap.clear();
        }

        if (sheetHashMap == null) {
            sheetHashMap = new HashMap<>();
        } else {
            sheetHashMap.clear();
        }
    }

    /**
     * write table
     *
     * @param out out
     */
    public static void end(OutputStream out) {
        if (!(xssfWorkbook == null || rowMap == null || out == null)) {
            try {
                xssfWorkbook.write(out);
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            } finally {
                if (xssfWorkbook != null) {
                    try {
                        xssfWorkbook.close();
                        out.close();
                    } catch (IOException e) {
                        log.error(e.getMessage(), e);
                    }
                }
            }
        }
    }

    /**
     * write table
     *
     * @param file file
     */
    public static void end(File file) {
        if (!(xssfWorkbook == null || rowMap == null)) {
            if (file.isFile()) {
                log.info("[" + file.getParent() + "]-[" + file.getName() + "]" + (file.delete() ? "delete table success" : "delete table fail"));
            }
            try (FileOutputStream out = new FileOutputStream(file)) {
                xssfWorkbook.write(out);
                log.info("[" + file.getParent() + "]-[" + file.getName() + "]create table success");
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            } finally {
                if (xssfWorkbook != null) {
                    try {
                        xssfWorkbook.close();
                    } catch (IOException e) {
                        log.error(e.getMessage(), e);
                    }
                }
            }
        }
    }

    /**
     * create sheet
     *
     * @param sheetName sheetName
     */
    private static void createSheet(String sheetName) {
        xssfSheet = sheetHashMap.get(sheetName);
        if (xssfWorkbook != null) {
            if (xssfSheet == null) {
                xssfSheet = xssfWorkbook.createSheet(sheetName);
                sheetHashMap.put(sheetName, xssfSheet);
            }
        }
    }

    /**
     * tab 1,2,3,4,...
     *
     * @param sheetName sheetName
     * @param s         s
     * @return createRow
     */
    private static XSSFRow createRow(String sheetName, int s) {
        String rowName = sheetName + s;
        XSSFRow row = rowMap.get(rowName);
        if (xssfSheet != null) {
            // create and set row
            if (row == null) {
                row = xssfSheet.createRow(s);
                CTRow ctRow = row.getCTRow();
                ctRow.setCustomHeight(false);
                rowMap.put(rowName, row);
            }
            return row;
        }

        return null;
    }

    /**
     * tab A,B,C,D,...
     *
     * @param xssfRow xssfRow
     * @param a       a
     * @return createCell
     */
    private static XSSFCell createCell(XSSFRow xssfRow, int a) {
        if (xssfRow != null) {
            // create cell
            return xssfRow.createCell(a);
        }

        return null;
    }

    /**
     * Excel 2003：column maximum 256(IV,2^8),row maximum 65536(2^16);
     * Excel 2007：column maximum 16384(XFD,2^814),row maximum 1048576(2^20);
     * Excel 2013：column maximum 16384(XFD,2^814),row maximum 1048576(2^20);
     * private final long maxSize = (long) (Math.pow(2, 14) * Math.pow(2, 20));
     *
     * @param x              x
     * @param y              y
     * @param xlsxColumnEnum xlsxColumnEnum
     * @param o              o
     * @return createRowCell
     */
    static Cell createRowCell(String sheetName, int x, int y, XLSXColumnEnum xlsxColumnEnum, Object o) {
        if (sheetName != null) {
            createSheet(sheetName);
            return getCellValue(xlsxColumnEnum, createCell(createRow(sheetName, x), y + xlsxColumnEnum.index()), o);
        } else {
            return null;
        }
    }

    /**
     * create data
     *
     * @param cell cell
     * @param o    o
     * @return getCellValue
     */
    private static Cell getCellValue(XLSXColumnEnum xlsxColumnEnum, Cell cell, Object o) {
        if (cell != null) {
            // create row
            if (o instanceof String) {
                if (xlsxColumnEnum.map() != null && !xlsxColumnEnum.map().isEmpty()) {
                    Map<String, String> map = StringUtils.toMap(xlsxColumnEnum.map());
                    String str = (String) o;
                    for (String s : map.keySet()) {
                        if (s.equals(str)) {
                            cell.setCellValue(map.get(str));
                        } else {
                            cell.setCellValue(s);
                        }
                    }
                } else {
                    cell.setCellValue((String) o);
                }
            } else if (o instanceof Long) {
                cell.setCellValue((Long) o);
            } else if (o instanceof Short) {
                cell.setCellValue((Short) o);
            } else if (o instanceof Integer) {
                cell.setCellValue((Integer) o);
            } else if (o instanceof Byte) {
                cell.setCellValue((Byte) o);
            } else if (o instanceof Date) {
                cell.setCellValue(DateUtils.format((Date) o, xlsxColumnEnum.format()));
            } else if (o instanceof Double) {
                cell.setCellValue((Double) o);
            } else if (o instanceof Float) {
                cell.setCellValue((Float) o);
            } else if (o instanceof Boolean) {
                cell.setCellValue((Boolean) o);
            }
        }

        return cell;
    }
}

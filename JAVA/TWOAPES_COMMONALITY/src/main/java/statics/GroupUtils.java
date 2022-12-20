package statics;

import enums.ISO8601;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author add by huyingzhao
 *         2022-06-29 10:38
 */
@Slf4j
public class GroupUtils {
    /**
     * group for list
     * @param list     list
     * @param groupBys groupBys
     * @param iso8601  iso8601
     * @param <T>      <T>
     * @return groupList
     * @author add by huyingzhao
     *         2022-06-07 21:29
     */
    public static <T> List<Object> groupList(List<T> list, List<String> groupBys, ISO8601 iso8601) {
        List<Object> tList = new ArrayList<>();
        try {
            Map<String, List<T>> map = groupMap(list, groupBys);
            for (String s : map.keySet()) {
                List<T> list2 = map.get(s);
                if (list2.size() > 1) {
                    Object t2 = list2.get(0).getClass().getDeclaredConstructor().newInstance();
                    Map<String, Object> stringObjectMap = new HashMap<>();
                    for (T t : list2) {
                        Field[] fields = t.getClass().getDeclaredFields();
                        for (Field field : fields) {
                            field.setAccessible(true);
                            String type = field.getType().getTypeName();
                            String name = field.getName();
                            Field field2 = t2.getClass().getDeclaredField(name);
                            field2.setAccessible(true);
                            Object key = stringObjectMap.get(name);
                            String mapString;
                            if (key == null) {
                                mapString = "";
                            } else {
                                mapString = String.valueOf(key);
                            }

                            String nowString;
                            if (field.get(t) == null) {
                                nowString = "";
                            } else {
                                nowString = String.valueOf(field.get(t));
                            }

                            switch (type) {
                                case "int":
                                case "java.lang.Integer":
                                    if (key != null) {
                                        int oldValue = Integer.parseInt(mapString);
                                        int nowValue = Integer.parseInt(nowString);
                                        stringObjectMap.put(name, oldValue + nowValue);
                                        field2.setInt(t2, oldValue + nowValue);
                                    } else {
                                        int nowValue = Integer.parseInt(nowString);
                                        stringObjectMap.put(name, nowValue);
                                        field2.setInt(t2, nowValue);
                                    }
                                    break;
                                case "long":
                                case "java.lang.Long":
                                    if (key != null) {
                                        long oldValue = Long.parseLong(mapString);
                                        long nowValue = Long.parseLong(nowString);
                                        stringObjectMap.put(name, oldValue + nowValue);
                                        field2.setLong(t2, oldValue + nowValue);
                                    } else {
                                        long nowValue = Long.parseLong(nowString);
                                        stringObjectMap.put(name, nowValue);
                                        field2.setLong(t2, nowValue);
                                    }
                                    break;
                                case "short":
                                case "java.lang.Short":
                                    if (key != null) {
                                        short oldValue = Short.parseShort(mapString);
                                        short nowValue = Short.parseShort(nowString);
                                        stringObjectMap.put(name, oldValue + nowValue);
                                        field2.setShort(t2, (short) (oldValue + nowValue));
                                    } else {
                                        short nowValue = Short.parseShort(nowString);
                                        stringObjectMap.put(name, nowValue);
                                        field2.setShort(t2, nowValue);
                                    }
                                    break;
                                case "byte":
                                case "java.lang.Byte":
                                    if (key != null) {
                                        byte oldValue = Byte.parseByte(mapString);
                                        byte nowValue = Byte.parseByte(nowString);
                                        stringObjectMap.put(name, oldValue + nowValue);
                                        field2.setShort(t2, (byte) (oldValue + nowValue));
                                    } else {
                                        byte nowValue = Byte.parseByte(nowString);
                                        stringObjectMap.put(name, nowValue);
                                        field2.setShort(t2, nowValue);
                                    }
                                    break;
                                case "double":
                                case "java.lang.Double":
                                    if (key != null) {
                                        double nowValue = Double.parseDouble(nowString);
                                        double oldValue = Double.parseDouble(mapString);
                                        stringObjectMap.put(name, oldValue + nowValue);
                                        field2.setDouble(t2, oldValue + nowValue);
                                    } else {
                                        double nowValue = Double.parseDouble(nowString);
                                        stringObjectMap.put(name, nowValue);
                                        field2.setDouble(t2, nowValue);
                                    }
                                    break;
                                case "float":
                                case "java.lang.Float":
                                    if (key != null) {
                                        float nowValue = Float.parseFloat(nowString);

                                        float oldValue = Float.parseFloat(mapString);
                                        stringObjectMap.put(name, oldValue + nowValue);
                                        field2.setFloat(t2, oldValue + nowValue);
                                    } else {
                                        float nowValue = Float.parseFloat(nowString);

                                        stringObjectMap.put(name, nowValue);
                                        field2.setFloat(t2, nowValue);
                                    }
                                    break;
                                case "char":
                                case "java.lang.Character":
                                    if (key != null) {
                                        char nowValue = nowString.toCharArray()[0];

                                        char oldValue = (char) stringObjectMap.get(name);
                                        stringObjectMap.put(name, oldValue + nowValue);
                                        field2.setChar(t2, (char) (oldValue + nowValue));
                                    } else {
                                        char nowValue = nowString.toCharArray()[0];

                                        stringObjectMap.put(name, nowValue);
                                        field2.setChar(t2, nowValue);
                                    }
                                    break;
                                case "boolean":
                                case "java.lang.Boolean":
                                    field2.set(t2, Boolean.valueOf(nowString));
                                    break;
                                case "java.util.Date":
                                    field2.set(t2, DateUtils.parse(nowString, iso8601));
                                    break;
                                default:
                                    field2.set(t2, nowString);
                                    break;
                            }

                            field.setAccessible(false);
                            field2.setAccessible(false);
                        }
                    }

                    tList.add(t2);
                } else if (list2.size() == 1) {
                    tList.add(list2.get(0));
                }
            }
        } catch (NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException
                | NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            log.error(e.getMessage(), e);
        }

        return tList;
    }

    /**
     * @param list     list
     * @param groupBys groupBys
     * @param <T>      <T>
     * @return groupMap
     * @author add by huyingzhao
     *         2022-06-07 21:30
     */
    private static <T> Map<String, List<T>> groupMap(List<T> list, List<String> groupBys) {
        Map<String, List<T>> map = new HashMap<>();
        for (T t : list) {
            map.computeIfAbsent(getKey(t, groupBys), k -> new ArrayList<>()).add(t);
        }
        return map;
    }

    /**
     * @param t      t
     * @param groups groups
     * @param <T>    <T>
     * @return getKey
     * @author add by huyingzhao
     *         2022-06-07 21:30
     */
    private static <T> String getKey(T t, List<String> groups) {
        StringBuilder key = new StringBuilder("\n");
        Field[] fields = t.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                String name = field.getName();
                Object value = field.get(t);
                if (groups.contains(name)) {
                    key.append(value.toString()).append("_");
                }
            }
        } catch (IllegalAccessException e) {
            log.error(e.getMessage(), e);
        }
        return key.toString();
    }

    /**
     * @param list     list
     * @param orderBys orderBys
     * @param <T>      <T>
     * @return sorted
     * @author add by huyingzhao
     *         2022-06-07 21:30
     */
    public static <T> List<T> sorted(List<T> list, List<String> orderBys) {
        List<T> toSort = new ArrayList<>(list);
        toSort.sort(Comparator.comparing(t -> getKey(t, orderBys)));
        return toSort;
    }
}

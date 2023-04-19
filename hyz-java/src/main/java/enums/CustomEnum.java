package enums;

/**
 * @author add by huyingzhao
 * 2023-03-11 13:04
 * 使用enum定义枚举类
 */
public enum CustomEnum {
    ONE("第一"), TWO("第二"), THREE("第三");
    private final String value;

    public String value() {
        return value;
    }

    CustomEnum(String value) {
        this.value = value;
    }
}

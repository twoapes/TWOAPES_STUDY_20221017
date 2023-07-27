package core.name;

/**
 * @author add by huyingzhao
 * 2023-07-21 09:54
 */
public interface NameService {
    /**
     * @param length 名-长度
     * @return 姓-长度两位
     * @author add by huyingzhao
     * 2023-07-21 10:07
     */
    String fullName1(int length);

    /**
     * @param length 名-长度
     * @return 姓-长度3位
     * @author add by huyingzhao
     * 2023-07-21 10:07
     */
    String fullName2(int length);
}

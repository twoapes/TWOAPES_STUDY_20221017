package spring.aop.jdk;

/**
 * @author add by huyingzhao
 * 2022-10-06 11:11
 */
public interface JDKProxyDao {
    /**
     *
     * @author add by huyingzhao
     * 2022-10-06 11:34
     * @param a a
     * @param b b
     * @return point junction
     */
    int add(int a, int b);

    /**
     *
     * @author add by huyingzhao
     * 2022-10-06 11:34
     * @param a a
     * @param b b
     * @return point junction
     */
    int mul(int a, int b);
}
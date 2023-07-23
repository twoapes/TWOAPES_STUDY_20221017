package aop.jdk.impl;

import aop.jdk.JDKProxyDao;

/**
 * @author add by huyingzhao
 * 2022-10-06 11:12
 */
public class JDKProxyDaoImpl implements JDKProxyDao {
    public int add(int a, int b) {
        return a + b;
    }

    public int mul(int a, int b) {
        return a * b;
    }
}
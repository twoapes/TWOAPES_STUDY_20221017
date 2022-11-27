package aop.jdk;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author add by huyingzhao
 * 2022-10-06 11:11
 * JDK Proxy
 */
@Slf4j
public class JDKProxyDI {
    public static void jDKProxyDI() {
        Class<?>[] classes = {JDKProxyDao.class};
        JDKProxyDaoImpl jdkProxyDao = new JDKProxyDaoImpl();
        JDKProxyDao dao = (JDKProxyDao) Proxy.newProxyInstance(JDKProxyDI.class.getClassLoader(), classes, new UserInvocationHandler(jdkProxyDao));
        log.info("a=" + 22);
        log.info("b=" + 24);
        //point penetration add
        log.info("a+b=" + dao.add(22, 24));
    }
}
@Slf4j
class UserInvocationHandler implements InvocationHandler {
    private final Object object;

    public UserInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //Before Advice
        log.info("before method\t" + "class:" + method.getClass() + "\tmethod:" + method.getName());
        Object o = method.invoke(object, args);
        //After Advice
        log.info("after method\t" + o.toString());
        return o;
    }
}
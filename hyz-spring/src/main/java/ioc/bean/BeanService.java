package ioc.bean;

import lombok.Data;

/**
 * @author add by huyingzhao
 * 2022-08-07 13:45
 */
@Data
public class BeanService {
    private BeanDao beanDao;
    private BeanDao2 beanDao2;
    private BeanDao3 beanDao3;
    private BeanDao4 beanDao4;
}
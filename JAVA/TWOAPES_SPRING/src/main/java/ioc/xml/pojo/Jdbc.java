package ioc.xml.pojo;

import lombok.Data;

/**
 * @author huyingzhao
 * 2021/11/14 16:22:22
 */
@Data
public class Jdbc {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}

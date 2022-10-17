package statics;

import lombok.extern.slf4j.Slf4j;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.Query;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.util.Set;

/**
 * @author add by huyingzhao
 * 2022-09-06 11:39
 * ip,port execute
 */
@Slf4j
public class LocalUtil {
    /**
     * @return get a local port
     * @author add by huyingzhao
     * 2022-09-06 11:46
     */
    public static String getLocalPort() {
        MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
        Set<ObjectName> objectNames = null;
        try {
            objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"), Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
        } catch (MalformedObjectNameException e) {
            log.error(e.getMessage(), e);
        }
        if (objectNames != null) {
            StringBuilder port = new StringBuilder("\n");
            for (ObjectName objectName : objectNames) {
                port.append(objectName.getKeyProperty("port"));
            }
            return port.toString();
        } else {
            return "";
        }
    }

    /**
     * @return get a local ip
     * @author add by huyingzhao
     * 2022-09-06 11:46
     */
    public static String getLocalIP() {
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }

        StringBuilder ipAddrStr = new StringBuilder("\n");
        if (addr != null) {
            byte[] ipAddr = addr.getAddress();
            for (int i = 0; i < ipAddr.length; i++) {
                if (i > 0) {
                    ipAddrStr.append(".");
                }
                ipAddrStr.append(ipAddr[i] & 0xFF);
            }
        }
        return ipAddrStr.toString();
    }
}

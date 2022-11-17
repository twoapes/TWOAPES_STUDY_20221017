package util;

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

    /**
     *
     * @author add by huyingzhao
     * 2022-11-15 18:21
     * @param addr addr
     * @return is local
     */
    public static boolean isLocalIP(byte[] addr) {
        final byte b0 = addr[0];
        final byte b1 = addr[1];
        final byte SECTION_1 = 0x0A;
        final byte SECTION_2 = (byte) 0xAC;
        final byte SECTION_3 = (byte) 0x10;
        final byte SECTION_4 = (byte) 0x1F;
        final byte SECTION_5 = (byte) 0xC0;
        final byte SECTION_6 = (byte) 0xA8;
        switch (b0) {
            case SECTION_1:
                return true;
            case SECTION_2:
                if (b1 >= SECTION_3 && b1 <= SECTION_4) {
                    return true;
                }
            case SECTION_5:
                if (b1 == SECTION_6) {
                    return true;
                }
            default:
                return false;
        }
    }

    /**
     * @param text text
     * @return ipv4 to byte[]
     */
    public static byte[] ipv4toBytes(String text) {
        if (text.length() == 0) {
            return null;
        }

        byte[] bytes = new byte[4];
        String[] elements = text.split("\\.", -1);
        try {
            long l;
            int i;
            switch (elements.length) {
                case 1:
                    l = Long.parseLong(elements[0]);
                    if ((l < 0L) || (l > 4294967295L))
                        return null;
                    bytes[0] = (byte) (int) (l >> 24 & 0xFF);
                    bytes[1] = (byte) (int) ((l & 0xFFFFFF) >> 16 & 0xFF);
                    bytes[2] = (byte) (int) ((l & 0xFFFF) >> 8 & 0xFF);
                    bytes[3] = (byte) (int) (l & 0xFF);
                    break;
                case 2:
                    l = Integer.parseInt(elements[0]);
                    if ((l < 0L) || (l > 255L))
                        return null;
                    bytes[0] = (byte) (int) (l & 0xFF);
                    l = Integer.parseInt(elements[1]);
                    if ((l < 0L) || (l > 16777215L))
                        return null;
                    bytes[1] = (byte) (int) (l >> 16 & 0xFF);
                    bytes[2] = (byte) (int) ((l & 0xFFFF) >> 8 & 0xFF);
                    bytes[3] = (byte) (int) (l & 0xFF);
                    break;
                case 3:
                    for (i = 0; i < 2; ++i) {
                        l = Integer.parseInt(elements[i]);
                        if ((l < 0L) || (l > 255L))
                            return null;
                        bytes[i] = (byte) (int) (l & 0xFF);
                    }
                    l = Integer.parseInt(elements[2]);
                    if ((l < 0L) || (l > 65535L))
                        return null;
                    bytes[2] = (byte) (int) (l >> 8 & 0xFF);
                    bytes[3] = (byte) (int) (l & 0xFF);
                    break;
                case 4:
                    for (i = 0; i < 4; ++i) {
                        l = Integer.parseInt(elements[i]);
                        if ((l < 0L) || (l > 255L))
                            return null;
                        bytes[i] = (byte) (int) (l & 0xFF);
                    }
                    break;
                default:
                    return null;
            }
        } catch (NumberFormatException e) {
            log.error(e.getMessage(), e);
            return null;
        }

        return bytes;
    }
}

package array;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-06-19 13:47
 * using object array
 */
@Slf4j
public class ObjectArray {
    public static void objectArray() {
        ObjectPojo[] objectPojos = new ObjectPojo[2];
        objectPojos[0] = new ObjectPojo();
        ObjectPojo objectPojo1 = objectPojos[0];
        objectPojo1.setI(1);
        objectPojo1.setJ(2);
        objectPojos[1] = new ObjectPojo();
        ObjectPojo objectPojo2 = objectPojos[1];
        objectPojo2.setI(3);
        objectPojo2.setJ(4);
        StringBuilder stringBuilder=new StringBuilder("\n");
        for (ObjectPojo objectPojo : objectPojos) {
            stringBuilder.append("i:").append(objectPojo.getI()).append(" j:").append(objectPojo.getJ()).append("\t");
        }

        log.info(stringBuilder.toString());
    }
}

@Data
class ObjectPojo {
    private int i;
    private int j;
}

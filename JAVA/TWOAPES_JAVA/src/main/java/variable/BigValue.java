package variable;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

/**
 * @author add by huyingzhao
 * 2022-06-11 13:33
 * big value
 */
@Slf4j
public class BigValue {
    public static void bigValue() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        BigInteger bigInteger1 = BigInteger.valueOf(100);
        BigInteger bigInteger2 = BigInteger.valueOf(2);
        stringBuilder.append("bigInteger1:").append(bigInteger1).append("\t").append("bigInteger2:").append(bigInteger2).append("\n");
        stringBuilder.append("add:100+2=").append(bigInteger1.add(bigInteger2)).append("\n");
        stringBuilder.append("subtract:100-2=").append(bigInteger1.subtract(bigInteger2)).append("\n");
        stringBuilder.append("multiply:100*2=").append(bigInteger1.multiply(bigInteger2)).append("\n");
        stringBuilder.append("divide:100/2=").append(bigInteger1.divide(bigInteger2)).append("\n");
        stringBuilder.append("mod:100%2=").append(bigInteger1.mod(bigInteger2)).append("\n");

        stringBuilder.append("compare");
        if (bigInteger1.compareTo(bigInteger2) > 0) {
            stringBuilder.append("bigInteger1>=bigInteger2:").append(bigInteger1).append(">").append(bigInteger2).append("\n");
        } else if (bigInteger1.compareTo(bigInteger2) < 0) {
            stringBuilder.append("bigInteger1<bigInteger2:").append(bigInteger1).append("<").append(bigInteger2).append("\n");
        } else {
            stringBuilder.append("bigInteger1=bigInteger2:").append(bigInteger1).append("=").append(bigInteger2).append("\n");
        }

        log.info(stringBuilder.toString());
    }
}
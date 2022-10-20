package cases;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author add by huyingzhao
 * 2022-10-08 17:06
 * simple encryption/decryption
 */
@Slf4j
public class EncryptEasy {
    public static void encryptEasy(){
        String str="encryption/decryption";
        log.info("old:"+str);
        char[] strings=str.toCharArray();
        for (char s : strings) {
            s=(char)(s^20000);
        }

        log.info("new:"+ Arrays.toString(strings));
    }
}

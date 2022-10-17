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
        int i=0;
        for (char s : strings) {
            strings[i]=(char)(strings[i]^20000);
            i++;
        }

        log.info("new:"+ Arrays.toString(strings));
    }
}

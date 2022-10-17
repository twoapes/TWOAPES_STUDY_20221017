package cases;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-10-08 18:19
 *  using while and auto increment operators loop
 */
@Slf4j
public class ErgodicArray {
    public static void ergodicArray(){
        String[] a={"1","2","3","4","5"};
        int index=0;
        while (index<a.length){
            log.info(a[index++]);
        }
    }
}

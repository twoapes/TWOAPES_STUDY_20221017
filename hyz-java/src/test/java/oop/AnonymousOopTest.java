package oop;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author add by huyingzhao
 * 2023-03-13 17:10
 * 匿名对象
 */
public class AnonymousOopTest {
    /**
     * @author add by huyingzhao
     * 2023-03-13 17:11
     */
    @Test
    public void anonymous() {
        //匿名对象
        new Anonymous().add();
    }
}

@Slf4j
class Anonymous {
   public void add(){
       log.info("add");
   }
}
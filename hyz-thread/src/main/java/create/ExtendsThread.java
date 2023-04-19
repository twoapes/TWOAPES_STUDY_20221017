package create;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2023-03-03 11:49
 * 创建线程方式一：继承于Thread类
 */
@Slf4j
public class ExtendsThread extends Thread {//1
    @Override
    public void run() {//2
       log.info("thread name {}",this.getName());
    }
}

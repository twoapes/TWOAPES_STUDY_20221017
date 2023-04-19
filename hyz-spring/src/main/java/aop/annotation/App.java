package aop.annotation;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-10-06 15:59
 */
@Slf4j
public class App {
    public void add(){
      log.info("call aop.annotation.App.add");
    }
}
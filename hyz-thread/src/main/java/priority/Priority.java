package priority;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2023-03-03 11:51
 * 线程的优先级
 */
@Slf4j
class Priority extends Thread {
    @Override
    public void run() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < 5; i++) {
            stringBuilder.setLength(0);
            stringBuilder.append(this.getName()).append(":").append(i);
            log.info(stringBuilder.toString());
        }
    }
}

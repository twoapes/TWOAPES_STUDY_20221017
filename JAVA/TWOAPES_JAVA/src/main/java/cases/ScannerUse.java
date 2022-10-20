package cases;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * @author add by huyingzhao
 * 2022-10-08 16:40
 * using Scanner
 */
@Slf4j
public class ScannerUse {
    public static void scannerUse() {
        Scanner scanner = new Scanner(System.in);
        log.info("please enter any character and enter:");
        String s = scanner.next();
        if (s != null && !s.isEmpty()) {
            log.info("s:" + s);
        }

        scanner.close();
    }
}

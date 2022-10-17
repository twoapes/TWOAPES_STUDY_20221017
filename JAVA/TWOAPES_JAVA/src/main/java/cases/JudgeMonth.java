package cases;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-10-08 18:15
 * judge the season
 */
@Slf4j
public class JudgeMonth {
    public static void judgeMonth() {
        int next = 7;
        switch (next) {
            case 12:
            case 1:
            case 2:
                log.info("spring");
                break;
            case 3:
            case 4:
            case 5:
                log.info("summer");
                break;
            case 6:
            case 7:
            case 8:
                log.info("autumn");
                break;
            case 9:
            case 10:
            case 11:
                log.info("winter");
        }
    }
}

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author add by huyingzhao
 * 2022-09-13 10:53
 * constant test
 */
@Slf4j
public class ConstantTest {
    /**
     * test Constant
     * @author add by huyingzhao
     * 2022-09-13 10:53
     */
    @Test
    public void constantTest() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        final double PI = Math.PI;
        double radius = 20;
        double area = radius * radius * PI;
        stringBuilder.append("round's radius:").append(radius).append(" area is ").append(area);

        radius = 30;
        area = radius * radius * PI;
        stringBuilder.append("round's radius:").append(radius).append(" area is ").append(area);
        log.info("stringBuilder:{}",stringBuilder);
    }
}

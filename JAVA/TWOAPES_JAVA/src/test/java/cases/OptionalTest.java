package cases;

import cases.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Optional;

/**
 * @author add by huyingzhao
 * 2022-09-11 18:28
 * test Optional
 */
@Slf4j
public class OptionalTest {
    /**
     * test optional
     *
     * @author method add by huyingzhao
     * 2022-10-13 18:47
     */
    @Test
    public void optionalTest() {
        Student studentTO = new Student();
        studentTO.setName("ZhangSan");
        studentTO.setAge(22);
//        studentDTO.setName("ZhangSan");
        String name = Optional.of(studentTO).map(Student::getName).orElse("");
        log.info(name);
    }
}



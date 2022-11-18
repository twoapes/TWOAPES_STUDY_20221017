import entity.Student;
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
        Student student = new Student();
        student.setName("ZhangSan");
        student.setAge(22);
//        studentDTO.setName("ZhangSan");
        String name = Optional.of(student).map(Student::getName).orElse("");
        log.info("name:{}",name);
    }
}



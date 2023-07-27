package springboot.api;

import springboot.domain.student.StudentVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import page.ObjectResult;

/**
 * @author huyingzhao
 * 2022-01-23 18:35:33
 */
@RestController
@Api(value = "PropertiesApi", tags = "propertiesApi")
public class PropertiesApi {
    /**
     * placeholder {...}
     */
    @Value("${student.id}")
    private int id;
    /**
     * placeholder {...}
     */
    @Value("${student.name}")
    private String name;
    private final StudentVO studentVO;

    @Autowired
    public PropertiesApi(StudentVO studentVO) {
        this.studentVO = studentVO;
    }

    /**
     * using object get properties
     */
    @GetMapping({"/properties"})
    @ResponseBody
    public ObjectResult<StudentVO> properties() {
        return ObjectResult.success("studentVO", studentVO);
    }

    /**
     * using placeholder pass attribute
     */
    @GetMapping("/placeholder")
    @ResponseBody
    public ObjectResult<StudentVO> placeholder() {
        StudentVO studentVO = new StudentVO();
        studentVO.setId(id);
        studentVO.setName(name);
        return ObjectResult.success("studentVO", studentVO);
    }
}

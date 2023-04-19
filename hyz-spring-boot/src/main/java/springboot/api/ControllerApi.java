package springboot.api;

import springboot.domain.student.StudentVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.mapper.SelectMapper;
import springboot.mapper.XmlMapper;

/**
 * @author add by huyingzhao
 * 2023-04-17 10:23
 */
@Controller
@RequestMapping("/api")
@Api(value = "ControllerApi", tags = "controllerApi")
public class ControllerApi {
    private final SelectMapper selectMapper;
    private final XmlMapper xmlMapper;

    @Autowired
    public ControllerApi(SelectMapper selectMapper, XmlMapper xmlMapper) {
        this.selectMapper = selectMapper;
        this.xmlMapper = xmlMapper;
    }

    /**
     * @return student
     */
    @GetMapping("/selectStudent")
    public String selectStudent(ModelMap map) {
        StudentVO student = selectMapper.getStudent(1);
        map.put("age", student.getAge());
        map.put("name", student.getName());
        map.put("id", student.getId());
        return "/view.html";
    }


    @GetMapping("/xmlStudent")
    public String xmlStudent(ModelMap map) {
        StudentVO student = xmlMapper.getStudent(1);
        map.put("name", student.getName());
        map.put("age", student.getAge());
        map.put("id", student.getId());
        return "/view.html";
    }
}

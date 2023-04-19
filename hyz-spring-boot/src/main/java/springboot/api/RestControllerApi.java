package springboot.api;

import springboot.domain.student.StudentVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springboot.mapper.SelectMapper;
import springboot.mapper.XmlMapper;

/**
 * @author add by huyingzhao
 * 2023-04-17 10:25
 */
@RestController
@RequestMapping("/api/rest")
@Api(value = "RestControllerApi", tags = "restControllerApi")
public class RestControllerApi {
    private final SelectMapper selectMapper;
    private final XmlMapper xmlMapper;

    @Autowired
    public RestControllerApi(SelectMapper selectMapper, XmlMapper xmlMapper) {
        this.selectMapper = selectMapper;
        this.xmlMapper = xmlMapper;
    }

    /**
     * @return student
     */
    @GetMapping("/selectStudent")
    public ModelAndView selectStudent(ModelMap map) {
        StudentVO studentTO = selectMapper.getStudent(2);
        map.put("age", studentTO.getAge());
        map.put("name", studentTO.getName());
        map.put("id", studentTO.getId());
        return new ModelAndView("/view.html");
    }


    @GetMapping("/xmlStudent")
    public ModelAndView xmlStudent(ModelMap map) {
        StudentVO studentTO = xmlMapper.getStudent(2);
        map.put("name", studentTO.getName());
        map.put("age", studentTO.getAge());
        map.put("id", studentTO.getId());
        return new ModelAndView("/view.html");
    }
}

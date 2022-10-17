package springboot.controller;

import dto.StudentTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import springboot.mapper.ControllerSelectMapper;

/**
 * @author huyingzhao
 * 2022-01-23 18:58:56
 * may return ModelAndView,also reture String
 */
@Controller
@Api(value = "ControllerSelectController", tags = "using Controller(Select Annotation)")
public class ControllerSelectController {
    @Autowired
    private ControllerSelectMapper controllerSelectMapper;

    /**
     * @return student
     */
    @GetMapping("/view1")
    public String student(ModelMap map) {
        StudentTO studentTO = controllerSelectMapper.getStudent(1);
        map.put("age", studentTO.getAge());
        map.put("name", studentTO.getName());
        map.put("id", studentTO.getId());
        return "/view.html";
    }

    /**
     * @return student
     */
    @GetMapping("/view2")
    public String student2(ModelMap map) {
        StudentTO studentTO = controllerSelectMapper.getStudent(2);
        map.put("age", studentTO.getAge());
        map.put("name", studentTO.getName());
        map.put("id", studentTO.getId());
        return "/view.html";
    }
}

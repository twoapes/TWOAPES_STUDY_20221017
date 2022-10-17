package springboot.controller;

import dto.StudentTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springboot.mapper.RestControllerSelectMapper;

/**
 * @author huyingzhao
 * 2022-01-23 18:58:56
 * if web only return ModelAndView
 */
@RestController
@Api(value = "RestControllerSelectController", tags = "using RestController(Select Annotation)")
public class RestControllerSelectController {
    @Autowired
    private RestControllerSelectMapper restControllerSelectMapper;

    /**
     * @return student
     */
    @GetMapping("/viewRest1")
    public ModelAndView student(ModelMap map) {
        StudentTO studentTO = restControllerSelectMapper.getStudent(1);
        map.put("age", studentTO.getAge());
        map.put("name", studentTO.getName());
        map.put("id", studentTO.getId());
        return new ModelAndView("/view.html");
    }

    /**
     * @return student
     */
    @GetMapping("/viewRest2")
    public ModelAndView student2(ModelMap map) {
        StudentTO studentTO = restControllerSelectMapper.getStudent(2);
        map.put("age", studentTO.getAge());
        map.put("name", studentTO.getName());
        map.put("id", studentTO.getId());
        return new ModelAndView("/view.html");
    }
}

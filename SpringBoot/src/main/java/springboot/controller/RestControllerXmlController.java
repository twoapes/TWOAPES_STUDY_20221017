package springboot.controller;

import domain.StudentTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springboot.mapper.RestControllerXmlMapper;

/**
 * @author huyingzhao
 * 2022-01-23 21:21:53
 * if web only return ModelAndView
 */
@RestController
public class RestControllerXmlController {
    @Autowired
    private RestControllerXmlMapper restControllerXmlMapper;

    @GetMapping("/viewXmlRest1")
    public ModelAndView student(ModelMap map) {
        StudentTO studentTO = restControllerXmlMapper.getStudentForXml(1);
        map.put("name", studentTO.getName());
        map.put("age", studentTO.getAge());
        map.put("id", studentTO.getId());
        return new ModelAndView("/view.html");
    }

    @GetMapping("/viewXmlRest2")
    public ModelAndView student2(ModelMap map) {
        StudentTO studentTO = restControllerXmlMapper.getStudentForXml(2);
        map.put("name", studentTO.getName());
        map.put("age", studentTO.getAge());
        map.put("id", studentTO.getId());
        return new ModelAndView("/view.html");
    }
}
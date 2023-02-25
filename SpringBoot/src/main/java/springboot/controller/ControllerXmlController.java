package springboot.controller;

import domain.StudentTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import springboot.mapper.ControllerXmlMapper;

/**
 * @author huyingzhao
 * 2022-01-23 19:11:07
 * may return ModelAndView,also reture String
 */
@Controller
public class ControllerXmlController {
    @Autowired
    private ControllerXmlMapper controllerXmlMapper;

    @GetMapping("/viewXml1")
    public String student(ModelMap map) {
        StudentTO studentTO = controllerXmlMapper.getStudentForXml(1);
        map.put("name", studentTO.getName());
        map.put("age", studentTO.getAge());
        map.put("id", studentTO.getId());
        return "/view.html";
    }

    @GetMapping("/viewXml2")
    public String student2(ModelMap map) {
        StudentTO studentTO = controllerXmlMapper.getStudentForXml(2);
        map.put("name", studentTO.getName());
        map.put("age", studentTO.getAge());
        map.put("id", studentTO.getId());
        return "/view.html";
    }
}

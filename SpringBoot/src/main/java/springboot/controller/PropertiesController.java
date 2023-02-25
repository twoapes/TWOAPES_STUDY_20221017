package springboot.controller;

import domain.StudentTO;
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
public class PropertiesController {
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
    @Autowired
    private StudentTO studentTO;

    /**
     * using object get properties
     */
    @GetMapping({"/properties"})
    @ResponseBody
    public ObjectResult<String> properties() {
        String str = "";
        str += "id:" + studentTO.getId()+"\n";
        str += "name:" + studentTO.getName();
        return ObjectResult.success("", str);
    }

    /**
     * using placeholder pass attribute
     */
    @GetMapping("/placeholder")
    @ResponseBody
    public ObjectResult<String> placeholder() {
        String str = "";
        str += "id:" + id+"\n";
        str += "name:" + name;
        return ObjectResult.success("", str);
    }
}

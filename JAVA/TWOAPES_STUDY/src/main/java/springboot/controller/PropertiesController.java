package springboot.controller;

import domain.PropertiesDo;
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
@Api(value = "PropertiesController", tags = "using Properties")
public class PropertiesController {
    /**
     * placeholder {...}
     */
    @Value("${url.param}")
    private String param;
    /**
     * placeholder {...}
     */
    @Value("${url.paramId}")
    private int paramId;
    @Autowired
    private PropertiesDo propertiesDo;

    /**
     * using object get properties
     */
    @GetMapping({"/properties"})
    @ResponseBody
    public ObjectResult<String> properties() {
        String str = "";
        str += "param:" + propertiesDo.getParam()+"\n";
        str += "paramId:" + propertiesDo.getParamId();
        return ObjectResult.success("", str);
    }

    /**
     * using placeholder pass attribute
     */
    @GetMapping("/placeholder")
    @ResponseBody
    public ObjectResult<String> placeholder() {
        String str = "";
        str += "param:" + param+"\n";
        str += "paramId:" + paramId;
        return ObjectResult.success("", str);
    }
}

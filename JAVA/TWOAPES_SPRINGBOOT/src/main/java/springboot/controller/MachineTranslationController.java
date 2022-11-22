package springboot.controller;

import domain.MachineTranslationDo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import page.ObjectResult;
import util.CharsetUtil;
import util.MachineTranslationUtil;

/**
 * @author add by huyingzhao
 * 2022-08-22 10:22
 */
@Controller
@RequestMapping("/machine")
@Api(value = "MachineTranslationController", tags = "MachineTranslation")
public class MachineTranslationController {
    private MachineTranslationDo machineTranslationDo;

    @Autowired
    public void setMachineTranslationDo(MachineTranslationDo machineTranslationDo) {
        this.machineTranslationDo = machineTranslationDo;
    }

    @ApiOperation(value = "select machine")
    @PostMapping("/machine")
    @ResponseBody
    public ObjectResult<String> machine(@RequestParam @ApiParam(required = true, value = "from") String from,
                                        @RequestParam @ApiParam(required = true, value = "to") String to,
                                        @RequestParam @ApiParam(required = true, value = "text") String text) {
        String str = MachineTranslationUtil.machine(CharsetUtil.UTF_8, machineTranslationDo.getId(), machineTranslationDo.getSecret(), machineTranslationDo.getKey(), from, to, text);
        return ObjectResult.success("success", str);
    }

    @ApiOperation(value = "ChineseToEnglish")
    @PostMapping("/machineToEn")
    @ResponseBody
    public ObjectResult<String> machineToEn(@RequestParam @ApiParam(required = true, value = "text") String text) {
        String str = MachineTranslationUtil.machine(CharsetUtil.UTF_8, machineTranslationDo.getId(), machineTranslationDo.getSecret(), machineTranslationDo.getKey(), "cn", "en", text);
        return ObjectResult.success("success", str);
    }

    @ApiOperation(value = "EnglishToChinese")
    @PostMapping("/machineToCn")
    @ResponseBody
    public ObjectResult<String> machineToCn(@RequestParam @ApiParam(required = true, value = "text") String text) {
        String str = MachineTranslationUtil.machine(CharsetUtil.UTF_8, machineTranslationDo.getId(), machineTranslationDo.getSecret(), machineTranslationDo.getKey(), "en", "cn", text);
        return ObjectResult.success("success", str);
    }
}

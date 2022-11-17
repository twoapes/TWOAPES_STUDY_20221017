package springboot.controller;

import dto.ExportVocabularyDTO;
import dto.QueryVocabularyDTO;
import dto.VocabularyDTO;
import enums.ISO8601Enum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import page.ObjectResult;
import page.PageResult;
import springboot.enums.VOCEnum;
import springboot.service.VocabularyService;
import util.CharsetUtil;
import util.DateUtil;
import util.XlsxUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

/**
 * @author add by huyingzhao
 * 2022-05-25 16:37
 */
@Controller
@Slf4j
@RequestMapping("/code")
@Api(value = "VocabularyController", tags = "Vocabulary")
public class VocabularyController {
    @Autowired
    private VocabularyService vocabularyService;

    /**
     * @param name  name
     * @param value value
     * @return saveJava
     * @author add by huyingzhao
     * 2022-07-22 22:55
     */
    @ApiOperation(value = "save a Java Code(single)")
    @PostMapping("/saveJava")
    @ResponseBody
    public ObjectResult<VocabularyDTO> saveJava(@RequestParam @ApiParam(value = "name") String name,
                                                   @RequestParam @ApiParam(value = "value") String value) {
        QueryVocabularyDTO queryVocabularyDTO = new QueryVocabularyDTO();
        queryVocabularyDTO.setName(name);
        queryVocabularyDTO.setValue(value);
        queryVocabularyDTO.setType(VOCEnum.JAVA.name());
        Date date = DateUtil.nowTime();
        queryVocabularyDTO.setCreateTime(date);
        queryVocabularyDTO.setLastModifyTime(date);
        return vocabularyService.insert(queryVocabularyDTO);
    }

    /**
     * @param name  name
     * @param value value
     * @return saveEnglish
     * @author add by huyingzhao
     * 2022-07-22 22:55
     */
    @ApiOperation(value = "save a English(single)")
    @PostMapping("/saveEnglish")
    @ResponseBody
    public ObjectResult<VocabularyDTO> saveEnglish(@RequestParam @ApiParam(value = "name") String name,
                                                      @RequestParam @ApiParam(value = "value") String value) {
        QueryVocabularyDTO queryVocabularyDTO = new QueryVocabularyDTO();
        queryVocabularyDTO.setName(name);
        queryVocabularyDTO.setValue(value);
        queryVocabularyDTO.setType(VOCEnum.ENGLISH.name());
        Date date = DateUtil.nowTime();
        queryVocabularyDTO.setCreateTime(date);
        queryVocabularyDTO.setLastModifyTime(date);
        return vocabularyService.insert(queryVocabularyDTO);
    }

    /**
     * @param name  name
     * @param value value
     * @return saveIdiom
     * @author add by huyingzhao
     * 2022-07-22 22:55
     */
    @ApiOperation(value = "save idiom(single)")
    @PostMapping("/saveIdiom")
    @ResponseBody
    public ObjectResult<VocabularyDTO> saveIdiom(@RequestParam @ApiParam(value = "name") String name,
                                                    @RequestParam @ApiParam(value = "value") String value) {
        QueryVocabularyDTO queryVocabularyDTO = new QueryVocabularyDTO();
        queryVocabularyDTO.setName(name);
        queryVocabularyDTO.setValue(value);
        queryVocabularyDTO.setType(VOCEnum.IDIOM.name());
        Date date = DateUtil.nowTime();
        queryVocabularyDTO.setCreateTime(date);
        queryVocabularyDTO.setLastModifyTime(date);
        return vocabularyService.insert(queryVocabularyDTO);
    }


    /**
     * @param id    id
     * @param name  name
     * @param value value
     * @param type  type
     * @return edit
     * @author add by huyingzhao
     * 2022-07-22 22:54
     */
    @ApiOperation(value = "edit(single)")
    @PostMapping("/edit")
    @ResponseBody
    public ObjectResult<Long> edit(@RequestParam @ApiParam(value = "id") String id,
                                   @RequestParam(required = false) @ApiParam(value = "name") String name,
                                   @RequestParam(required = false) @ApiParam(value = "value") String value,
                                   @RequestParam(required = false) @ApiParam(value = "type") String type) {

        VocabularyDTO vocabularyDTO = vocabularyService.findOne(id);
        if (name != null) {
            vocabularyDTO.setName(name);
        }
        if (value != null) {
            vocabularyDTO.setValue(value);
        }
        if (type != null) {
            vocabularyDTO.setType(type);
        }

        return vocabularyService.edit(vocabularyDTO);
    }

    /**
     * @param index index
     * @param size  size
     * @param is    is
     * @return queryPage
     * @author add by huyingzhao
     * 2022-06-10 21:51
     */
    @ApiOperation(value = "queryPage(page)")
    @PostMapping("/queryPage")
    @ResponseBody
    public PageResult<List<VocabularyDTO>> queryPage(@RequestParam @ApiParam(value = "index") int index,
                                                        @RequestParam @ApiParam(value = "size") int size,
                                                        @RequestParam @ApiParam(value = "type") String type,
                                                        @RequestParam(required = false) @ApiParam(value = "name") String name,
                                                        @RequestParam(required = false) @ApiParam(value = "is accurate query") boolean is) {
        QueryVocabularyDTO queryVocabularyDTO = new QueryVocabularyDTO();
        queryVocabularyDTO.setName(name);
        queryVocabularyDTO.setType(type);
        return vocabularyService.query(is, queryVocabularyDTO, index, size);
    }

    /**
     * @param id id
     * @return delete
     * @author add by huyingzhao
     * 2022-05-25 17:15
     */
    @ApiOperation(value = "delete(single)")
    @PostMapping("/delete")
    @ResponseBody
    public ObjectResult<Long> delete(@RequestParam @ApiParam(value = "id") String id) {
        return vocabularyService.delete(id);
    }

    /**
     * @param index    index
     * @param size     size
     * @param type     type
     * @param name     name
     * @param is       is
     * @param response response
     * @author add by huyingzhao
     * 2022-07-23 13:44
     */
    @ApiOperation(value = "export(page)")
    @PostMapping("/export")
    @ResponseBody
    public void export(@RequestParam @ApiParam(value = "index") int index,
                       @RequestParam @ApiParam(value = "size") int size,
                       @RequestParam(required = false) @ApiParam(value = "type") String type,
                       @RequestParam(required = false) @ApiParam(value = "name") String name,
                       @RequestParam(required = false) @ApiParam(value = "is accurate query") boolean is,
                       HttpServletResponse response) {
        ExportVocabularyDTO exportVocabularyDTO = new ExportVocabularyDTO();
        exportVocabularyDTO.setName(name);
        exportVocabularyDTO.setType(type);
        PageResult<List<VocabularyDTO>> listPageResult = vocabularyService.query(is, exportVocabularyDTO, index, size);
        export(listPageResult, response);
    }

    /**
     * @param listPageResult listPageResult
     * @param response       response
     * @author add by huyingzhao
     * 2022-07-23 13:25
     */
    private void export(PageResult<List<VocabularyDTO>> listPageResult, HttpServletResponse response) {
        try {
            Charset utf_8=CharsetUtil.UTF_8;
            XlsxUtils.start();
            String fileName = export(listPageResult.getData());
            fileName = fileName + DateUtil.format(DateUtil.nowTime(), ISO8601Enum.YYYYMMDD) + ".xlsx";
            fileName = URLEncoder.encode(fileName,utf_8);
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            fileName = new String(fileName.getBytes(utf_8), CharsetUtil.ISO_8859_1);
            response.setCharacterEncoding(utf_8.name());
            response.addHeader("Content-Disposition", String.format("attachment;filename=\"%s\"", fileName));
            XlsxUtils.end(response.getOutputStream());
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * @param list list
     * @return export
     * @author add by huyingzhao
     * 2022-07-23 13:49
     */
    private String export(List<VocabularyDTO> list) {
        String fileName = "code";
        XlsxUtils.writXlsx("Sheet1", list);
        return fileName;
    }
}
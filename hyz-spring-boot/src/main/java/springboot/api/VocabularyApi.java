package springboot.api;

import enums.ISO8601;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import page.ObjectResult;
import page.PageResult;
import springboot.domain.transformation.VocabularyTransformation;
import springboot.domain.vocabulary.VocabularyDML;
import springboot.domain.vocabulary.VocabularyQueryPage;
import springboot.domain.vocabulary.VocabularyVO;
import springboot.service.VocabularyService;
import util.CharsetUtil;
import util.DateUtil;
import util.XlsxUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * @author add by huyingzhao
 * 2022-05-25 16:37
 */
@Controller
@Slf4j
@RequestMapping("/code")
@Api(value = "VocabularyApi", tags = "vocabularyApi")
public class VocabularyApi {
    private final VocabularyService vocabularyService;

    @Autowired
    public VocabularyApi(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    /**
     * @param name  name
     * @param value value
     * @return saveEnglish
     * @author add by huyingzhao
     * 2022-07-22 22:55
     */
    @ApiOperation(value = "save a code(single)")
    @PostMapping("/save")
    @ResponseBody
    public ObjectResult<VocabularyVO> save(@RequestParam @ApiParam(value = "name") String name,
                                           @RequestParam @ApiParam(value = "value") String value) {
        VocabularyDML vocabulary = new VocabularyDML();
        vocabulary.setName(name);
        vocabulary.setValue(value);
        Date date = DateUtil.nowTime();
        vocabulary.setCreateTime(date);
        vocabulary.setLastModifyTime(date);
        return vocabularyService.insert(vocabulary);
    }

    /**
     * @param id    id
     * @param name  name
     * @param value value
     * @return edit
     * @author add by huyingzhao
     * 2022-07-22 22:54
     */
    @ApiOperation(value = "edit(single)")
    @PostMapping("/edit")
    @ResponseBody
    public ObjectResult<Long> edit(@RequestParam @ApiParam(value = "id") String id,
                                   @RequestParam(required = false) @ApiParam(value = "name") String name,
                                   @RequestParam(required = false) @ApiParam(value = "value") String value) {
        VocabularyDML vocabulary = VocabularyTransformation.getVocabularyDML(vocabularyService.findOne(id));
        if (name != null) {
            vocabulary.setName(name);
        }
        if (value != null) {
            vocabulary.setValue(value);
        }
        return vocabularyService.edit(vocabulary);
    }

    /**
     * @param pageNumber pageNumber
     * @param pageSize   pageSize
     * @param is         is
     * @return queryPage
     * @author add by huyingzhao
     * 2022-06-10 21:51
     */
    @ApiOperation(value = "queryPage(page)")
    @PostMapping("/queryPage")
    @ResponseBody
    public PageResult<VocabularyVO> queryPage(@RequestParam @ApiParam(value = "pageNumber") int pageNumber,
                                              @RequestParam @ApiParam(value = "pageSize") int pageSize,
                                              @RequestParam(required = false) @ApiParam(value = "name") String name,
                                              @RequestParam(required = false) @ApiParam(value = "is accurate query") boolean is) {
        VocabularyQueryPage vocabularyQueryPage = new VocabularyQueryPage();
        vocabularyQueryPage.setName(name);
        vocabularyQueryPage.setPageNumber(pageNumber);
        vocabularyQueryPage.setPageSize(pageSize);
        return vocabularyService.query(is, vocabularyQueryPage);
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
     * @param pageNumber pageNumber
     * @param pageSize   pageSize
     * @param name       name
     * @param is         is
     * @param response   response
     * @author add by huyingzhao
     * 2022-07-23 13:44
     */
    @ApiOperation(value = "export(page)")
    @RequestMapping(value = "/export", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void export(@RequestParam @ApiParam(value = "index") int pageNumber,
                       @RequestParam @ApiParam(value = "size") int pageSize,
                       @RequestParam(required = false) @ApiParam(value = "name") String name,
                       @RequestParam(required = false) @ApiParam(value = "is accurate query") boolean is,
                       HttpServletResponse response) {
        VocabularyQueryPage vocabularyQueryPage = new VocabularyQueryPage();
        vocabularyQueryPage.setName(name);
        vocabularyQueryPage.setPageNumber(pageNumber);
        vocabularyQueryPage.setPageSize(pageSize);
        PageResult<VocabularyVO> listPageResult = vocabularyService.query(is, vocabularyQueryPage);
        export(listPageResult, response);
    }

    /**
     * @param listPageResult listPageResult
     * @param response       response
     * @author add by huyingzhao
     * 2022-07-23 13:25
     */
    private void export(PageResult<VocabularyVO> listPageResult, HttpServletResponse response) {
        try {
            if (listPageResult.getContent() != null && !listPageResult.getContent().isEmpty()) {
                Charset utf_8 = CharsetUtil.UTF_8;
                XlsxUtil.start();
                String fileName = "voc";
                XlsxUtil.writXlsx("Sheet1", listPageResult.getContent());
                fileName = fileName + DateUtil.format(DateUtil.nowTime(), ISO8601.YYYYMMDD.value()) + ".xlsx";
                fileName = URLEncoder.encode(fileName, utf_8);
                response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
                fileName = new String(fileName.getBytes(utf_8), CharsetUtil.ISO_8859_1);
                response.setCharacterEncoding(utf_8.name());
                response.addHeader("Content-Disposition", String.format("attachment;filename=\"%s\"", fileName));
                XlsxUtil.end(response.getOutputStream());
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
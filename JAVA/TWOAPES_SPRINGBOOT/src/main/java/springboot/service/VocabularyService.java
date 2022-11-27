package springboot.service;

import dto.ExportVocabularyPO;
import dto.VocabularyDTO;
import page.ObjectResult;
import page.PageResult;

import java.util.List;

/**
 * @author add by huyingzhao
 * 2022-06-09 21:09
 */
public interface VocabularyService {
    /**
     * @param vocabularyDTO vocabularyDTO
     * @return insert
     * @author add by huyingzhao
     * 2022-06-01 10:44
     */
    ObjectResult<VocabularyDTO> insert(VocabularyDTO vocabularyDTO);

    /**
     * @param id id
     * @return delete
     * @author add by huyingzhao
     * 2022-06-08 20:21
     */
    ObjectResult<Long> delete(String id);

    /**
     * @param vocabularyDTO vocabularyDTO
     * @return edit data
     */
    ObjectResult<Long> edit(VocabularyDTO vocabularyDTO);

    /**
     * @param id id
     * @return findOne
     */
    VocabularyDTO findOne(String id);

    /**
     * @param vocabularyDTO vocabularyDTO
     * @param index        index
     * @param is           is
     * @param size         size
     * @return query
     */
    PageResult<List<VocabularyDTO>> query(boolean is, VocabularyDTO vocabularyDTO, int index, int size);

    /**
     * @author add by huyingzhao
     * 2022-11-27 16:31
     * @param is is
     * @param vocabularyDTO vocabularyDTO
     * @param index index
     * @param size size
     * @return export
     */
    PageResult<List<ExportVocabularyPO>> export(boolean is, VocabularyDTO vocabularyDTO, int index, int size);
}
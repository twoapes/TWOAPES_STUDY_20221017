package springboot.service;

import dto.VocabularyTO;
import page.ObjectResult;
import page.PageResult;

import java.util.List;

/**
 * @author add by huyingzhao
 * 2022-06-09 21:09
 */
public interface VocabularyService {
    /**
     * @param vocabularyTO vocabularyTO
     * @return insert
     * @author add by huyingzhao
     * 2022-06-01 10:44
     */
    ObjectResult<VocabularyTO> insert(VocabularyTO vocabularyTO);

    /**
     * @param id id
     * @return delete
     * @author add by huyingzhao
     * 2022-06-08 20:21
     */
    ObjectResult<Long> delete(String id);

    /**
     * @param vocabularyTO VocabularyTO
     * @return edit data
     */
    ObjectResult<Long> edit(VocabularyTO vocabularyTO);

    /**
     * @param id id
     * @return findOne
     */
    VocabularyTO findOne(String id);

    /**
     * @param vocabularyTO vocabularyTO
     * @param index        index
     * @param is           is
     * @param size         size
     * @return query
     */
    PageResult<List<VocabularyTO>> query(boolean is, VocabularyTO vocabularyTO, int index, int size);
}
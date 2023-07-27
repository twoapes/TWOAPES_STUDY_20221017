package springboot.service;

import page.ObjectResult;
import page.PageResult;
import springboot.domain.vocabulary.VocabularyDML;
import springboot.domain.vocabulary.VocabularyQueryPage;
import springboot.domain.vocabulary.VocabularyVO;

/**
 * @author add by huyingzhao
 * 2022-06-09 21:09
 */
public interface VocabularyService {
    /**
     * @param vocabulary vocabulary
     * @return insert
     * @author add by huyingzhao
     * 2022-06-01 10:44
     */
    ObjectResult<VocabularyVO> insert(VocabularyDML vocabulary);

    /**
     * @param id id
     * @return delete
     * @author add by huyingzhao
     * 2022-06-08 20:21
     */
    ObjectResult<Long> delete(String id);

    /**
     * @param vocabulary vocabulary
     * @return edit data
     */
    ObjectResult<Long> edit(VocabularyDML vocabulary);

    /**
     * @param id id
     * @return findOne
     */
    VocabularyVO findOne(String id);

    /**
     * @param is         is
     * @param vocabularyQueryPage vocabularyQueryPage
     * @return query
     * @author add by huyingzhao
     * 2023-04-22 12:59
     */
    PageResult<VocabularyVO> query(boolean is, VocabularyQueryPage vocabularyQueryPage);
}
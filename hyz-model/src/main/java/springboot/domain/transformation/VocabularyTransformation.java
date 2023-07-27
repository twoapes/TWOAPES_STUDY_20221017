package springboot.domain.transformation;

import springboot.domain.vocabulary.VocabularyDML;
import springboot.domain.vocabulary.VocabularyVO;

/**
 * @author add by huyingzhao
 * 2023-04-17 16:19
 */
public class VocabularyTransformation {
    public static VocabularyDML getVocabularyDML(VocabularyVO vocabularyVO) {
        VocabularyDML vocabularyDML = new VocabularyDML();
        vocabularyDML.setId(vocabularyVO.getId());
        vocabularyDML.setName(vocabularyVO.getName());
        vocabularyDML.setValue(vocabularyVO.getValue());
        vocabularyDML.setCreateTime(vocabularyVO.getCreateTime());
        vocabularyDML.setLastModifyTime(vocabularyVO.getLastModifyTime());
        return vocabularyDML;
    }

    public static VocabularyVO getVocabularyVO(VocabularyDML vocabularyDML) {
        VocabularyVO vocabulary = new VocabularyVO();
        vocabulary.setId(vocabularyDML.getId());
        vocabulary.setName(vocabularyDML.getName());
        vocabulary.setValue(vocabularyDML.getValue());
        vocabulary.setCreateTime(vocabularyDML.getCreateTime());
        vocabulary.setLastModifyTime(vocabularyDML.getLastModifyTime());
        return vocabulary;
    }
}

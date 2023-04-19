package springboot.service.impl;

import com.mongodb.client.result.DeleteResult;
import springboot.domain.transformation.VocabularyTransformation;
import springboot.domain.vocabulary.VocabularyDML;
import springboot.domain.vocabulary.VocabularyQuery;
import springboot.domain.vocabulary.VocabularyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import page.ObjectResult;
import page.PageResult;
import springboot.service.VocabularyService;
import util.DateUtil;
import util.QueryUtils;
import util.StringUtil;

import java.util.regex.Pattern;

/**
 * @author add by huyingzhao
 * 2022-06-09 21:01
 */
@Service
public class VocabularyServiceImpl implements VocabularyService {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public VocabularyServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * @param vocabularyDML vocabularyDML
     * @return insert
     * @author add by huyingzhao
     * 2022-06-01 10:44
     */
    public ObjectResult<VocabularyVO> insert(VocabularyDML vocabularyDML) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(vocabularyDML.getName()));
        VocabularyVO vocabulary = mongoTemplate.findOne(query, VocabularyVO.class);
        if (vocabulary == null) {
            vocabulary = VocabularyTransformation.getVocabularyVO(vocabularyDML);
            return ObjectResult.success("save success", mongoTemplate.insert(vocabulary));
        } else {
            return ObjectResult.warning("maybe repeat", vocabulary);
        }
    }

    /**
     * @param id id
     * @return delete
     * @author add by huyingzhao
     * 2022-06-08 20:21
     */
    public ObjectResult<Long> delete(String id) {
        Query query = new Query();
        Criteria criteria = Criteria.where("_id").is(id);
        query.addCriteria(criteria);
        DeleteResult deleteResult = mongoTemplate.remove(query, VocabularyVO.class);
        long deleteCount = deleteResult.getDeletedCount();
        if (deleteCount > 0) {
            return ObjectResult.success("id[" + id + "]delete success", deleteCount);
        } else {
            return ObjectResult.warning("id[" + id + "]delete fail", deleteCount);
        }
    }

    /**
     * @param vocabulary vocabulary
     * @return edit data
     */
    public ObjectResult<Long> edit(VocabularyDML vocabulary) {
        if (vocabulary == null) {
            return ObjectResult.warning("no need to update", null);
        }

        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(vocabulary.getId()));
        Update update = new Update();
        update.set("name", vocabulary.getName());
        update.set("value", vocabulary.getValue());
        update.set("last_modify_time", DateUtil.nowTime());
        return ObjectResult.success("edit success", mongoTemplate.upsert(query, update, VocabularyVO.class).getModifiedCount());
    }


    /**
     * @param id id
     * @return findOne
     */
    public VocabularyVO findOne(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, VocabularyVO.class);
    }

    /**
     * @param vocabulary vocabulary
     * @param index      index
     * @param is         is
     * @param size       size
     * @return query
     */
    public PageResult<VocabularyVO> query(boolean is, VocabularyQuery vocabulary, int index, int size) {
        String o = vocabulary.getName();
        Criteria criteria = Criteria.where("_id").ne(null).ne("");
        if (!StringUtil.isEmpty(o)) {
            if (is) {
                criteria.and("name").is(o);
            } else {
                Pattern pattern = Pattern.compile("^.*" + o + ".*$", Pattern.CASE_INSENSITIVE);
                criteria.and("name").regex(pattern);
            }
        }

        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        return QueryUtils.query("query success", mongoTemplate, VocabularyVO.class, index, size, criteria, sort);
    }
}
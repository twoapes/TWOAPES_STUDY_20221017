package springboot.service.impl;

import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import page.ObjectResult;
import page.PageResult;
import dto.VocabularyDTO;
import springboot.service.VocabularyService;
import statics.DateUtils;
import util.QueryUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author add by huyingzhao
 * 2022-06-09 21:01
 */
@Service
public class VocabularyServiceImpl implements VocabularyService {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * @param vocabularyDTO vocabularyDTO
     * @return insert
     * @author add by huyingzhao
     * 2022-06-01 10:44
     */
    public ObjectResult<VocabularyDTO> insert(VocabularyDTO vocabularyDTO) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(vocabularyDTO.getName()));
        VocabularyDTO voc = mongoTemplate.findOne(query, VocabularyDTO.class);
        if (voc == null) {
            return ObjectResult.success("save success", mongoTemplate.insert(vocabularyDTO));
        } else {
            return ObjectResult.warning("maybe repeat", voc);
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
        DeleteResult deleteResult = mongoTemplate.remove(query, VocabularyDTO.class);
        long deleteCount = deleteResult.getDeletedCount();
        if (deleteCount > 0) {
            return ObjectResult.success("id[" + id + "]delete success", deleteCount);
        } else {
            return ObjectResult.warning("id[" + id + "]delete fail", deleteCount);
        }
    }

    /**
     * @param vocabularyDTO vocabularyDTO
     * @return edit data
     */
    public ObjectResult<Long> edit(VocabularyDTO vocabularyDTO) {
        if (vocabularyDTO == null) {
            return ObjectResult.warning("no need to update", null);
        }

        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(vocabularyDTO.getId()));
        Update update = new Update();
        update.set("name", vocabularyDTO.getName());
        update.set("value", vocabularyDTO.getValue());
        update.set("last_modify_time", DateUtils.nowTime());
        return ObjectResult.success("edit success", mongoTemplate.upsert(query, update, VocabularyDTO.class).getModifiedCount());
    }


    /**
     * @param id id
     * @return findOne
     */
    public VocabularyDTO findOne(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, VocabularyDTO.class);
    }

    /**
     * @param vocabularyDTO vocabularyDTO
     * @param index        index
     * @param is           is
     * @param size         size
     * @return query
     */
    public PageResult<List<VocabularyDTO>> query(boolean is, VocabularyDTO vocabularyDTO, int index, int size) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("name", vocabularyDTO.getName());
        if (vocabularyDTO.getType() != null) {
            objectMap.put("type", vocabularyDTO.getType());
        }

        return QueryUtil.query(mongoTemplate, is, objectMap, index, size, VocabularyDTO.class, null, null);
    }
}
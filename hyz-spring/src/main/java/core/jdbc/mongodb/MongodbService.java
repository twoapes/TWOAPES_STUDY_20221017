package core.jdbc.mongodb;

import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

/**
 * @author add by huyingzhao
 * 2022-08-03 21:16
 */
public interface MongodbService {
    /**
     * @param name name
     * @author add by huyingzhao
     * 2022-06-07 21:50
     */
    void createCollection(String name);

    /**
     * @param name     name
     * @param document document
     * @author add by huyingzhao
     * 2022-06-07 21:49
     */
    void insertOne(String name, Document document);

    /**
     * @param name         name
     * @param documentList documentList
     * @author add by huyingzhao
     * 2022-06-07 21:49
     */
    void insert(String name, List<Document> documentList);

    /**
     * @param name name
     * @author add by huyingzhao
     * 2022-06-07 21:59
     */
    FindIterable<Document> select(String name);

    /**
     * @param name name
     * @param var1 var1
     * @param var2 var2
     * @return updateMany
     * @author add by huyingzhao
     * 2022-06-07 22:05
     */
    long updateMany(String name, Bson var1, Bson var2);

    /**
     * @param name name
     * @param var  var
     * @return deleteMany
     * @author add by huyingzhao
     * 2022-06-07 22:08
     */
    long deleteMany(String name, Bson var);
}

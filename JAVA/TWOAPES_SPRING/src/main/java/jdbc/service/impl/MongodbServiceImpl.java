package jdbc.service.impl;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import jdbc.pojo.MongoDBPOJO;
import jdbc.service.MongodbService;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huyingzhao
 * 2022-05-18 9:34
 */
@Slf4j
@Service
public class MongodbServiceImpl implements MongodbService {
    private MongoDBPOJO mongoDBPOJO;
    private MongoClient mongoClient;

    @Autowired
    public void setMongoDBPOJO(MongoDBPOJO mongoDBPOJO) {
        this.mongoDBPOJO = mongoDBPOJO;
    }

    /**
     * @param name name
     * @author add by huyingzhao
     * 2022-06-07 21:50
     */
    public void createCollection(String name) {
        MongoDatabase mongoDatabase = getMongoDatabaseVerify();
        try {
            MongoIterable<String> collectionNames = mongoDatabase.listCollectionNames();
            List<String> collectionNameList = new ArrayList<>();
            for (String collectionName : collectionNames) {
                collectionNameList.add(collectionName);
            }

            if (!collectionNameList.contains(name)) {
                mongoDatabase.createCollection(name);
                log.info("create collection [{}] success",name);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            mongoClient.close();
        }
    }

    /**
     * @param name     name
     * @param document document
     * @author add by huyingzhao
     * 2022-06-07 21:49
     */
    public void insertOne(String name, Document document) {
        MongoDatabase mongoDatabase = getMongoDatabaseVerify();
        try {
            MongoCollection<Document> collection = mongoDatabase.getCollection(name);
            log.info("insertOne [{}] success",name);
            collection.insertOne(document);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            mongoClient.close();
        }
    }

    /**
     * @param name         name
     * @param documentList documentList
     * @author add by huyingzhao
     * 2022-06-07 21:49
     */
    public void insert(String name, List<Document> documentList) {
        MongoDatabase mongoDatabase = getMongoDatabaseVerify();
        try {
            MongoCollection<Document> collection = mongoDatabase.getCollection(name);
            log.info("insert [{}] success",name);
            collection.insertMany(documentList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            mongoClient.close();
        }
    }

    /**
     * @param name name
     * @author add by huyingzhao
     * 2022-06-07 21:59
     */
    public FindIterable<Document> select(String name) {
        MongoDatabase mongoDatabase = getMongoDatabaseVerify();

        try {
            MongoCollection<Document> collection = mongoDatabase.getCollection(name);
            log.info("collection [{}] success",name);
            return collection.find();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        } finally {
            mongoClient.close();
        }
    }

    /**
     * @param name name
     * @param var1 var1
     * @param var2 var2
     * @return updateMany
     * @author add by huyingzhao
     * 2022-06-07 22:05
     */
    public long updateMany(String name, Bson var1, Bson var2) {
        MongoDatabase mongoDatabase = getMongoDatabaseVerify();

        try {
            MongoCollection<Document> collection = mongoDatabase.getCollection(name);
            log.info("collection [{}] success",name);

            UpdateResult updateResult = collection.updateMany(var1, var2);
            if (updateResult.getMatchedCount() > 0) {
                log.info("update [{}] success",name);
            }

            return updateResult.getModifiedCount();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return 0;
        } finally {
            mongoClient.close();
        }
    }

    /**
     * @param name name
     * @param var  var
     * @return deleteMany
     * @author add by huyingzhao
     * 2022-06-07 22:08
     */
    public long deleteMany(String name, Bson var) {
        MongoDatabase mongoDatabase = getMongoDatabaseVerify();

        try {
            MongoCollection<Document> collection = mongoDatabase.getCollection(name);
            log.info("collection [{}] success",name);

            DeleteResult deleteResult = collection.deleteMany(var);
            if (deleteResult.getDeletedCount() > 0) {
                log.info("delete [{}] success",name);
            }

            return deleteResult.getDeletedCount();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return 0;
        } finally {
            mongoClient.close();
        }
    }

    private MongoDatabase getMongoDatabaseVerify() {
        ServerAddress serverAddress = new ServerAddress(mongoDBPOJO.getHost(), mongoDBPOJO.getPort());
        MongoCredential credential = MongoCredential.createScramSha1Credential(mongoDBPOJO.getUsername(), mongoDBPOJO.getSource(), mongoDBPOJO.getPassword().toCharArray());
        MongoClientOptions mongoClientOptions = new MongoClientOptions.Builder().readPreference(ReadPreference.secondaryPreferred()).build();
        mongoClient = new MongoClient(serverAddress, credential, mongoClientOptions);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(mongoDBPOJO.getDatabaseName());
        log.info("database connection success");
        return mongoDatabase;
    }

}
package core.jdbc.mongodb.impl;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import core.entity.MongoDBPOJO;
import core.jdbc.mongodb.MongodbService;
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
    private final MongoDBPOJO mongoDBPOJO;
    private MongoClient mongoClient;

    @Autowired
    public MongodbServiceImpl(MongoDBPOJO mongoDBPOJO) {
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
                log.info("create collection[" + name + "]success");
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
            log.info("select collection[" + name + "]success");
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
            log.info("select collection[" + name + "]success");
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
            log.info("select collection[" + name + "]success");
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
            log.info("select collection[" + name + "]success");

            UpdateResult updateResult = collection.updateMany(var1, var2);
            if (updateResult.getMatchedCount() > 0) {
                log.info("update collection[" + name + "]success");
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
            log.info("select collection[" + name + "]success");

            DeleteResult deleteResult = collection.deleteMany(var);
            if (deleteResult.getDeletedCount() > 0) {
                log.info("delete collection[" + name + "]success");
            }

            return deleteResult.getDeletedCount();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return 0;
        } finally {
            mongoClient.close();
        }
    }

//    private MongoDatabase getMongoDatabaseVerify2() {
//        ServerAddress serverAddress = new ServerAddress(mongoDBPOJO.getHost(), mongoDBPOJO.getPort());
//        MongoCredential credential = MongoCredential.createScramSha1Credential(mongoDBPOJO.getUsername(), mongoDBPOJO.getSource(), mongoDBPOJO.getPassword().toCharArray());
//        MongoClientOptions mongoClientOptions = new MongoClientOptions.Builder().readPreference(ReadPreference.secondaryPreferred()).build();
//        mongoClient = MongoClient(serverAddress, credential, mongoClientOptions);
//        MongoDatabase mongoDatabase = mongoClient.getDatabase(mongoDBPOJO.getDatabaseName());
//        log.info("database connection success");
//        return mongoDatabase;
//    }

    private MongoDatabase getMongoDatabaseVerify() {
        ServerAddress serverAddress = new ServerAddress(mongoDBPOJO.getHost(), mongoDBPOJO.getPort());
//        MongoCredential credential = MongoCredential.createScramSha256Credential(mongoDBPOJO.getUsername(), mongoDBPOJO.getSource(), mongoDBPOJO.getPassword());
        MongoCredential credential = MongoCredential.createScramSha1Credential(mongoDBPOJO.getUsername(), mongoDBPOJO.getSource(), mongoDBPOJO.getPassword().toCharArray());
        List<ServerAddress> seeds = new ArrayList<>();
        seeds.add(serverAddress);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyToClusterSettings(builder -> builder.hosts(seeds))
                .applyToConnectionPoolSettings(builder -> builder.maxSize(100))
                .applyToConnectionPoolSettings(builder -> builder.minSize(5))
                .credential(credential)
                .build();
        mongoClient = MongoClients.create(settings);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(mongoDBPOJO.getDatabaseName());
        log.info("database connection success");
        return mongoDatabase;
    }

}
package cn.neyzoter.module.mongo;


import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

public class TestMongoDBReplSet {
    public static void main(String[] args)  {
        try {
            MongoClient mongoClient = MongoClients.create("mongodb://mongodb:27017");
            MongoDatabase database = mongoClient.getDatabase("mydb");
            MongoCollection<Document> collection = database.getCollection("test");
            Document doc = new Document("name", "MongoDB")
                    .append("type", "database")
                    .append("count", 1)
                    .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                    .append("info", new Document("x", 203).append("y", 102));
            collection.insertOne(doc);
            Document myDoc = collection.find().first();
            /**
             * WriteConcern 的参数说明：
             * 0: Don't wait for acknowledgement from the server
             * 1: Wait for acknowledgement, but don't wait for secondaries to replicate
             * >=2: Wait for one or more secondaries to also acknowledge
             * "majority": Wait for a majority of data bearing nodes to acknowledge
             * "<tag set name>": Wait for one or more secondaries to also acknowledge based on a tag set name
             *
             * https://mongodb.github.io/mongo-java-driver/3.12/javadoc/com/mongodb/WriteConcern.html
             */
            collection.withWriteConcern(WriteConcern.JOURNALED);
            /**
             * ReadPreference的参数说明：
             * https://docs.mongodb.com/manual/core/read-preference-use-cases/index.html
             */
            ReadPreference rp = ReadPreference.secondary(); // 从节点优先
            collection.withReadPreference(rp);
            /**
             * ReadConcern参数说明：
             * https://docs.mongodb.com/manual/reference/read-concern/index.html
             */
            collection.withReadConcern(ReadConcern.MAJORITY); // 读取的数据需要满足大多数节点都同步
            System.out.println(myDoc.toJson());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

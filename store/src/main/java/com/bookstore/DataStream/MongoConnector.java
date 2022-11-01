package com.bookstore.DataStream;

import org.bson.BsonDocument;
import org.bson.BsonInt64;
// import org.bson.Document;
import org.bson.conversions.Bson;
// import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class MongoConnector {

    private static String URI = "mongodb://localhost:27017";

    public static boolean TestConnection() {
        boolean connectionWorks = false;
        try (MongoClient mongoClient = MongoClients.create(URI)) {
            MongoDatabase database = mongoClient.getDatabase("test");
            try {
                Bson command = new BsonDocument("ping", new BsonInt64(1));
                database.runCommand(command);
                System.out.println("Connected successfully to server.");
                connectionWorks = true;
            } catch (MongoException me) {
                System.err.println("An error occurred while attempting to run a command: " + me);
            }
        }
        return connectionWorks;
    }

}

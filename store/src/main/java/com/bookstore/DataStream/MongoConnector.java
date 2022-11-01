package com.bookstore.DataStream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.bson.BsonDocument;
import org.bson.BsonInt64;
// import org.bson.Document;
import org.bson.conversions.Bson;

import com.bookstore.Models.Order;
import com.bookstore.Models.WeeklyOrder;
// import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;

import java.lang.reflect.InvocationTargetException;

public class MongoConnector {

    //Makes sure that we can use classes in our models folder or wherever as long as it has an empty constructor with public variables (or it would need getters/setters)
    static CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(),
    fromProviders(PojoCodecProvider.builder().automatic(true).build()));

    public static final String DB_NAME = "BookStore";
    public static final String WEEKLY_ORDERS_COLLECTION_NAME = "WeeklyOrders";

    private static String URI = "mongodb://localhost:27017";

    public static Boolean TestConnection() {
        return getDatabaseWithCodecAsFunction("test", (Function<MongoDatabase, Boolean>) (MongoDatabase database) -> {
            boolean connectionWorks = false;
            try {
                Bson command = new BsonDocument("ping", new BsonInt64(1));
                database.runCommand(command);
                System.out.println("Connected successfully to server.");
                connectionWorks = true;
            } catch (MongoException me) {
                System.err.println("An error occurred while attempting to run a command: " + me);
            }
            return connectionWorks;
        });
    }

    public static boolean DropCollection(String collection) {
        return getDatabaseWithCodecAsFunction(DB_NAME, (MongoDatabase database) -> {
            try {
                database.getCollection(collection).drop();
                return true;
            } catch (MongoException me) {
                System.err.println("An error occurred while attempting to run a command: " + me);
                return false;
            }
        });
    }

    // Returns the class type and returns true on success and false on failure
    public static <T> List<T> GetClassResults(Class<T> inputType, String collectionName) {

        T newInputType;
        try {
            newInputType = inputType.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        return getDatabaseWithCodecAsFunctionWithParam(DB_NAME,
                newInputType,
                (Function<DataWithDB<T>, List<T>>) (DataWithDB<T> dataWithDB) -> {
                    List<T> results = new ArrayList<T>();
                    try {
                        dataWithDB.database.getCollection(collectionName, dataWithDB.classType).find().forEach((T res) -> {
                            results.add(res);
                        });
                        return results;
                    } catch (MongoException me) {
                        System.err.println("An error occurred while attempting to run a command: " + me);
                        return null;
                    }
                });
    }

    // Returns the class type and returns true on success and false on failure
    private static <T> List<T> GetClassResultsWithFilter(T inputType, Bson bson, String collectionName) {

        return getDatabaseWithCodecAsFunctionWithParam2(DB_NAME,
                inputType,
                bson,
                (Function<Data2WithDB<T, Bson>, List<T>>) (Data2WithDB<T, Bson> data2WithDB) -> {
                    List<T> results = new ArrayList<T>();
                    try {
                        data2WithDB.database.getCollection(collectionName, data2WithDB.classType1).find(data2WithDB.input2).forEach((T res) -> {
                            results.add(res);
                        });
                        return results;
                    } catch (MongoException me) {
                        System.err.println("An error occurred while attempting to run a command: " + me);
                        return null;
                    }
                });
    }

    // Inserts the class type and returns true on success and false on failure
    public static <T> Boolean InsertClass(T input, String collectionName) {

        return getDatabaseWithCodecAsFunctionWithParam(DB_NAME,
                input,
                (Function<DataWithDB<T>, Boolean>) (DataWithDB<T> dataWithDB) -> {
                    try {
                        dataWithDB.database.getCollection(collectionName, dataWithDB.classType).insertOne((dataWithDB.input));
                        return true;
                    } catch (MongoException me) {
                        System.err.println("An error occurred while attempting to run a command: " + me);
                        return false;
                    }
                });
    }

    class SomeContainer<E> {
        private Supplier<E> supplier;

        SomeContainer(Supplier<E> supplier) {
          this.supplier = supplier;
        }

        E createContents() {
          return supplier.get();
        }
      }

    private static void getDatabaseWithCodecAsConsumer(String db, Consumer<MongoDatabase> func) {
        try (MongoClient mongoClient = MongoClients.create(URI)) {
            func.accept(mongoClient.getDatabase(db).withCodecRegistry(pojoCodecRegistry));
        } catch (MongoException me) {
            System.err.println("An error occurred while attempting to run a command: " + me);
        }
    }

    private static <T> T getDatabaseWithCodecAsFunction(String db, Function<MongoDatabase, T> func) {
        try (MongoClient mongoClient = MongoClients.create(URI)) {
            return func.apply(mongoClient.getDatabase(db).withCodecRegistry(pojoCodecRegistry));
        } catch (MongoException me) {
            System.err.println("An error occurred while attempting to run a command: " + me);
            return null;
        }
    }

    private static <I, O> O getDatabaseWithCodecAsFunctionWithParam(String db, I input,
            Function<DataWithDB<I>, O> func) {
        try (MongoClient mongoClient = MongoClients.create(URI)) {
            return func
                    .apply(new DataWithDB<I>(mongoClient.getDatabase(db).withCodecRegistry(pojoCodecRegistry), input));
        } catch (MongoException me) {
            System.err.println("An error occurred while attempting to run a command: " + me);
            return null;
        }
    }

    private static <I, V, O> O getDatabaseWithCodecAsFunctionWithParam2(String db, I input, V input2,
            Function<Data2WithDB<I, V>, O> func) {
        try (MongoClient mongoClient = MongoClients.create(URI)) {
            return func
                    .apply(new Data2WithDB<I, V>(mongoClient.getDatabase(db).withCodecRegistry(pojoCodecRegistry), input, input2));
        } catch (MongoException me) {
            System.err.println("An error occurred while attempting to run a command: " + me);
            return null;
        }
    }

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<Order>();
        orders.add(new Order("accountID2", "OrderID2", null));
        WeeklyOrder order = new WeeklyOrder(orders, null);
        MongoConnector.InsertClass(order, MongoConnector.WEEKLY_ORDERS_COLLECTION_NAME);
        System.out.println(MongoConnector.GetClassResults(WeeklyOrder.class, WEEKLY_ORDERS_COLLECTION_NAME));
    }

}

class DataWithDB<T> {
    public MongoDatabase database;
    public T input;
    public Class<T> classType;

    /**
     * @param database
     * @param input
     */
    public DataWithDB(MongoDatabase database, T input) {
        this.database = database;
        this.input = input;
        this.classType = (Class<T>) input.getClass();
    }

}

class Data2WithDB<T, V> {
    public MongoDatabase database;
    public T input;
    public V input2;
    public Class<T> classType1;
    public Class<V> classType2;

    /**
     * @param database
     * @param input
     */
    public Data2WithDB(MongoDatabase database, T input, V input2) {
        this.database = database;
        this.input = input;
        this.input2 = input2;
        this.classType1 = (Class<T>) input.getClass();
        this.classType2 = (Class<V>) input.getClass();
    }

}

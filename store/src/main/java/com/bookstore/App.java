package com.bookstore;

import com.bookstore.DataStream.MongoConnector;

/**
 * Hello world!
 */
public final class App {
    private App() {
        MongoConnector.TestConnection();
    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        new App();
    }
}

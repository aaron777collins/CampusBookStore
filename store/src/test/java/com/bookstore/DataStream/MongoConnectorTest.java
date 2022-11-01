package com.bookstore.DataStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.bookstore.Models.Account;

public class MongoConnectorTest {
    @Test
    void testDropCollection() {
        MongoConnector.InsertClass(new Account(), "testDropCollection");
        List<Account> accounts = MongoConnector.GetClassResults(Account.class, "testDropCollection");
        assertEquals(accounts.size(), 1);
        MongoConnector.DropCollection("testDropCollection");
        List<Account> accounts2 = MongoConnector.GetClassResults(Account.class, "testDropCollection");
        assertEquals(accounts2.size(), 0);
    }

    @Test
    void testGetClassResults() {
        Account account = new Account();
        MongoConnector.InsertClass(account, "testGetClassResults");
        List<Account> accounts = MongoConnector.GetClassResults(Account.class, "testGetClassResults");
        assertEquals(accounts.size(), 1);
        assertEquals(accounts.get(0), account);
        MongoConnector.DropCollection("testGetClassResults");
    }

    @Test
    void testInsertClass() {
        Account account1 = new Account();
        Account account2 = new Account();
        MongoConnector.InsertClass(account1, "testInsertClass");
        MongoConnector.InsertClass(account2, "testInsertClass");
        List<Account> accounts = MongoConnector.GetClassResults(Account.class, "testInsertClass");
        assertEquals(accounts.size(), 2);
        assertEquals(accounts.get(0), account1);
        assertEquals(accounts.get(1), account2);
        MongoConnector.DropCollection("testInsertClass");
    }

    @Test
    void testTestConnection() {
        assertTrue(MongoConnector.TestConnection(), "The connection to the database exists");
    }
}

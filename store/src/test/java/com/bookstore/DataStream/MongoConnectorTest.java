package com.bookstore.DataStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

import org.junit.jupiter.api.Test;

import com.bookstore.Accounts.AccountHelper;
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
        void testInsertManyClasses() {
        Account account1 = new Account();
        Account account2 = new Account();
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(account1);
        accounts.add(account2);
        MongoConnector.InsertManyClass(accounts, "testInsertManyClass");
        List<Account> accountsRes = MongoConnector.GetClassResults(Account.class, "testInsertManyClass");
        assertEquals(accountsRes.size(), 2);
        assertEquals(accountsRes.get(0), account1);
        assertEquals(accountsRes.get(1), account2);
        MongoConnector.DropCollection("testInsertManyClass");
        }

        @Test
        void testGetClassResultsWithFilter() {
            Account account1 = AccountHelper.makeAccount("test1", "test1");
            Account account2 = AccountHelper.makeAccount("test2", "test2");
            List<Account> accounts = new ArrayList<Account>();
            accounts.add(account1);
            accounts.add(account2);
            MongoConnector.InsertManyClass(accounts, "testGetClassResultsWithFilter");
            List<Account> accountsRes = MongoConnector.GetClassResultsWithFilter(Account.class, eq("firstName", "test1"), "testGetClassResultsWithFilter");
            assertEquals(accountsRes.size(), 1);
            assertEquals(accountsRes.get(0), account1);
            List<Account> accountsRes2 = MongoConnector.GetClassResultsWithFilter(Account.class, eq("firstName", "test2"), "testGetClassResultsWithFilter");
            assertEquals(accountsRes2.size(), 1);
            assertEquals(accountsRes2.get(0), account2);
            MongoConnector.DropCollection("testGetClassResultsWithFilter");
        }

        @Test
        void testRemoveMany() {
            Account account1 = AccountHelper.makeAccount("test1", "test1");
            Account account2 = AccountHelper.makeAccount("test2", "test2");
            Account account3 = AccountHelper.makeAccount("test2", "test2");
            List<Account> accounts = new ArrayList<Account>();
            accounts.add(account1);
            accounts.add(account2);
            accounts.add(account3);
            MongoConnector.InsertManyClass(accounts, "testRemoveMany");
            MongoConnector.RemoveMany(eq("firstName", "test1"),"testRemoveMany" );
            List<Account> accountsRes = MongoConnector.GetClassResults(Account.class, "testRemoveMany");
            assertEquals(accountsRes.size(), 2);
            MongoConnector.RemoveMany(eq("firstName", "test2"),"testRemoveMany" );
            List<Account> accountsRes2 = MongoConnector.GetClassResults(Account.class, "testRemoveMany");
            assertEquals(accountsRes2.size(), 0);
            MongoConnector.DropCollection("testRemoveMany");
        }
    @Test
    void testTestConnection() {
        assertTrue(MongoConnector.TestConnection(), "The connection to the database exists");
    }

}

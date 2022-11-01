package com.bookstore.DataManager;

import java.util.ArrayList;
import java.util.List;

import com.bookstore.Accounts.AccountHelper;
import com.bookstore.DataStream.MongoConnector;
import com.bookstore.Models.Account;
import com.bookstore.Models.Order;
import com.bookstore.Models.WeeklyOrder;

import static com.mongodb.client.model.Filters.eq;

public class DataExample {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<Order>();
        orders.add(new Order("accountID2", "OrderID2", null));
        WeeklyOrder order = new WeeklyOrder(orders, null);
        MongoConnector.InsertClass(order, "someTestExampleForAccounts");
        System.out.println(MongoConnector.GetClassResults(WeeklyOrder.class, "someTestExampleForAccounts"));

        Account account1 = AccountHelper.makeAccount("test1", "test1");
        Account account2 = AccountHelper.makeAccount("test2", "test2");
        Account account3 = AccountHelper.makeAccount("test2", "test2");
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        MongoConnector.InsertManyClass(accounts, "someTestExampleForAccounts");
        List<Account> accountsRes1 = MongoConnector.GetClassResults(Account.class, "someTestExampleForAccounts");
        System.out.println(accountsRes1);
        MongoConnector.RemoveMany(eq("firstName", "test1"),"someTestExampleForAccounts" );
        List<Account> accountsRes2 = MongoConnector.GetClassResults(Account.class, "someTestExampleForAccounts");
        System.out.println(accountsRes2);
        MongoConnector.RemoveMany(eq("firstName", "test2"),"someTestExampleForAccounts" );
        List<Account> accountsRes3 = MongoConnector.GetClassResults(Account.class, "someTestExampleForAccounts");
        System.out.println(accountsRes3);
        MongoConnector.DropCollection("someTestExampleForAccounts");

    }
}

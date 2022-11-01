package com.bookstore.Accounts;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.bookstore.Models.Account;
import com.bookstore.Models.Item;
import com.bookstore.Models.ItemType;
import com.bookstore.Models.Order;

public class AccountHelperTest {
    @Test
    void testMakeAccount() throws InterruptedException {
        MakeAccountTester tester = new MakeAccountTester();
        Thread thread = new Thread(tester);
        thread.start();
        thread.join();
        String accountID1 = tester.getAccountID1();
        String accountID2 = tester.getAccountID2();

        assertNotEquals(accountID1, accountID2);

        MakeAccountTester tester2 = new MakeAccountTester();
        Thread thread2 = new Thread(tester2);
        thread2.start();
        thread2.join();
        String accountID3 = tester2.getAccountID1();
        String accountID4 = tester2.getAccountID2();

        assertNotEquals(accountID3, accountID4);
    }
}

class MakeAccountTester implements Runnable{

    private volatile String accountID1 = null;
    private volatile String accountID2 = null;

    @Override
    public void run() {
        Account account = AccountHelper.makeAccount("firstName", "lastName");
        accountID1 = account.accountID;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Account account2 = AccountHelper.makeAccount("firstName", "lastName");
        accountID1 = account2.accountID;
    }


    public String getAccountID1() {
        return accountID1;
    }
    public String getAccountID2() {
        return accountID2;
    }
}

class MakeAccountTesterSameTime implements Runnable{

    private volatile String accountID1 = null;
    private volatile String accountID2 = null;

    @Override
    public void run() {
        Account account = AccountHelper.makeAccount("firstName", "lastName");
        accountID1 = account.accountID;
        Account account2 = AccountHelper.makeAccount("firstName2", "lastName");
        accountID1 = account2.accountID;
    }


    public String getAccountID1() {
        return accountID1;
    }
    public String getAccountID2() {
        return accountID2;
    }
}

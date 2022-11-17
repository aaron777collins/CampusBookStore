package com.bookstore.Accounts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.bookstore.Models.Account;

public class AccountManagerTest {
    @Test
    void testAccounts() {
        // tests all the accounts
        Account testAccount1 = AccountManager.getAccount("test1", "test1");
        assertEquals("test1", testAccount1.firstName);
        assertEquals("test1", testAccount1.lastName);
        String accountID1 = testAccount1.accountID;
        Account testAccount2 = AccountManager.getAccount("test2", "test2");
        assertEquals("test2", testAccount2.firstName);
        assertEquals("test2", testAccount2.lastName);
        String accountID2 = testAccount2.accountID;
        assertNotEquals(accountID1, accountID2);
        assertTrue(AccountManager.removeAccount("test1", "test1"));
        assertTrue(AccountManager.removeAccount("test2", "test2"));
    }

    @Test
    void testStoreAccount() {
        Account storeAccount = AccountManager.getStoreAccount();
        assertEquals(storeAccount.firstName, AccountManager.STORE_ACCOUNT_NAME);
        assertEquals(storeAccount.lastName, "");
    }
}

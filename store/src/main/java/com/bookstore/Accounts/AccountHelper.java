package com.bookstore.Accounts;

import com.bookstore.Models.Account;

public class AccountHelper {
    public static Account makeAccount(String firstName, String lastName) {
        Account account = new Account(System.currentTimeMillis() + "", firstName, lastName);
        // accountID is the currentTimeMillis right now
        account.accountID = account.accountID + "-" + account.hashCode();
        return account;
    }

}

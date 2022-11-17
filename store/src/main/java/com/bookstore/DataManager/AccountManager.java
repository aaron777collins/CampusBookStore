package com.bookstore.DataManager;

import com.bookstore.Accounts.AccountHelper;
import com.bookstore.DataStream.MongoConnector;
import com.bookstore.Models.Account;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;

import java.util.List;


public class AccountManager {

    public static String STORE_ACCOUNT_NAME = "store";
    public static final String ACCOUNTS_COLLECTION_NAME = "Accounts";

    public static Account getStoreAccount() {
        return getAccount(STORE_ACCOUNT_NAME, "");
    }

    public static boolean removeAccount(String firstName, String lastName) {


        Account account = getAccount(firstName, lastName);

        if (account == null) {
            return false;
        }

        return MongoConnector.RemoveMany(eq("accountID", account.accountID), ACCOUNTS_COLLECTION_NAME);

    }

    public static Account getAccount(String firstName, String lastName) {

        List<Account> accounts =  MongoConnector.GetClassResultsWithFilter(Account.class, and(eq("firstName", firstName), eq("lastName", lastName)), ACCOUNTS_COLLECTION_NAME);

        Account currentAccount = null;

        if (accounts.size() == 0) {
            // Order doesn't exist so we make one and insert it
            currentAccount = AccountHelper.makeAccount(firstName, lastName);
            if(!(MongoConnector.InsertClass(currentAccount, ACCOUNTS_COLLECTION_NAME))) {
                // if it cannot insert new week
                System.err.println("Could not insert new account!");
            }
        } else {
            currentAccount = accounts.get(0);
        }


        return currentAccount;
    }

    public static Account getAccount(String accountID) {
        List<Account> accounts =  MongoConnector.GetClassResultsWithFilter(Account.class, eq("accountID", accountID), ACCOUNTS_COLLECTION_NAME);

        if (accounts.size() == 0) {
            return null;
        } else {
            return accounts.get(0);
        }

    }

}

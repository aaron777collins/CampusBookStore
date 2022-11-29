package com.bookstore.TestCases;

public class TestCases {

    /*
     * Boundary Analysis for item name
     * [a-zA-Z0-9][+-]?[a-zA-Z0-9]
     */

     /*
     * Boundary Analysis for item price
     * [-1234567890123456789024-0-1234567890123456789024][a-zA-Z+-*]
     */

    /* Test Case 1
     * Add Item
     * Precondition: MongoDatabase is available, user is logged in
     * Input Name: aaaaa
     * Input Price: 0
     * Expected output: Item created and stored in database
     * Postcondition: MongoDatabase is available, user is logged in, one more item in database
     */

     /* Test Case 2
     * Add Item
     * Precondition: MongoDatabase is available, user is logged in
     * Input Name: zzzzz
     * Input Price: 0
     * Expected output: Item created and stored in database
     * Postcondition: MongoDatabase is available, user is logged in, one more item in database
     */

     /* Test Case 3
     * Add Item
     * Precondition: MongoDatabase is available, user is logged in
     * Input Name: +++++
     * Input Price: 0
     * Expected output: Item created and stored in database
     * Postcondition: MongoDatabase is available, user is logged in, one more item in database
     */

     /* Test Case 4
     * Add Item
     * Precondition: MongoDatabase is available, user is logged in
     * Input Name: ----
     * Input Price: 0
     * Expected output: Item created and stored in database
     * Postcondition: MongoDatabase is available, user is logged in, one more item in database
     */

     /* Test Case 5
     * Add Item
     * Precondition: MongoDatabase is available, user is logged in
     * Input Name: 00000
     * Input Price: 0
     * Expected output: Item created and stored in database
     * Postcondition: MongoDatabase is available, user is logged in, one more item in database
     */

     /* Test Case 6
     * Add Item
     * Precondition: MongoDatabase is available, user is logged in
     * Input Name: 99999
     * Input Price: 0
     * Expected output: Item created and stored in database
     * Postcondition: MongoDatabase is available, user is logged in, one more item in database
     */

      /* Test Case 7
     * Add Item
     * Precondition: MongoDatabase is available, user is logged in
     * Input Name: aaaaa+++++
     * Input Price: 1234567890123456789024
     * Expected output: Item created and stored in database
     * Postcondition: MongoDatabase is available, user is logged in, one more item in database
     */

       /* Test Case 8
     * Add Item
     * Precondition: MongoDatabase is available, user is logged in
     * Input Name: aaaaa+++++
     * Input Price: 1234567890123456789024
     * Expected output: Item created and stored in database
     * Postcondition: MongoDatabase is available, user is logged in, one more item in database
     */

       /* Test Case 9
     * Add Item
     * Precondition: MongoDatabase is available, user is logged in
     * Input Name: aaaaa000000
     * Input Price: 1234567890123456789024
     * Expected output: Item created and stored in database
     * Postcondition: MongoDatabase is available, user is logged in, one more item in database
     */

       /* Test Case 10
     * Add Item
     * Precondition: MongoDatabase is available, user is logged in
     * Input Name: +++++00000
     * Input Price: 1234567890123456789024
     * Expected output: Item created and stored in database
     * Postcondition: MongoDatabase is available, user is logged in, one more item in database
     */

     /* Test Case 11
     * Add Item
     * Precondition: MongoDatabase is available, user is logged in
     * Input Name: aaaaa
     * Input Price: a
     * Expected output: Error item price is invalid
     * Postcondition: MongoDatabase is available, user is logged in, one more item in database
     */



     // test case for viewing weekly schedule
     /*
      * Test Case View Shifts
      Precondition: MongoDatabase is available, user is logged in
      Input: Opens shifts tab from menu options
      Expected output: Shifts for the week are displayed 
      * Postcondition: MongoDatabase is available, user is logged in
      */

    /*
     * Test Case View Stock
     * Precondition: Mongodatabase is available, user is logged in
     * Input: Opens stocks tab from menu options
     * Expected output: store stock is diplayed on the screen
     * Postcondition: MongoDatabase is available, user is logged in
     */

     /*
      * Test Case View Availability/Personal Schedule
      * Precondition: MongoDatabase is available, user is logged in
      * Input: Opens Change Availability tab from menu options
      * Expected output: Personal weekly schedule is displayed on the screen
      * Postcondition: MongoDatabase is available, user is logged in
     */

    /*
     * Boundary analysis for first and last name
     * valid: [a-zA-Z0-9+-/*]
     * invalid: 30,000 characters of A
     */


    /*Test Case 1
     * Create account
     * Precondition: MongoDatabase is available, user is logged in
     * Input: aaaaa
     * Expected Output: Account created within database
     * Postcondition: MongoDatabase is available, user is logged in, account list increased
     */

     /*Test Case 2
     * Create account
     * Precondition: MongoDatabase is available, user is logged in
     * Input: AAAAA
     * Expected Output: Account created within database
     * Postcondition: MongoDatabase is available, user is logged in, account list increased
     */

     /*Test Case 3
     * Create account
     * Precondition: MongoDatabase is available, user is logged in
     * Input: 00000
     * Expected Output: Account created within database
     * Postcondition: MongoDatabase is available, user is logged in, account list increased
     */

      /*Test Case 4
     * Create account
     * Precondition: MongoDatabase is available, user is logged in
     * Input: +++++
     * Expected Output: Account created within database
  * Postcondition: MongoDatabase is available, user is logged in, account list increased
     */

      /*Test Case 5
     * Create account
     * Precondition: MongoDatabase is available, user is logged in
     * Input: 30,000 * A
     * Expected Output: Account unable to be created within database
     * Postcondition: MongoDatabase is available, user is logged in, account list increased
     */

     // test cases for deleting items
     /*Test case 1
      * Precontitions: MongoDatabase is available, user is logged in, item is selected from table, table columns are not altered
      * Input: Delete button is pressed
      * Expected output: Selected item is removed from database and table GUI
      * Postcondition: MongoDatabase is available, user is logged in, table has one less row
      */

      /*Test Case Sort alphabetically table 1
       * Precondition: MongoDatabase is available, user is logged in, table has rows
       * Input: Select column title once
       * Expected output: Column values will be re-ordered alphabetically by column name field
       * Post condition: Mongodatabase is available, user is logged in, rows are ordered by column name field
       */
}

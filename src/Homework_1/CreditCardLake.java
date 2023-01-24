/* This program has been modified by George Lake
 * CS 2235 Spring 2023 - Dr. Leslie Kerby
 * Homework 1
 *
 *
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
//package dsaj.primer;
package Homework_1;

/**
 * A simple model for a consumer credit card.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class CreditCardLake {
    // Instance variables:
    private String customer;      // name of the customer (e.g., "John Bowman")
    private String bank;          // name of the bank (e.g., "California Savings")
    private String account;       // account identifier (e.g., "5391 0375 9387 5309")
    private int limit;            // credit limit (measured in dollars)
    protected double balance;     // current balance (measured in dollars)

    // Constructors --------------------------------------------------------
    /**
     * Constructs a new credit card instance.
     * @param cust        the name of the customer (e.g., "John Bowman")
     * @param bk          the name of the bank (e.g., "California Savings")
     * @param acnt        the account identifier (e.g., "5391 0375 9387 5309")
     * @param lim         the credit limit (measured in dollars)
     * @param initialBal  the initial balance (measured in dollars)
     */
    public CreditCardLake(String cust, String bk, String acnt, int lim, double initialBal) {
        customer = cust;
        bank = bk;
        account = acnt;
        limit = lim;
        balance = initialBal;
    }

    /**
     * Constructs a new credit card instance with default balance of zero.
     * @param cust    the name of the customer (e.g., "John Bowman")
     * @param bk      the name of the bank (e.g., "California Savings")
     * @param acnt    the account identifier (e.g., "5391 0375 9387 5309")
     * @param lim     the credit limit (measured in dollars)
     */
    public CreditCardLake(String cust, String bk, String acnt, int lim) {
        this(cust, bk, acnt, lim, 0.0);               // use a balance of zero as default
    }

    // Accessor methods ------------------------------------------------
    /** Returns the name of the customer. */
    public String getCustomer() { return customer; }

    /** Returns the name of the bank */
    public String getBank() { return bank; }

    /** Return the account identifier. */
    public String getAccount() { return account; }

    /** Return the credit limit. */
    public int getLimit() { return limit; }

    /** Return the current balance. */
    public double getBalance() { return balance; }

    // Update methods ---------------------------------------------------------
    /**
     * Charges the given price to the card, assuming sufficient credit limit.
     * @param price  the amount to be charged
     * @return true  if charge was accepted; false if charge was denied
     */
    public boolean charge(double price) {               // make a charge
        if (price + balance > limit)                      // if charge would surpass limit
            return false;                                   // refuse the charge
        // at this point, the charge is successful
        balance += price;                                 // update the balance
        return true;                                      // announce the good news
    }

    /**
     * Homework 1.b.
     * Processes customer payment that reduces balance.
     * @param amount  the amount of payment made
     */
    public void makePayment(double amount) {            // make a payment
        if (amount < 0)   // check and see if payment amount is a negative number, print error message if so.
            System.out.println("You cannot enter a negative amount");
        else
            balance -= amount;  // reduce balance if the payment amount is > 0

      }

    /**
     * Homework 1.a.
     * Update method that will overwrite the
     * @param new_limit  the credit limit of the card
     */
    public void updateLimit(int new_limit) {            // update the credit limit
        limit = new_limit;
    }  // updates the credit limit

    // Utility method to print a card's information ---------------------------
    public static void printSummary(CreditCardLake card) {
        System.out.println("Customer = " + card.customer);
        System.out.println("Bank = " + card.bank);
        System.out.println("Account = " + card.account);
        System.out.println("Balance = " + card.balance);  // implicit cast
        System.out.println("Limit = " + card.limit);      // implicit cast
    }

    // MAIN ------------------------------------------------------------------
    public static void main(String[] args) {
        // create 3 new credit cards
        CreditCardLake[] wallet = new CreditCardLake[3];
        wallet[0] = new CreditCardLake("John Bowman", "California Savings",
                "5391 0375 9387 5309", 5000);
        wallet[1] = new CreditCardLake("John Bowman", "California Federal",
                "3485 0399 3395 1954", 3500);
        wallet[2] = new CreditCardLake("John Bowman", "California Finance",
                "5391 0375 9387 5309", 2500, 300);

        // charge different values to each of the 3 credit cards
        for (int val = 1; val <= 16; val++) {
            wallet[0].charge(3*val);
            wallet[1].charge(2*val);
            wallet[2].charge(val);
        }

        // print a summary of each credit card
        // make $200 payments on each card until they are no longer > 200
        // print balance after each payment
        for (CreditCardLake card : wallet) {
            CreditCardLake.printSummary(card);        // calling static method
            while (card.getBalance() > 200.0) {
                card.makePayment(200);
                System.out.println("New balance = " + card.getBalance());
            }
            System.out.println();
        }

        // homework 1.a. testing
        // update the credit limit of wallet[0]
        System.out.println("Homework 1.a. Update credit limit");
        wallet[0].updateLimit(30000);  // update the credit limit via update method
        CreditCardLake.printSummary(wallet[0]);  // print summary of credit card with new limit
        System.out.println();

        // homework 1.b. testing
        // attempt to make a negative payment
        System.out.println("Homework 1.b. Ignore negative payment amount");
        wallet[1].makePayment(-20);  // test to see if a negative number will reduce balance
        System.out.println("New balance = " + wallet[1].getBalance());  // print new balance, should be same as original



    }
}

/*
Output of main:

Customer = John Bowman
Bank = California Savings
Account = 5391 0375 9387 5309
Balance = 408.0
Limit = 5000
New balance = 208.0
New balance = 8.0
Customer = John Bowman
Bank = California Federal
Account = 3485 0399 3395 1954
Balance = 272.0
Limit = 3500
New balance = 72.0
Customer = John Bowman
Bank = California Finance
Account = 5391 0375 9387 5309
Balance = 436.0
Limit = 2500
New balance = 236.0
New balance = 36.0
*/


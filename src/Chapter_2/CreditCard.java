package Chapter_2;

public class CreditCard {
    // instance variables
    private String customer;
    private String bank;
    private String account;
    private int limit;
    protected double balance;

    // constructors
    public CreditCard(String cust, String bk, String acnt, int lim, double initialBal){
        customer = cust;
        bank = bk;
        account = acnt;
        limit = lim;
        balance = initialBal;
    }

    public CreditCard(String cust, String bk, String acnt, int lim) {
        this(cust, bk, acnt, lim, 0.0);
    }

    // methods
    // getters
    public String getCustomer() { return customer; }
    public String getBank() { return bank; }
    public String getAccount() { return account; }
    public int getLimit() { return limit; }
    public double getBalance() { return balance; }

    // methods
    // updaters
    public boolean charge(double price) {
        if (price + balance > limit)
            return false;
        balance += price;
        return true;
    }

    public void makePayment(double amount) {
        balance -= amount;
    }

    public static void printSummary(CreditCard card) {
        System.out.println("Customer = " + card.customer);
        System.out.println("Bank = " + card.bank);
        System.out.println("Account = " + card.account);
        System.out.println("Balance = " + card.balance);
        System.out.println("Limit = " + card.limit);
    }

    // MAIN
    public static void main(String[] args) {
        CreditCard[] wallet = new CreditCard[3];
        wallet[0] = new CreditCard("John Bowman", "California Savings", "1234 5678", 5000);
        wallet[1] = new CreditCard("Jeremiah", "US Bank", "8765 4321", 1000);
        wallet[2] = new CreditCard("Seth", "US Bank", "8765 4321", 1000, 55.5);

        for (CreditCard user : wallet) {
            CreditCard.printSummary(user);

        }
    }
}


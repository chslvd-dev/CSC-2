/**
 * CheckingAccount.java
 * Subclass that inherits from BankAccount.
 * Adds an interest rate attribute and allows overdraft withdrawals.
 * An overdraft charges a flat $30 fee.
 *
 * Critical Thinking Assignment
 * Chris Jayson Salvadora
 */
public class CheckingAccount extends BankAccount {

    // Interest rate attribute specific to a checking account
    private double interestRate;

    // Flat fee charged on any overdraft withdrawal
    private static final double OVERDRAFT_FEE = 30.0;

    // Default constructor passes safe values up to the superclass
    public CheckingAccount() {
        super();
        try {
            this.interestRate = 0.0;
        } catch (Exception e) {
            System.out.println("Failure: constructor error. " + e.getMessage());
        }
    }

    // Parameterized constructor builds the account and sets the interest rate
    public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
        super(firstName, lastName, accountID);
        try {
            this.interestRate = interestRate;
        } catch (Exception e) {
            System.out.println("Failure: constructor error. " + e.getMessage());
        }
    }

    // Getter and setter for the interest rate
    public double getInterestRate() {
        try { return interestRate; }
        catch (Exception e) { return 0.0; }
    }

    public void setInterestRate(double interestRate) {
        try { this.interestRate = interestRate; }
        catch (Exception e) { System.out.println("Failure: set interestRate error. " + e.getMessage()); }
    }

    // Processes a withdrawal that is allowed to overdraw the account.
    // When the withdrawal exceeds the balance, a $30 fee is added and the
    // resulting negative balance is displayed.
    public void processWithdrawal(double amount) {
        try {
            double currentBalance = getBalance();
            if (amount > currentBalance) {
                double newBalance = currentBalance - amount - OVERDRAFT_FEE;
                setBalance(newBalance);
                System.out.printf(
                    "Overdraft: a $%.2f fee has been assessed. New balance: $%.2f%n",
                    OVERDRAFT_FEE, newBalance);
            } else {
                setBalance(currentBalance - amount);
                System.out.printf("Withdrawal complete. New balance: $%.2f%n", getBalance());
            }
        } catch (Exception e) {
            System.out.println("Failure: processWithdrawal error. " + e.getMessage());
        }
    }

    // Displays all superclass attributes plus the interest rate
    public void displayAccount() {
        try {
            accountSummary();
            System.out.printf("Interest Rate: %.2f%%%n", interestRate);
        } catch (Exception e) {
            System.out.println("Failure: displayAccount error. " + e.getMessage());
        }
    }
}

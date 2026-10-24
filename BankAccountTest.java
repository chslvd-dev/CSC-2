/**
 * BankAccountTest.java
 * Test class that drives the BankAccount and CheckingAccount classes.
 * Demonstrates deposits, standard withdrawals, and an overdraft withdrawal
 * that triggers the $30 fee.
 *
 * Critical Thinking Assignment
 * Chris Jayson Salvadora
 */
public class BankAccountTest {

    public static void main(String[] args) {
        try {
            // Test the superclass BankAccount
            System.out.println("=== BankAccount Test ===");
            BankAccount account = new BankAccount("Jordan", "Reyes", 1001);
            account.deposit(500.00);
            account.withdrawal(120.00);
            account.accountSummary();

            System.out.println();

            // Test the subclass CheckingAccount with a normal withdrawal
            System.out.println("=== CheckingAccount Test (standard withdrawal) ===");
            CheckingAccount checking = new CheckingAccount("Alex", "Morgan", 2002, 1.25);
            checking.deposit(300.00);
            checking.processWithdrawal(100.00);
            checking.displayAccount();

            System.out.println();

            // Test the subclass with an overdraft withdrawal that charges the fee
            System.out.println("=== CheckingAccount Test (overdraft withdrawal) ===");
            CheckingAccount overdraft = new CheckingAccount("Sam", "Lee", 3003, 0.75);
            overdraft.deposit(50.00);
            overdraft.processWithdrawal(200.00);
            overdraft.displayAccount();
        } catch (Exception e) {
            System.out.println("Failure: test execution error. " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create the Bank
        Bank myBank = new Bank();

        // Create 3 different account types
        StandardAccount s = new StandardAccount(1, -100); // Account 1, Limit -100
        BasicAccount b = new BasicAccount(2, 50);         // Account 2, Withdraw Limit 50
        PremiumAccount p = new PremiumAccount(3);         // Account 3, No Limit

        // Open the accounts (add them to the bank)
        myBank.OpenAccount(s);
        myBank.OpenAccount(b);
        myBank.OpenAccount(p);

        // Deposit some money to start
        s.Deposit(100);
        b.Deposit(100);
        p.Deposit(100);

        // TEST 1: Standard Account Overdraft
        // Balance 100, Limit -100. Total Available = 200.
        // Try to withdraw 300. Should only give 200.
        System.out.println("Standard Withdraw 300 (Expected 200.0): " + s.Withdraw(300));
        System.out.println("Standard New Balance (Expected -100.0): " + s.GetCurrentBalance());

        // TEST 2: Basic Account Limit
        // Balance 100. Limit 50.
        // Try to withdraw 80. Should only give 50 (limit).
        System.out.println("Basic Withdraw 80 (Expected 50.0): " + b.Withdraw(80));

        // TEST 3: Premium Account No Limit
        // Balance 100.
        // Try to withdraw 500. Should give 500 and go to -400.
        System.out.println("Premium Withdraw 500 (Expected 500.0): " + p.Withdraw(500));

        // TEST 4: Closing Account with Debt
        // Premium account is now at -400.
        // Try to close it. Should fail and print message.
        System.out.println("--- Testing Close Account ---");
        myBank.CloseAccount(3);
    }
}
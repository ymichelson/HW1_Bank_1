public class BasicAccount implements IAccount {
    private int accountNumber;
    private double withdrawalLimit;
    private double balance;

    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;
        this.withdrawalLimit = withdrawalLimit;
        this.balance = 0.0;
    }

    @Override
    public void Deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        double actualRequest = amount;

        // Limit withdrawal amount per request
        if (amount > this.withdrawalLimit) {
            actualRequest = this.withdrawalLimit;
        }

        // Basic accounts cannot go into overdraft
        if (actualRequest > this.balance) {
            actualRequest = this.balance;
        }

        this.balance -= actualRequest;
        return actualRequest;
    }

    @Override
    public double GetCurrentBalance() {
        return this.balance;
    }

    @Override
    public int GetAccountNumber() {
        return this.accountNumber;
    }
}
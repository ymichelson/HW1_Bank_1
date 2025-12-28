public class StandardAccount implements IAccount {
    private int accountNumber;
    private double creditLimit;
    private double balance;

    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;

        // Credit limit should strictly be negative or zero
        if (creditLimit > 0) {
            this.creditLimit = 0;
        } else {
            this.creditLimit = creditLimit;
        }
    }

    @Override
    public void Deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        double maxCanWithdraw = this.balance - this.creditLimit;

        if (amount > maxCanWithdraw) {
            this.balance -= maxCanWithdraw;
            return maxCanWithdraw;
        } else {
            this.balance -= amount;
            return amount;
        }
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
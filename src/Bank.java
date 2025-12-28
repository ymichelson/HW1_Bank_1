import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {
    private List<IAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    @Override
    public void OpenAccount(IAccount account) {
        this.accounts.add(account);
    }

    @Override
    public void CloseAccount(int accountNumber) {
        IAccount accountToClose = null;

        for (IAccount acc : this.accounts) {
            if (acc.GetAccountNumber() == accountNumber) {
                accountToClose = acc;
                break;
            }
        }

        if (accountToClose == null) {
            return;
        }

        if (accountToClose.GetCurrentBalance() < 0) {
            System.out.println("Account not closed due to debt");
        } else {
            this.accounts.remove(accountToClose);
        }
    }

    @Override
    public List<IAccount> GetAllAccounts() {
        return this.accounts;
    }

    @Override
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> debtAccounts = new ArrayList<>();
        for (IAccount acc : this.accounts) {
            if (acc.GetCurrentBalance() < 0) {
                debtAccounts.add(acc);
            }
        }
        return debtAccounts;
    }

    @Override
    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> richAccounts = new ArrayList<>();
        for (IAccount acc : this.accounts) {
            if (acc.GetCurrentBalance() > balanceAbove) {
                richAccounts.add(acc);
            }
        }
        return richAccounts;
    }
}
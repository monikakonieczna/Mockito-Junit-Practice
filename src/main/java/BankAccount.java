import exception.WithdrawException;

public class BankAccount {

    private double balance;
    private double minimumBalance;

    public BankAccount(double balance, double minimumBalance) {
        this.balance = balance;
        this.minimumBalance = minimumBalance;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public double withdraw(double amount) throws WithdrawException {
        if(balance - amount > minimumBalance){
            balance -= amount;
            return amount;
        } else {
            throw new WithdrawException("You can't exceed minimum balance!");
        }
    }

    public double deposit(double amount){
        return balance += amount;
    }
}

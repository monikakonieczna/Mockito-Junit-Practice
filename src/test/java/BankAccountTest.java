import exception.WithdrawException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test BankAccount class")
public class BankAccountTest {

    @Test
    @DisplayName("Withdraw 500 successfully")
    public void testWithdraw() throws WithdrawException {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Withdraw will become negative")
    public void testWithdrawNotStuckAtZero() throws WithdrawException {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(800);
        assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 400 successfully")
    public void testDeposit(){
        BankAccount bankAccount = new BankAccount(400, 0);
        bankAccount.deposit(500);
        assertEquals(900, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Test that we cannot withdraw below minimum")
    public void testExceptionWhenWithdrawBelowMinimum() throws WithdrawException {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertThrows(WithdrawException.class, () -> bankAccount.withdraw(2000));

    }
}

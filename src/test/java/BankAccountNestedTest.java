import exception.WithdrawException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test BankAccount class")
public class BankAccountNestedTest {


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


    @Nested
    class WhenBalanceEqualsZero{

        @Test
        @DisplayName("Test that we cannot withdraw below minimum -> Withdraw Exception")
        public void testWithdrawMinimumBalance0() {
            BankAccount bankAccount = new BankAccount(0, 0);
            assertThrows(WithdrawException.class, () -> bankAccount.withdraw(500));
        }

        @Test
        @DisplayName("Withdraw 500 successfully and getting negative balance")
        public void testWithdrawMinimumBalanceNegative1000() throws WithdrawException {
            BankAccount bankAccount = new BankAccount(0, -1000);
            bankAccount.withdraw(500);
            assertEquals(-500, bankAccount.getBalance());
        }
    }
}

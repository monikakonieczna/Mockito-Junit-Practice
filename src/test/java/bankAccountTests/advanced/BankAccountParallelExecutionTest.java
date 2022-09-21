package bankAccountTests.advanced;

import bankAccount.BankAccount;
import exception.WithdrawException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelExecutionTest {

    @Test
    @DisplayName("Deposit 400 successfully")
    public void testDeposit(BankAccount bankAccount) {
        bankAccount.deposit(500);
        Assertions.assertEquals(500, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Withdraw 500 successfully")
    public void testWithdraw(BankAccount bankAccount) throws WithdrawException {
        bankAccount.deposit(500);
        bankAccount.withdraw(300);
        Assertions.assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @Disabled("Temporarily disabled due to maintenance")
    @DisplayName("Withdraw will become negative")
    public void testWithdrawNotStuckAtZero(BankAccount bankAccount) throws WithdrawException {
        bankAccount.deposit(900);
        bankAccount.withdraw(100);
        Assertions.assertNotEquals(-800, bankAccount.getBalance());
    }

}

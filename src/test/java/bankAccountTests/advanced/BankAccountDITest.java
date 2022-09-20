package bankAccountTests.advanced;

import bankAccount.BankAccount;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountDITest {

    @Test
    @DisplayName("Deposit 400 successfully")
    public void testDeposit(BankAccount bankAccount) {
        bankAccount.deposit(500);
        Assertions.assertEquals(500, bankAccount.getBalance());
    }
}

package bankAccountTests.advanced;

import bankAccount.BankAccount;
import exception.WithdrawException;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankAccountBeforeAndAfterTest {
    static BankAccount bankAccount;

    @BeforeAll
    public void prepareTest() {
        bankAccount = new BankAccount(500, 0);
    }

    @Test
    public void testWithdraw() throws WithdrawException {
        bankAccount.withdraw(300);
        Assertions.assertEquals(200, bankAccount.getBalance());

    }

    @Test
    public void testDeposit() {
        bankAccount.deposit(500);
        Assertions.assertEquals(700, bankAccount.getBalance());
    }

    @AfterAll
    public void cleanAfterTests(){
        System.out.println("Cleaning after tests execution...");
    }
}

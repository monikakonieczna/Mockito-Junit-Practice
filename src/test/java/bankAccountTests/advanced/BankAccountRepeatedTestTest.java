package bankAccountTests.advanced;

import bankAccount.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepeatedTestTest {

    @RepeatedTest(2)
    @DisplayName("Deposit 400 successfully")
    public void testDeposit(BankAccount bankAccount) {
        bankAccount.deposit(500);
        Assertions.assertEquals(500, bankAccount.getBalance());
    }

    @RepeatedTest(2)
    @DisplayName("Deposit 400 successfully")
    public void testDepositRepetitionInfo(BankAccount bankAccount, RepetitionInfo repetitionInfo) {
        bankAccount.deposit(500);
        Assertions.assertEquals(500, bankAccount.getBalance());
        System.out.println("Nr: " + repetitionInfo.getCurrentRepetition());
    }

}

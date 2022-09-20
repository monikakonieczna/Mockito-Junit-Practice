package bankAccountTests.advanced;

import bankAccount.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParametrizedTest {

    @ParameterizedTest
    //@ValueSource(ints = {100, 400, 800, 1000})
    @CsvFileSource(resources = "details.csv")
    @DisplayName("Depositing successfully")
    public void testDepositValueSource(int amount, BankAccount bankAccount) {
        bankAccount.deposit(amount);
        Assertions.assertEquals(amount, bankAccount.getBalance());
    }

    @CsvSource({"100, Mary","200, Rachid"})
    @ParameterizedTest
    public void depositAndNameTest(double amount, String name, BankAccount bankAccount) {
        bankAccount.deposit(amount);
        bankAccount.setHolderName(name);
        assertEquals(amount, bankAccount.getBalance());
        assertEquals(name, bankAccount.getHolderName());
    }

}

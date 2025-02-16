import static org.junit.jupiter.api.Assertions.*;

import com.week4.day5.Junit.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
    public class BankAccountTest {
        private BankAccount account;

        @BeforeEach
        void setUp() {
            account = new BankAccount(1000.0); // Initial balance
        }

        @Test
        void testDeposit() {
            account.deposit(500);
            assertEquals(1500.0, account.getBalance());
        }

        @Test
        void testWithdraw() {
            account.withdraw(400);
            assertEquals(600.0, account.getBalance());
        }

        @Test
        void testWithdrawInsufficientFunds() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                account.withdraw(2000);
            });
            assertEquals("Insufficient funds", exception.getMessage());
        }

        @Test
        void testNegativeDeposit() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                account.deposit(-100);
            });
            assertEquals("Deposit amount must be positive", exception.getMessage());
        }

        @Test
        void testNegativeWithdrawal() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                account.withdraw(-50);
            });
            assertEquals("Withdrawal amount must be positive", exception.getMessage());
        }
    }



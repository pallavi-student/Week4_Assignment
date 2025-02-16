import static org.junit.jupiter.api.Assertions.*;

import com.week4.day5.Junit.PasswordValidator;
import org.junit.jupiter.api.Test;
public class PasswordValidatorTest {
        @Test
        void testValidPasswords() {
            assertTrue(PasswordValidator.isValidPassword("Password1"));
            assertTrue(PasswordValidator.isValidPassword("StrongPass99"));
        }
        @Test
        void testInvalidPasswords() {
            assertFalse(PasswordValidator.isValidPassword("password"));
            assertFalse(PasswordValidator.isValidPassword("PASSWORD"));
            assertFalse(PasswordValidator.isValidPassword("Pass1"));
            assertFalse(PasswordValidator.isValidPassword("12345678"));
            assertFalse(PasswordValidator.isValidPassword(null));
            assertFalse(PasswordValidator.isValidPassword(""));
        }
    }



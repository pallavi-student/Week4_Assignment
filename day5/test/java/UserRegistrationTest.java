import static org.junit.jupiter.api.Assertions.*;

import com.week4.day5.Junit.UserRegistration;
import org.junit.jupiter.api.Test;
    public class UserRegistrationTest {
        @Test
        void testValidUserRegistration() {
            assertEquals("User registered successfully: JohnDoe",
                    UserRegistration.registerUser("JohnDoe", "john.doe@example.com","Password1"));
        }@Test
        void testInvalidUsername() {
            Exception exception = assertThrows(IllegalArgumentException.class,
                    () -> UserRegistration.registerUser("", "john.doe@example.com", "Password1"));
            assertEquals("Username cannot be empty.", exception.getMessage());
        }
        @Test
        void testInvalidEmail() {
            Exception exception = assertThrows(IllegalArgumentException.class,
                    () -> UserRegistration.registerUser("JohnDoe", "invalid.email", "Password1"));
            assertEquals("Invalid email format ", exception.getMessage());
        }@Test
        void testInvalidPassword() {
            Exception exception = assertThrows(IllegalArgumentException.class,
                    () -> UserRegistration.registerUser("JohnDoe", "john.doe@example.com", "weakpass"));
            assertEquals("Password be 8 characters,contain one uppercase letter,and one digit.",exception.getMessage());
        }
    }



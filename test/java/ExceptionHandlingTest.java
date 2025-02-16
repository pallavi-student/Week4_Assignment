import static org.junit.jupiter.api.Assertions.*;

import com.week4.day5.Junit.ExceptionHandling;
import org.junit.jupiter.api.Test;

class ExceptionHandlingTest {
    ExceptionHandling exceptionHandling = new ExceptionHandling();
    @Test
    void testDivide() {
        assertEquals(2, exceptionHandling.divide(6, 3));
    }
    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            exceptionHandling.divide(5, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}

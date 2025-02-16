import static org.junit.jupiter.api.Assertions.*;

import com.week4.day5.Junit.CheckEven;
import org.junit.jupiter.*;


public class CheckEvenTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 7, 9})
    void testIsEven(int number) {
        assertEquals(number % 2 == 0, CheckEven.isEven(number));
    }
}


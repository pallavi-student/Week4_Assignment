import static org.junit.jupiter.api.Assertions.*;

import com.week4.day5.Junit.StringUtility;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

public class StringUtilsTest {
        StringUtility stringUtils = new StringUtility();
        @Test
        void testReverse() {
            assertEquals("cba", stringUtils.reverse("abc"));
            assertEquals("racecar", stringUtils.reverse("racecar"));
        }
        @Test
        void testIsPalindrome() {
            assertTrue(stringUtils.isPalindrome("racecar"));
            assertFalse(stringUtils.isPalindrome("hello"));
        }
        @Test
        void testToUpperCase() {
            assertEquals("HELLO", stringUtils.toUpperCase("hello"));
            assertEquals("WORLD", stringUtils.toUpperCase("world"));
        }
    }



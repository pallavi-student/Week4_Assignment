import static org.junit.jupiter.api.Assertions.*;

import com.week4.day5.Junit.DateFormatter;
import org.junit.jupiter.api.Test;


    public class DateFormatterTest {
        @Test
        void testValidDates() {
            assertEquals("16-02-2025", DateFormatter.formatDate("2025-02-16"));
            assertEquals("01-01-2000", DateFormatter.formatDate("2000-01-01"));
            assertEquals("25-12-2023", DateFormatter.formatDate("2023-12-25"));
        }
        @Test
        void testInvalidDates() {
            assertEquals("Invalid date format", DateFormatter.formatDate("16-02-2025"));
            assertEquals("Invalid date format", DateFormatter.formatDate("2025/02/16"));
            assertEquals("Invalid date format", DateFormatter.formatDate("invalid-date"));
            assertEquals("Invalid date format", DateFormatter.formatDate("2025-13-01"));
        }
    }



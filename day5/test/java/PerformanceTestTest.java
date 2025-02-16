import static org.junit.jupiter.api.Assertions.*;

import com.week4.day5.Junit.PerformanceTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
public class PerformanceTestTest {
        @Test
        @Timeout(value = 2, unit = TimeUnit.SECONDS)
        void testLongRunningTask() {
            String result = PerformanceTest.longRunningTask();
            assertEquals("Task Completed", result);
        }
    }



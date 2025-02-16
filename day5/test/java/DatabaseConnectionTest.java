import static org.junit.jupiter.api.Assertions.*;

import com.week4.day5.Junit.DatabaseConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
class DatabaseConnectionTest {
    private DatabaseConnection databaseConnection;
    @BeforeEach
    void setUp() {
        databaseConnection = new DatabaseConnection();
        databaseConnection.connect();
    }
    @AfterEach
    void tearDown() {
        databaseConnection.disconnect();
    }
    @Test
    void testConnectionEstablished() {
        assertTrue(databaseConnection.isConnected());
    }
    @Test
    void testConnectionClosed() {
        databaseConnection.disconnect();
        assertFalse(databaseConnection.isConnected());
    }
}

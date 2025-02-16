import static org.junit.jupiter.api.Assertions.*;

import com.week4.day5.Junit.FileProcessor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
    public class FileProcessorTest {
        private static final String TEST_FILE = "testfile.txt";

        @BeforeEach
        void setup() throws IOException {
            Files.deleteIfExists(Path.of(TEST_FILE)); // Clean up before each test
        }

        @AfterEach
        void cleanup() throws IOException {
            Files.deleteIfExists(Path.of(TEST_FILE)); // Clean up after each test
        }

        @Test
        void testWriteAndReadFile() throws IOException {
            String content = "Hello, File!";
            FileProcessor.writeToFile(TEST_FILE, content);
            String result = FileProcessor.readFromFile(TEST_FILE);
            assertEquals(content, result);
        }

        @Test
        void testFileExistsAfterWrite() throws IOException {
            FileProcessor.writeToFile(TEST_FILE, "Sample Content");
            assertTrue(Files.exists(Path.of(TEST_FILE)));
        }

        @Test
        void testReadNonExistingFileThrowsException() {
            assertThrows(IOException.class, () -> FileProcessor.readFromFile("nonexistent.txt"));
        }
    }



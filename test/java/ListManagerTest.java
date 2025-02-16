// ListManagerTest.java
import static org.junit.jupiter.api.Assertions.*;

import com.week4.day5.Junit.ListManager;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


class ListManagerTest {
    ListManager listManager = new ListManager();
    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        listManager.addElement(list, 5);
        assertTrue(list.contains(5));
    }
    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        listManager.removeElement(list, 10);
        assertFalse(list.contains(10));
    }
    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        listManager.addElement(list, 3);
        listManager.addElement(list, 7);
        assertEquals(2, listManager.getSize(list));
        listManager.removeElement(list, 3);
        assertEquals(1, listManager.getSize(list));
    }
}

import org.example.test.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    @Test
    public void testNewLinkedList(){
        SinglyLinkedList singly = new SinglyLinkedList();
        assertTrue(singly.isEmpty()); // linked list should be empty
        assertEquals(0, singly.length());
//        // length of linked list should be zero
//
        singly.append("ABC");
        assertFalse(singly.isEmpty());     // linked list should not be empty
        assertEquals(1, singly.length());
        // length of linked list should be 1

    }
}

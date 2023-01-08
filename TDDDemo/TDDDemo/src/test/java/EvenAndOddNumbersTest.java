import org.example.test.EvenAndOddNumbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EvenAndOddNumbersTest {

    EvenAndOddNumbers obj = new EvenAndOddNumbers();


    @Test
    void checkEvenNumber() {
        assertTrue(obj.isEven(4));
    }

    @Test
    void checkOddNumber() {
        assertTrue(obj.isOdd(3));
    }

    @Test
    void addNumbers() {
        int expected = 4;
        int actual = obj.addNumbers(2,2);
        assertEquals(expected, actual);
    }

    @Test
    void OddNumberShouldReturnFalse() {
        assertFalse(obj.isOdd(4));
    }

    @Test
    void EvenNumberShouldReturnFalse() {
        assertFalse(obj.isEven(5));
    }
}

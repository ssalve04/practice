import org.example.test.SamarTestQuestion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SamarQuestionTest {

    SamarTestQuestion obj = new SamarTestQuestion();

    @Test
    public void multiple_of_3() {
        assertEquals("ping", obj.checkMultiples(3));
    }

    @Test
    public void multiple_of_5() {
        assertEquals("pong", obj.checkMultiples(5));
    }

    @Test
    public void multiple_of_3_and_5() {
        assertEquals("ping pong", obj.checkMultiples(15));
    }

    // negative number
    @Test
    public void check_negative_numbers() {
        // 1 to 100
        assertThrows(IllegalArgumentException.class, () -> obj.checkMultiples(131));
        assertThrows(IllegalArgumentException.class, () -> obj.checkMultiples(-131));
    }
}

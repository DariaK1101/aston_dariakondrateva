import org.example.NumberComparator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberComparatorTest {
    @Test
    void testCompare() {
        assertEquals(-1, NumberComparator.compare(3, 5));
        assertEquals(0, NumberComparator.compare(7, 7));
        assertEquals(1, NumberComparator.compare(10, 4));
    }
}
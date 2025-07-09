import org.example.NumberComparator;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class NumberComparatorTestNG {
    @Test
    public void testCompare() {
        assertEquals(NumberComparator.compare(1, 5), -1);
        assertEquals(NumberComparator.compare(3, 3), 0);
        assertEquals(NumberComparator.compare(6, 2), 1);
    }
}

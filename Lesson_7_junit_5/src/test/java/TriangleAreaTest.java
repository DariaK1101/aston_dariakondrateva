import org.example.TriangleArea;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaTest {
    @Test
    void testArea() {
        assertEquals(10.0, TriangleArea.compute(5, 4));
    }

    @Test
    void testInvalid() {
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.compute(-1, 2));
    }
}
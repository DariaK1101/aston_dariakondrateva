import org.example.Factorial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {
    @Test
    void testFactorial() {
        assertEquals(120, Factorial.compute(5));
        assertEquals(1, Factorial.compute(0));
    }

    @Test
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.compute(-3));
    }
}
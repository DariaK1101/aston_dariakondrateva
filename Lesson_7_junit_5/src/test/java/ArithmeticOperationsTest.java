import org.example.ArithmeticOperations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticOperationsTest {
    @Test
    void testAdd() {
        assertEquals(7, ArithmeticOperations.add(3, 4));
    }

    @Test
    void testSubtract() {
        assertEquals(1, ArithmeticOperations.subtract(5, 4));
    }

    @Test
     void testMultiply() {
        assertEquals(12, ArithmeticOperations.multiply(3, 4));
    }
    @Test
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(5, 0));
    }
}

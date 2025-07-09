import org.example.ArithmeticOperations;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ArithmeticOperationsTestNG {
    @Test
    public void testAllOperations() {
        assertEquals(ArithmeticOperations.add(3, 4), 7);
        assertEquals(ArithmeticOperations.subtract(5, 4), 1);
        assertEquals(ArithmeticOperations.multiply(3, 4), 12);
        assertEquals(ArithmeticOperations.divide(8, 2), 4);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        ArithmeticOperations.divide(4, 0);
    }
}
import org.example.Factorial;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialTestNG {
    @Test
    public void testFactorial() {
        assertEquals(Factorial.compute(4), 24);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegative() {
        Factorial.compute(-1);
    }
}
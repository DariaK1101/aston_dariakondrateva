import org.example.TriangleArea;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleAreaTestNG {
    @Test
    public void testValid() {
        assertEquals(TriangleArea.compute(6, 2), 6.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalid() {
        TriangleArea.compute(0, 5);
    }
}
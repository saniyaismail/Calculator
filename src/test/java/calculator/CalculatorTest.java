package calculator;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testSqrt() {
        assertEquals(3.0, Calculator.sqrt(9), 0.0001);
        assertEquals(0.0, Calculator.sqrt(0), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> Calculator.sqrt(-4));
    }

    @Test
    void testFactorial() {
        assertEquals(BigInteger.valueOf(120), Calculator.factorial(5));
        assertEquals(BigInteger.ONE, Calculator.factorial(0));
        assertThrows(IllegalArgumentException.class, () -> Calculator.factorial(-3));
    }

    @Test
    void testLn() {
        assertEquals(0.0, Calculator.ln(1), 0.0001);
        assertEquals(1.0, Calculator.ln(Math.E), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> Calculator.ln(0));
        assertThrows(IllegalArgumentException.class, () -> Calculator.ln(-5));
    }

    @Test
    void testPow() {
        assertEquals(8.0, Calculator.pow(2,3), 0.0001);
        assertEquals(1.0, Calculator.pow(5,0), 0.0001);
        assertEquals(0.25, Calculator.pow(2,-2), 0.0001);
    }
}

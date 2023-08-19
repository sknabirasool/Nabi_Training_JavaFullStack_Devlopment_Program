import org.java.example.day0.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest {
    @Test
    void add() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }
    @Test
    void add1() {
        Calculator calculator = new Calculator();
        int result = calculator.add(10, 3);
        assertEquals(5, result);
    }

}

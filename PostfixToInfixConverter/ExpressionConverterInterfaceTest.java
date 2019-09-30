import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionConverterInterfaceTest {
    StackInterface<String> stack;
    @BeforeEach
    void setUp() {
        stack = new LinkedStack<>();
    }

    @AfterEach
    void tearDown() {
        stack = null;
    }

    @Test
    void convert() {
        InfixToPostfixConverter string = new InfixToPostfixConverter();
        System.out.println(string.convert("A+B+B+D"));
        System.out.println(string.convert("A+  B+B +D"));
        System.out.println(string.convert("A+  A-B*D"));
        System.out.println(string.convert("A+B^(C*D)"));
        System.out.println(string.convert("A*A^B*(A+B)"));
        System.out.println(string.convert("A+B*(A/B)"));
        System.out.println(string.convert("A*A+B^(A+B)"));
        assertThrows(InvalidExpressionException.class, () -> System.out.println(string.convert("A+B!(C*D)")));
    }
}
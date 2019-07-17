import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import stack.ArrayStack;

public class ArrayStackTest {

    @Test
    public void TestPushAndPop() {
        ArrayStack stack = new ArrayStack(5);

        stack.push(1);
        stack.push(2);

        Assertions.assertEquals(2, stack.size());
        Assertions.assertEquals(2, stack.pop());
        Assertions.assertEquals(1, stack.pop());
    }
}

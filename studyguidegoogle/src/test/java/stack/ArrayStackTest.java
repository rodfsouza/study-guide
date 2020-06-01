package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


public class ArrayStackTest {

    private ArrayStack stack;

    @BeforeEach
    public void setup() {
        stack = new ArrayStack();

        stack.push(4);
        stack.push(5);
        stack.push(2);
        stack.push(10);
    }

    @Test
    public void testStackPop() {
        Assertions.assertEquals(10, stack.pop());
        Assertions.assertEquals(2, stack.pop());
    }

    @Test
    public void testStackPopEmpty() {

        while (!stack.isEmpty()) {
            stack.pop();
        }

        Executable exec = () -> stack.pop();
        Assertions.assertThrows(IllegalStateException.class, exec);
    }

    @Test
    public void testStackPushFull() {
        ArrayStack stackArray = new ArrayStack(5);
        stackArray.push(4);
        stackArray.push(5);
        stackArray.push(2);
        stackArray.push(10);

        Executable exec = () -> stackArray.push(7);
        Assertions.assertThrows(IllegalStateException.class, exec);
    }

}

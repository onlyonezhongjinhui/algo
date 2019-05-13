import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import queue.ArrayQueue;

public class ArrayQueueTest {

    @Test
    public void TestEnqueue() {
        ArrayQueue queue = new ArrayQueue<String>(3);
        Assertions.assertTrue(queue.enqueue("1"));
        Assertions.assertTrue(queue.enqueue("2"));
        Assertions.assertTrue(queue.enqueue("3"));
        Assertions.assertFalse(queue.enqueue("4"));
    }

    @Test
    public void TestDequeue() {
        ArrayQueue queue = new ArrayQueue<String>(3);
        Assertions.assertEquals(null, queue.dequeue());

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        Assertions.assertEquals("1", queue.dequeue());
        Assertions.assertEquals("2", queue.dequeue());
        Assertions.assertEquals("3", queue.dequeue());
        Assertions.assertEquals(null, queue.dequeue());
    }
}

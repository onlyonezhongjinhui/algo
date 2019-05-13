import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import queue.LinkedQueue;

public class LinkedQueueTest {

    @Test
    public void TestEnqueue() {
        LinkedQueue queue = new LinkedQueue<String>();
        Assertions.assertTrue(queue.enqueue("1"));
    }

    @Test
    public void TestDequeue() {
        LinkedQueue queue = new LinkedQueue<String>();
        Assertions.assertTrue(queue.enqueue("1"));
        Assertions.assertTrue(queue.enqueue("2"));
        Assertions.assertTrue(queue.enqueue("3"));
        Assertions.assertTrue(queue.enqueue("4"));
        Assertions.assertTrue(queue.enqueue("5"));
        Assertions.assertEquals("1", queue.dequeue());
        Assertions.assertEquals("2", queue.dequeue());
        Assertions.assertEquals("3", queue.dequeue());
        Assertions.assertEquals("4", queue.dequeue());
        Assertions.assertEquals("5", queue.dequeue());
        Assertions.assertEquals(null, queue.dequeue());
    }
}

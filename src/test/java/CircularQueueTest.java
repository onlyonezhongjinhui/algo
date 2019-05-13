import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import queue.CircularQueue;

public class CircularQueueTest {

    @Test
    public void TestEnqueue() {
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        Assertions.assertTrue(queue.enqueue(1));
        Assertions.assertTrue(queue.enqueue(2));
        Assertions.assertTrue(queue.enqueue(3));
        Assertions.assertTrue(queue.enqueue(4));
        Assertions.assertFalse(queue.enqueue(5));
        Assertions.assertFalse(queue.enqueue(6));
    }

    @Test
    public void TestDequeue() {
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        Assertions.assertEquals(null, queue.dequeue());
        Assertions.assertTrue(queue.enqueue(1));
        Assertions.assertTrue(queue.enqueue(2));
        Assertions.assertTrue(queue.enqueue(3));
        Assertions.assertTrue(queue.enqueue(4));
        Assertions.assertEquals(1, queue.dequeue());
        Assertions.assertEquals(2, queue.dequeue());
        Assertions.assertEquals(3, queue.dequeue());
        Assertions.assertEquals(4, queue.dequeue());
        Assertions.assertEquals(null, queue.dequeue());
    }
}

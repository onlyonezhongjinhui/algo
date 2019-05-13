package queue;

/**
 * 循环队列
 */
public class CircularQueue<T> {
    private Object[] items;
    private int capacity;
    private int head;
    private int tail;

    /**
     * 构造函数
     *
     * @param capacity
     */
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.items = new Object[this.capacity];
    }

    /**
     * 入队
     *
     * @param e
     * @return
     */
    public boolean enqueue(T e) {
        int tempTail = (tail + 1) % capacity;
        //队列已满
        if (tempTail == head) {
            return false;
        }
        //队列未满
        items[tail] = e;
        tail = tempTail;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public T dequeue() {
        if (head == tail) {
            return null;
        }

        T result = (T) items[head];
        head = (head + 1) % capacity;
        return result;
    }
}

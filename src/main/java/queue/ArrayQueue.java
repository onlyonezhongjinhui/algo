package queue;

import java.util.Arrays;

/**
 * 顺序队列
 */
public class ArrayQueue<T> {

    private Object[] items;

    /**
     * 队容量
     */
    private int capacity;

    /**
     * 队头下标
     */
    private int head;

    /**
     * 队尾下标
     */
    private int tail;

    /**
     * 构造函数
     *
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        items = new Object[capacity];
    }

    /**
     * 入队
     *
     * @param e
     * @return
     */
    public boolean enqueue(T e) {
        if (tail == capacity) {
            //如果没有空闲空间，则入队失败
            if (head == 0) {
                return false;
            }
            //如果有空闲空间，则进行数据搬移
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail++] = e;
        return true;
    }

    /**
     * 出队
     */
    public T dequeue() {
        if (head == tail) {
            return null;
        }
        return (T) items[head++];
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}

package queue;

import linkedlist.SingleLinkedList;

/**
 * 链式队列
 */
public class LinkedQueue<T> {
    private SingleLinkedList<T> linkedList;

    /**
     * 构造函数
     */
    public LinkedQueue() {
        linkedList = new SingleLinkedList<T>();
    }

    public boolean enqueue(T e) {
        linkedList.addAtLast(e);
        return true;
    }

    public T dequeue() {
        T result = linkedList.first();
        linkedList.removeAt(0);
        return result;
    }
}

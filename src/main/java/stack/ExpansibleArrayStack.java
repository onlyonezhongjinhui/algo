package stack;

import java.util.Arrays;

/**
 * 可扩容数组栈
 */
public class ExpansibleArrayStack {
    private Object[] items;
    private int count;
    private int capacity;

    /**
     * 构造函数
     */
    public ExpansibleArrayStack() {
        this.capacity = 16;
        this.items = new Object[this.capacity];
    }

    /**
     * 构造函数
     *
     * @param capacity
     */
    public ExpansibleArrayStack(int capacity) {
        if (capacity <= 0) {
            this.capacity = 16;
        } else {
            this.capacity = capacity;
        }
        this.items = new Object[this.capacity];
    }

    /**
     * 入栈
     *
     * @param e
     * @return
     */
    public boolean push(Object e) {
        if (this.count == this.capacity) {
            capacityExpansion();
        }

        this.items[this.count++] = e;
        return true;
    }

    /**
     * 扩容
     */
    private void capacityExpansion() {
        this.capacity *= 2;
        this.items = Arrays.copyOf(this.items, this.capacity);
    }

    /**
     * 出栈
     *
     * @return
     */
    public Object pop() {
        if (this.count == 0) {
            return null;
        }

        Object e = this.items[this.count - 1];
        this.items[this.count - 1] = null;
        this.count--;
        return e;
    }

    /**
     * 栈大小
     *
     * @return
     */
    public int size() {
        return this.count;
    }
}

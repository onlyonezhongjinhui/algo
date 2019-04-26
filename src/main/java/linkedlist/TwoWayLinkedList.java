package linkedlist;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * 双向链表
 *
 * @param <T>
 */
public class TwoWayLinkedList<T> {

    /**
     * 长度
     */
    private int length;

    /**
     * 头节点
     */
    private TwoWayNode<T> head;

    /**
     * 特定元素前添加元素
     *
     * @param target
     * @param e
     */
    public void addAt(T target, T e) {
        checkNull(target, e);

        TwoWayNode c = this.head;
        while (c != null) {
            if (c.element.equals(target)) {
                add(e, c);
                return;
            }

            c = c.next;
        }

        throw new IllegalArgumentException(target + " are not in the list.");
    }

    /**
     * 指定位置添加元素
     *
     * @param index
     * @param e
     */
    public void addAtIndex(int index, T e) {
        checkNull(e);

        if (index >= this.length || index < 0) {
            throw new IllegalArgumentException(index + " index Out Of Bounds.");
        }

        TwoWayNode c = this.head;
        int i = 0;
        while (c != null) {
            if (i == index) {
                add(e, c);
                return;
            }

            c = c.next;
            i++;
        }

        this.length++;
    }

    /**
     * 头节点添加元素
     *
     * @param e
     */
    public void addAtFirst(T e) {
        checkNull(e);

        if (this.head == null) {
            this.head = new TwoWayNode(null, null, e);
        } else {
            TwoWayNode newNode = new TwoWayNode(null, this.head, e);
            this.head.pre = newNode;
            this.head = newNode;
        }

        this.length++;
    }

    /**
     * 尾节点添加元素
     *
     * @param e
     */
    public void addAtLast(T e) {
        checkNull(e);

        TwoWayNode last = getLast();
        if (last != null) {
            last.next = new TwoWayNode(last, null, e);
        } else {
            this.head = new TwoWayNode(null, null, e);
        }

        this.length++;
    }

    /**
     * 删除元素
     *
     * @param e
     */
    public void remove(T e) {
        checkNull(e);

        TwoWayNode c = this.head;
        while (c != null) {
            if (c.element.equals(e)) {
                if (c.pre == null) {
                    if (c.next == null) {
                        this.head = null;
                        this.length--;
                        return;
                    } else {
                        c.next.pre = null;
                        c = c.next;
                        this.head = c;
                        this.length--;
                        continue;
                    }
                } else {
                    if (c.next == null) {
                        c.pre.next = null;
                        this.length--;
                        return;
                    } else {
                        c.pre.next = c.next;
                        c.next.pre = c.pre;
                        c = c.next;
                        this.length--;
                        continue;
                    }
                }
            }

            c = c.next;
        }
    }

    /**
     * 获取第一个元素
     *
     * @return
     */
    public T first() {
        return this.head == null ? null : this.head.getElement();
    }

    /**
     * 获取最后的元素
     *
     * @return
     */
    public T last() {
        TwoWayNode<T> last = this.getLast();
        return last == null ? null : last.getElement();
    }

    /**
     * 链表长度
     *
     * @return
     */
    public int getSize() {
        return this.length;
    }

    /**
     * 获取最后一个元素
     */
    private TwoWayNode<T> getLast() {
        if (this.head == null) {
            return null;
        }

        TwoWayNode c = this.head;
        while (c.next != null) {
            c = c.next;
        }
        return c;
    }

    /**
     * 打印链表
     */
    public void print() {
        TwoWayNode c = this.head;
        StringBuilder sb = new StringBuilder();
        while (c != null) {
            if (sb.length() != 0) {
                sb.append(",");
            }
            sb.append(c.element);
            c = c.next;
        }
        System.out.println(sb.toString());
    }

    /**
     * 空检查
     *
     * @param es
     */
    private void checkNull(Object... es) {
        for (Object e : es) {
            if (Objects.isNull(e)) {
                throw new IllegalArgumentException("cant not be null");
            }
        }
    }

    /**
     * 添加元素
     *
     * @param e
     * @param c
     */
    private void add(T e, TwoWayNode c) {
        if (c.pre == null) {
            TwoWayNode newNode = new TwoWayNode(null, c, e);
            this.head = newNode;
            c.pre = newNode;
        } else {
            TwoWayNode newNode = new TwoWayNode(c.pre, c, e);
            c.pre.next = newNode;
            c.pre = newNode;
        }

        this.length++;
    }

    @Getter
    @Setter
    private static class TwoWayNode<T> {
        private TwoWayNode<T> pre;
        private TwoWayNode<T> next;
        private T element;

        public TwoWayNode(TwoWayNode<T> pre, TwoWayNode<T> next, T element) {
            this.pre = pre;
            this.next = next;
            this.element = element;
        }
    }
}

package linkedlist;

import lombok.Getter;
import lombok.Setter;

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
    private TwoWayNode<T> Head;

    /**
     * 添加元素
     *
     * @param e
     */
    public void add(T e) {

    }

    /**
     * 删除元素
     *
     * @param e
     */
    public void remove(T e) {

    }

    /**
     * 获取元素
     *
     * @param e
     */
    public void get(T e) {

    }

    /**
     * 获取第一元素
     */
    public void getFirst() {

    }

    /**
     * 获取最后一个元素
     */
    public void getLast() {

    }

    /**
     * 打印链表
     */
    public void print() {

    }

    @Getter
    @Setter
    private static class TwoWayNode<T> {
        private TwoWayNode<T> pre;
        private TwoWayNode<T> next;
        private T element;

        public TwoWayNode() {

        }

        public TwoWayNode(TwoWayNode<T> pre, TwoWayNode<T> next, T element) {
            this.pre = pre;
            this.next = next;
            this.element = element;
        }
    }
}

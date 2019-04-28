package linkedlist;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * 单向链表实现的LRU缓存
 *
 * @param <T>
 */
public class LRUCaching<T> {

    /**
     * 单向链表
     */
    private SingleLinkedList linkedList = new SingleLinkedList<Node<T>>();

    /**
     * 缓存容量
     */
    private int capacity = 16;

    /**
     * 缓存长度
     */
    private int length;

    /**
     * 构造函数
     */
    public LRUCaching() {
    }

    /**
     * 构造函数
     *
     * @param capacity
     */
    public LRUCaching(int capacity) {
        if (capacity <= 0 || capacity > 1000000) {
            throw new IllegalArgumentException("Capacity ranges from 1 to 10,000,but " + capacity);
        }
        this.capacity = capacity;
    }

    /**
     * 查询
     *
     * @param key
     * @return
     */
    public T get(String key) {
        Node<T> node = new Node(key, null);
        T value = (T) linkedList.get(node);
        if (value == null) {
            return null;
        }
        return value;
    }

    /**
     * 查询
     *
     * @param key
     * @param e
     */
    public void get(String key, T e) {
        checkNull(key);

        Node node = new Node<>(key, e);

        //数据已存在
        if (linkedList.contains(node)) {
            linkedList.remove(node);
            linkedList.addAtFirst(node);
        }
        //数据不存在
        else {
            //链表已满
            if (this.capacity == this.length) {
                linkedList.removeAtLast();
                linkedList.addAtFirst(node);
            }
            //链表未满
            else {
                linkedList.addAtFirst(node);
                this.length++;
            }
        }
    }

    public void print(){
        this.linkedList.printAll();
    }

    /**
     * 空检查
     *
     * @param es
     */
    private void checkNull(Object... es) {
        for (Object e : es) {
            if (e == null) {
                throw new IllegalArgumentException("cant not be null");
            }
        }
    }

    @Getter
    @Setter
    private static class Node<T> {
        private String key;
        private T data;

        public Node(String key, T data) {
            this.key = key;
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return key.equals(node.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key='" + key + '\'' +
                    ", data=" + data +
                    '}';
        }
    }

    public static void main(String[] args) {
        LRUCaching<String> cach = new LRUCaching<String>(5);
        cach.print();

        cach.get("sky","人皇");
        cach.get("fly","兽王");
        cach.get("moon","月神");
        cach.print();
        cach.get("sky","人皇");
        cach.print();
        cach.get("ted","胖子");
        cach.print();
        cach.get("th000","蛋孙");
        cach.print();
        cach.get("lyn","美兽王");
        cach.print();
    }
}

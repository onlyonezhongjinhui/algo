package linkedlist;

/**
 * 单向链表
 */
public class SingleLinkedlist<T> {
    public static void main(String[] args) {
        SingleLinkedlist linkedlist = new SingleLinkedlist<String>();
        linkedlist.add("a");
        linkedlist.add("b");
        linkedlist.add("c");
        linkedlist.add("d");

        System.out.println(linkedlist.last().element);
    }

    private int length;

    private SNode<T> head;

    /**
     * 尾部添加元素
     * @param e
     */
    public void add(T e) {
        SNode newNode = new SNode<T>(e, null);
        if (this.length == 0) {
            this.head = newNode;
        } else {
            last().next = newNode;
        }
        length++;
    }

    /**
     * 特定元素前添加
     * @param target
     * @param e
     */
    public void insertAt(T target, T e) {

    }

    /**
     * 特定位置添加
     * @param index
     * @param e
     */
    public void insertAt(int index, T e) {

    }

    /**
     * 删除元素
     * @param e
     */
    public void remove(T e) {
        SNode c = this.head, p = null;
        while (c != null) {
            if (c.element.equals(e)) {
                if (p == null) {
                    this.head = c.next;
                } else {
                    p.next = c.next;
                }
                this.length--;
            } else {
                p = c;
            }
            c = c.next;
        }
    }

    /**
     * 链表长度
     * @return
     */
    public int size() {
        return this.length;
    }

    /**
     * 打印链表
     */
    public void print() {
        if (this.length == 0) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        SNode currentNode = this.head;
        do {
            if (sb.length() != 0) {
                sb.append(",");
            }

            sb.append(currentNode.element.toString());
            currentNode = currentNode.next;
        } while (currentNode != null);

        System.out.println(sb.toString());
    }

    /**
     * 获取链表最后的节点
     * @return
     */
    public SNode<T> last() {
        if (this.length == 0) {
            return null;
        } else if (this.length == 1) {
            return this.head;
        } else {
            SNode<T> c = this.head.next;
            while (c.next != null) {
                c = c.next;
            }
            return c;
        }
    }

    /**
     * 节点
     */
    private static class SNode<T> {
        private T element;
        private SNode<T> next;

        public SNode(T element, SNode<T> next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode<T> getNext() {
            return next;
        }

        public void setNext(SNode<T> next) {
            this.next = next;
        }
    }
}

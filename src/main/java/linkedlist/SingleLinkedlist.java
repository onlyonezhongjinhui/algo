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
        linkedlist.print();

        linkedlist.remove("a");
        linkedlist.print();
    }

    private int length;

    private SNode<T> head;

    public void add(T e) {
        SNode newNode = new SNode<T>(e, null);
        if (this.length == 0) {
            this.head = newNode;
        } else {
            getLast().next = newNode;
        }
        length++;
    }

    public void remove(T e) {
        if (this.head == null) {
            return;
        }

        if (this.head.element.equals(e)) {
            if (this.head.next == null) {
                this.head = null;
                this.length--;
                return;
            } else {
                this.head = this.head.next;
                this.length--;
            }
        }

        SNode node = this.head;
        SNode preNode;
        while (node.next != null) {
            preNode = node;
            node = node.next;
            if (node.element.equals(e)) {
                if (node.next == null) {
                    //尾节点
                    preNode.next = null;
                    this.length--;
                    break;
                } else {
                    //非尾节点
                    preNode.next = node.next;
                    node = node.next;
                    this.length--;
                    continue;
                }
            }
        }
    }

    public int size() {
        return this.length;
    }

    public void print() {
        if (this.length == 0) {
            return;
        }

        if (this.length == 1) {
            System.out.println(this.head.element.toString());
        }

        StringBuilder sb = new StringBuilder();
        sb.append(this.head.element.toString());
        SNode<T> node = this.head.next;
        for (int i = 1; i < this.length; i++) {
            sb.append(",");
            sb.append(node.element.toString());
            node = node.next;
        }

        System.out.println(sb.toString());
    }

    private SNode<T> getLast() {
        if (this.length == 0) {
            return null;
        } else if (this.length == 1) {
            return this.head;
        } else {
            SNode<T> node = this.head.next;
            while (node.next != null) {
                node = node.next;
            }
            return node;
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

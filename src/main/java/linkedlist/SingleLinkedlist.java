package linkedlist;

/**
 * 单向链表
 */
public class SingleLinkedlist<T> {
    public static void main(String[] args) {
        SingleLinkedlist linkedlist = new SingleLinkedlist<String>();
        linkedlist.add("a");
        linkedlist.add("a");
        linkedlist.add("b");
        linkedlist.add("b");
        linkedlist.add("c");
        linkedlist.add("b");
        linkedlist.print();

        linkedlist.remove("b");
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
        SNode currentNode = this.head;
        SNode preNode = null;
        while (currentNode != null) {
            if (currentNode.element.equals(e)) {
                if (preNode == null) {
                    this.head = currentNode.next;
                } else {
                    preNode.next = currentNode.next;
                }
                this.length--;
            } else {
                preNode = currentNode;
            }
            currentNode = currentNode.next;
        }
    }

    public int size() {
        return this.length;
    }

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

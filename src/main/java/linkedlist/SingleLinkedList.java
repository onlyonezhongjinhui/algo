package linkedlist;

/**
 * 单向链表
 */
public class SingleLinkedList<T> {

    /**
     * 长度
     */
    private int length;

    /**
     * 头节点
     */
    private SNode<T> head;

    /**
     * 尾部添加元素
     *
     * @param e
     */
    public void addAtLast(T e) {
        SNode newNode = new SNode<T>(e, null);
        if (this.length == 0) {
            this.head = newNode;
        } else {
            getLast().next = newNode;
        }
        this.length++;
    }

    /**
     * 头部添加元素
     *
     * @param e
     */
    public void addAtFirst(T e) {
        SNode newNode = new SNode<T>(e, this.head);
        this.head = newNode;
        this.length++;
    }

    /**
     * 制定元素前添加元素
     *
     * @param target
     * @param e
     */
    public void addAt(T target, T e) {
        SNode c = this.head;
        SNode p = null;
        while (c != null) {
            if (c.element.equals(target)) {
                add(e, c, p);
                return;
            }
            p = c;
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
    public void addAt(int index, T e) {
        if (index > this.length || index < 0) {
            throw new IllegalArgumentException(index + " index Out Of Bounds.");
        }

        SNode c = this.head;
        SNode p = null;
        int i = 0;
        while (c != null) {
            if (i == index) {
                break;
            }
            p = c;
            c = c.next;
            i++;
        }

        add(e, c, p);
    }

    /**
     * 添加节点
     *
     * @param e
     * @param c
     * @param p
     */
    private void add(T e, SNode c, SNode p) {
        if (p == null) {
            addAtFirst(e);
        } else {
            SNode newNode = new SNode<T>(e, c);
            p.next = newNode;
            this.length++;
        }
    }

    /**
     * 删除元素
     *
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
     *
     * @return
     */
    public int size() {
        return this.length;
    }


    /**
     * 返回链表头节点元素
     *
     * @return
     */
    public T first() {
        return this.head.element;
    }

    /**
     * 获取链表最后的节点
     *
     * @return
     */
    public T last() {
        SNode<T> lastNode = getLast();
        return lastNode == null ? null : lastNode.getElement();
    }

    public boolean contains(T e) {
        SNode c = this.head;
        while (c != null) {
            if (c.element.equals(e)) {
                return true;
            }
            c = c.next;
        }
        return false;
    }

    /**
     * 获取链表最后的节点
     *
     * @return
     */
    private SNode<T> getLast() {
        if (this.head == null) {
            return null;
        }

        SNode c = this.head;
        while (c.next != null) {
            c = c.next;
        }
        return c;
    }

    /**
     * 打印链表
     */
    public void printAll() {
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

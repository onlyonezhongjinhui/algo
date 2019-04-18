package linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingleLinkedListTest {

    @Test
    public void TestAddAtLast() {
        SingleLinkedList linkedList = new SingleLinkedList<String>();
        linkedList.addAtLast("a");
        Assertions.assertEquals(linkedList.size(), 1);
        Assertions.assertEquals(linkedList.last(), "a");
    }

    @Test
    public void TestAddAtFirst() {
        SingleLinkedList linkedList = new SingleLinkedList<String>();
        linkedList.addAtFirst("a");
        Assertions.assertEquals(linkedList.size(), 1);
        Assertions.assertEquals(linkedList.first(), "a");
    }

    @Test()
    public void TestAddAt1() {
        SingleLinkedList linkedList = new SingleLinkedList<String>();
        linkedList.addAt(0, "0");
        Assertions.assertEquals(linkedList.first(), "0");
        Assertions.assertEquals(linkedList.size(), 1);

        linkedList.addAt(0, "-1");
        Assertions.assertEquals(linkedList.last(), "0");
        Assertions.assertEquals(linkedList.size(), 2);

        linkedList.addAt(1, "-0.5");
        Assertions.assertEquals(linkedList.last(), "0");
        Assertions.assertEquals(linkedList.first(), "-1");
        Assertions.assertEquals(linkedList.size(), 3);

        linkedList.addAt(2, "2");
        Assertions.assertEquals(linkedList.last(), "0");
        Assertions.assertEquals(linkedList.first(), "-1");
        Assertions.assertEquals(linkedList.size(), 4);
    }

    @Test()
    public void TestAddAt2() {
        SingleLinkedList linkedList = new SingleLinkedList<String>();
        linkedList.addAtFirst("0");

        linkedList.addAt("0", "-1");
        Assertions.assertEquals(linkedList.last(), "0");
        Assertions.assertEquals(linkedList.size(), 2);
    }

    @Test()
    public void TestRemove() {
        SingleLinkedList linkedList = new SingleLinkedList<String>();
        linkedList.addAtFirst("0");
        linkedList.addAtLast("1");
        linkedList.addAtLast("2");
        linkedList.addAtLast("3");
        linkedList.addAtLast("3");
        linkedList.addAtLast("4");

        linkedList.remove("0");
        Assertions.assertEquals(linkedList.size(), 5);
        Assertions.assertEquals(linkedList.first(), "1");

        linkedList.remove("4");
        Assertions.assertEquals(linkedList.size(), 4);
        Assertions.assertEquals(linkedList.last(), "3");

        linkedList.remove("3");
        Assertions.assertEquals(linkedList.size(), 2);
        Assertions.assertEquals(linkedList.last(), "2");
    }

    @Test
    public void TestContains() {
        SingleLinkedList linkedList = new SingleLinkedList<String>();
        linkedList.addAtFirst(1);
        linkedList.addAtFirst(2);
        linkedList.addAtFirst(3);

        Assertions.assertTrue(linkedList.contains(1));
        Assertions.assertFalse(linkedList.contains(5));
    }
}

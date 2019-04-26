import linkedlist.SingleLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingleLinkedListTest {

    @Test
    public void TestAddAtLast() {
        SingleLinkedList linkedList = new SingleLinkedList<String>();
        linkedList.addAtLast("a");
        Assertions.assertEquals(1, linkedList.size());
        Assertions.assertEquals("a", linkedList.last());
    }

    @Test
    public void TestAddAtFirst() {
        SingleLinkedList linkedList = new SingleLinkedList<String>();
        linkedList.addAtFirst("a");
        Assertions.assertEquals(1, linkedList.size());
        Assertions.assertEquals("a", linkedList.first());
    }

    @Test()
    public void TestAddAt1() {
        SingleLinkedList linkedList = new SingleLinkedList<String>();
        linkedList.addAt(0, "0");
        Assertions.assertEquals("0", linkedList.first());
        Assertions.assertEquals(1, linkedList.size());

        linkedList.addAt(0, "-1");
        Assertions.assertEquals("0", linkedList.last());
        Assertions.assertEquals(2, linkedList.size());

        linkedList.addAt(1, "-0.5");
        Assertions.assertEquals("0", linkedList.last());
        Assertions.assertEquals("-1", linkedList.first());
        Assertions.assertEquals(3, linkedList.size());

        linkedList.addAt(2, "2");
        Assertions.assertEquals("0", linkedList.last());
        Assertions.assertEquals("-1", linkedList.first());
        Assertions.assertEquals(4, linkedList.size());
    }

    @Test()
    public void TestAddAt2() {
        SingleLinkedList linkedList = new SingleLinkedList<String>();
        linkedList.addAtFirst("0");

        linkedList.addAt("0", "-1");
        Assertions.assertEquals("0", linkedList.last());
        Assertions.assertEquals(2, linkedList.size());
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
        Assertions.assertEquals(5, linkedList.size());
        Assertions.assertEquals(linkedList.first(), "1");

        linkedList.remove("4");
        Assertions.assertEquals(4, linkedList.size());
        Assertions.assertEquals("3", linkedList.last());

        linkedList.remove("3");
        Assertions.assertEquals(2, linkedList.size());
        Assertions.assertEquals("2", linkedList.last());
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

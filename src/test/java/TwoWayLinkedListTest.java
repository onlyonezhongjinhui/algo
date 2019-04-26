import linkedlist.TwoWayLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwoWayLinkedListTest {

    @Test
    public void TestAddAtFirst() {
        TwoWayLinkedList<Integer> list = new TwoWayLinkedList<>();
        list.addAtFirst(1);

        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals(1, list.first());
        Assertions.assertEquals(1, list.last());

        list.addAtFirst(0);

        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals(0, list.first());
        Assertions.assertEquals(1, list.last());
    }

    @Test
    public void TestAddAtLast() {
        TwoWayLinkedList<Integer> list = new TwoWayLinkedList<>();
        list.addAtLast(1);

        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals(1, list.first());
        Assertions.assertEquals(1, list.last());

        list.addAtLast(2);

        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals(1, list.first());
        Assertions.assertEquals(2, list.last());
    }

    @Test
    public void TestAddAtTarget() {
        TwoWayLinkedList<Integer> list = new TwoWayLinkedList<>();
        list.addAtLast(1);
        list.addAtLast(3);

        list.addAt(1, 0);

        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals(0, list.first());

        list.addAt(3, 2);

        Assertions.assertEquals(4, list.getSize());
        Assertions.assertEquals(0, list.first());
    }

    @Test
    public void TestAddAtIndex() {
        TwoWayLinkedList<Integer> list = new TwoWayLinkedList<>();
        list.addAtLast(1);
        list.addAtLast(3);

        list.addAtIndex(0, 0);

        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals(0, list.first());

        list.addAtIndex(2, 2);

        Assertions.assertEquals(4, list.getSize());
        Assertions.assertEquals(0, list.first());
        Assertions.assertEquals(3, list.last());
    }

    @Test
    public void TestRemove() {
        TwoWayLinkedList<Integer> list = new TwoWayLinkedList<>();
        list.addAtLast(1);
        list.addAtLast(2);
        list.addAtLast(3);
        list.addAtLast(3);
        list.addAtLast(4);

        list.remove(1);

        Assertions.assertEquals(4, list.getSize());
        Assertions.assertEquals(2, list.first());

        list.remove(3);

        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals(2, list.first());
        Assertions.assertEquals(4, list.last());


        list.remove(4);

        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals(2, list.first());
        Assertions.assertEquals(2, list.last());
    }
}

package linkedlist;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {
    LinkedList linkedList = new LinkedList();

    @BeforeEach
    public void setUp() {
        linkedList.insertAtFirst(10);
        linkedList.insertAtLast(7);
        linkedList.insertAtLast(6);
        linkedList.insertAtLast(5);
        assertSize(4);
    }

    @Test
    void deleteFirst() {
        linkedList.deleteFirst();
        assertFailsContains(10);
        assertSize(3);
    }

    @Test
    void deleteLast() {
        linkedList.deleteLast();
        assertFailsContains(5);
        assertSize(3);
    }

    @Test
    void deletePos() {
        linkedList.deletePos(2);
        assertFailsContains(7);
        assertSize(3);
    }

    @Test
    void insertAtPos() {
        linkedList.insertAtPos(4, 3);
        assertSize(5);
        assertSuccessContains(4);
    }

    @Test
    void reverseList() {
        linkedList.reverseList();
        assertListForReversibility(0,5);
        assertListForReversibility(1,6);
        assertListForReversibility(2,7);
        assertListForReversibility(3,10);
    }

    @Test
    void getListSize() {
        assertSize(4);
    }

    @Test
    void viewList() {
    }

    @Test
    void clear() {
        linkedList.clear();
        assertSize(0);
    }

    @Test
    void get() {
        Assert.assertEquals(5, linkedList.get(3));
    }

    public void assertSize(int size) {
        Assert.assertEquals(size, linkedList.getListSize());
    }

    public void assertFailsContains(int value) {
        Assert.assertFalse(linkedList.contains(value));
    }

    public void assertSuccessContains(int value) {
        Assert.assertTrue(linkedList.contains(value));
    }

    public void assertListForReversibility(int index, Object o) {
        Assert.assertEquals(index,linkedList.indexOf(o));
    }
}
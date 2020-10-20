package linkedlist;

public class LinkedList implements InterfaceList {
    private int size;
    private Node head;

    public LinkedList() {
        this.size = 0;
        this.head = null;
    }

    private boolean isEmpty() {
        return head == null;
    }

    private void checkIndex(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void deleteFirst() {
        if (isEmpty())
            System.out.println("List is Empty");
        else {
            head = head.getNext();
            size--;
        }
    }

    @Override
    public void deleteLast() {
        if (isEmpty())
            System.out.println("List is Empty");
        else if (size == 1) {
            head = null;
            size--;
        } else {
            Node t;
            t = head;
            for (int i = 1; i < size - 1; i++)
                t = t.getNext();
            t.setNext(null);
            size--;
        }
    }

    @Override
    public void deletePos(int index) {
        if (isEmpty())
            System.out.println("list is Empty");
        else if (index < 1 || index > size)
            System.out.println("invalid position");
        else if (index == 1)
            deleteFirst();
        else if (index == size)
            deleteLast();
        else {
            Node t, t1;
            t = head;
            for (int i = 1; i < index - 1; i++)
                t = t.getNext();
            t1 = t.getNext();
            t.setNext(t1.getNext());
            size--;
        }
    }

    @Override
    public void insertAtFirst(int value) {
        Node n;
        n = new Node();
        n.setData(value);
        n.setNext(head);
        head = n;
        size++;
    }

    @Override
    public void insertAtLast(int value) {
        Node n, t;
        n = new Node();
        n.setData(value);
        t = head;
        if (t == null)
            head = n;
        else {
            while (t.getNext() != null)
                t = t.getNext();
            t.setNext(n);
        }
        size++;
    }

    @Override
    public void insertAtPos(int value, int index) {
        if (index == 1)
            insertAtFirst(value);
        else if (index == size + 1)
            insertAtLast(value);
        else if (index > 1 && index <= size) {
            Node n, t;
            n = new Node(value, null);
            t = head;
            for (int i = 1; i < index - 1; i++)
                t = t.getNext();
            n.setNext(t.getNext());
            t.setNext(n);
            size++;
        } else
            System.out.println("Insertion at this position is not possible");
    }

    @Override
    public void reverseList() {
        Node prev = null, current = head, next;
        if (current == null)
            return;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
    }

    @Override
    public int getListSize() {
        return size;
    }

    @Override
    public void viewList() {
        Node t;
        if (isEmpty())
            System.out.print("List is Empty");
        else {
            t = head;
            for (int i = 1; i <= size; i++) {
                System.out.print(t.getData() + " ");
                t = t.getNext();
            }
        }
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getData();
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node node = head; node != null; node = node.getNext()) {
                if (node.getData() == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node node = head; node != null; node = node.getNext()) {
                if (o.equals(node.getData())) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
}
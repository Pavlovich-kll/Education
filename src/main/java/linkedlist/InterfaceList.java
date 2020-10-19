package linkedlist;

public interface InterfaceList {

    void deleteFirst();

    void deleteLast();

    void deletePos(int index);

    void insertAtFirst(int value);

    void insertAtLast(int value);

    void insertAtPos(int value, int index);

    void reverseList();

    int getListSize();

    void viewList();

    void clear();

    Object get(int index);

    int indexOf(Object o);

    boolean contains(Object o);
}
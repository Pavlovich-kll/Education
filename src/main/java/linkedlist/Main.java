package linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtFirst(10);
        list.insertAtLast(2);
        list.insertAtLast(6);
        list.insertAtLast(5);
        list.viewList();
        System.out.println();
        System.out.println("Size of list: " + list.getListSize());
        list.deleteLast();
        list.viewList();
        System.out.println();
        System.out.println("Size of list: " + list.getListSize());
        list.insertAtPos(8,3);
        list.viewList();
        System.out.println();
        System.out.println("Size of list: " + list.getListSize());
        list.deletePos(3);
        System.out.println();
        list.viewList();
        list.reverseList();
        System.out.println();
        list.viewList();
        System.out.println();
        System.out.println(list.get(2));
        System.out.println(list.get(1));
        System.out.println(list.get(0));
        list.clear();
        list.viewList();
        list.insertAtLast(2);
        list.insertAtLast(7);
        list.insertAtLast(9);
        System.out.println();
        list.viewList();
        System.out.println();
        System.out.println(list.indexOf(9));
        System.out.println(list.contains(8));
    }
}
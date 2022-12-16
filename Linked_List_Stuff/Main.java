package Linked_List_Stuff;

public class Main {
    public static void main(String[] args) {
        SLL list = new SLL();

        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
//        insert at last position
        list.insertLast(99);
//        insert at a desired position
        list.insert_Position(59,3);
        list.display();
//        deleted first node
        System.out.println("Deleting the first node");
        System.out.println(list.deleteFirst());
        list.display();
//        deleted last node
        System.out.println("Deleting the last node");
        System.out.println(list.deleteLast());
        list.display();
//        deleting node at a desired position
        System.out.println("Deleting node at a desired position ");
        System.out.println(list.deletePosition(2));
        list.display();
//    list.insertFirst(3);
//    list.insertFirst(2);
//    list.insertFirst(1);
//    list.insertFirst(4);
//    list.insert_Position(5,2);
//    list.display();
    }
}

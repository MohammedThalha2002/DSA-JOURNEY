package DataStructures.LinkedList.Thoery;

public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        // DoublyLinkedList dll = new DoublyLinkedList();
        // CircularLinkedList cll = new CircularLinkedList();

        // cll.insert(1);
        // cll.insert(2);
        // cll.insert(3);
        // cll.insert(4);

        // cll.display();

        // cll.delete();
        // cll.display();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.display();
        list.insertRec(6, 4);
        list.display();

    }
}

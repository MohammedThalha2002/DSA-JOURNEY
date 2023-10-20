package DataStructures.LinkedList;

public class Main {
    public static void main(String[] args) {

        DLL dll = new DLL();

        dll.insert(1);
        dll.insert(2);
        dll.insert(3);
        dll.insert(4);
        dll.display();

        dll.delete(2);

        dll.display();

    }
}

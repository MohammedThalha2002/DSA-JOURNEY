package DataStructures.LinkedList;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();

        list.insert(1);
        list.insert(2);
        list.insert(4);
        list.insert(4);
        list.display();
        list.update(3, 2);
        list.display();
    }
}

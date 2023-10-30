package DataStructures.Queue.Theory;

public class Main {
    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue(5);

        queue.insert(0);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.display();
        System.out.println(queue.peek());

        queue.remove();
        queue.display();
        System.out.println(queue.peek());
    }
}

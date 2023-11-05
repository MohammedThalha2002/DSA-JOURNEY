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

        CircularQueue cQueue = new CircularQueue(5);
        cQueue.display();

        cQueue.insert(0);
        cQueue.insert(1);
        cQueue.insert(2);
        cQueue.insert(3);
        cQueue.insert(4);
        cQueue.display();

        cQueue.remove();
        cQueue.remove();
        cQueue.insert(4);
        cQueue.insert(5);
        cQueue.display();

    }
}

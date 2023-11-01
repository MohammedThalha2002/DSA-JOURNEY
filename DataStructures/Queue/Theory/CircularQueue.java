package DataStructures.Queue.Theory;

public class CircularQueue {
    protected int[] data;
    protected static final int DEFAULT_SIZE = 10;

    protected int front = 0;
    protected int end = 0;
    protected int size = 0;

    public CircularQueue() {
        // this will call the constructor mentioned with the given parameter
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[end % data.length] = item;
        end++;
        size++;
        return true;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is Empty");
        }
        int removed = data[front];
        front++;
        front = front % data.length;
        size--;

        return removed;
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Data Underflow");
        }
        return data[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
        }

        if (end < front) {
            for (int i = front; i < data.length; i++) {
                System.out.print(data[i] + " ");
            }
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i] + " ");
            }
        } else if (front == end) {
            for (int i = front; i < data.length; i++) {
                System.out.print(data[i] + " ");
            }
        }

        System.out.println();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }
}

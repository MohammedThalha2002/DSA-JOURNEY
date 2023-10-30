package DataStructures.Queue.Theory;

public class CustomQueue {
    protected int[] data;
    protected static final int DEFAULT_SIZE = 10;
    protected int end = 0;

    public CustomQueue() {
        // this will call the constructor mentioned with the given parameter
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[end++] = item;
        return true;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is Empty");
        }
        int removed = data[0];
        // shift the elements
        for (int i = 1; i < end; i++) {
            data[i - 1] = data[i];
        }
        end--;

        return removed;
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Data Underflow");
        }
        return data[0];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
        }

        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public boolean isFull() {
        return end == data.length;
    }
}

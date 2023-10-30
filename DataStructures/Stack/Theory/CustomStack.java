package DataStructures.Stack.Theory;

public class CustomStack {
    protected int[] data;
    protected static final int DEFAULT_SIZE = 10;
    protected int top = -1;

    public CustomStack() {
        // this will call the constructor mentioned with the given parameter
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int value) throws Exception {
        if (isFull()) {
            throw new Exception("Data Overflow");
        }

        data[++top] = value;

        return true;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Data Underflow");
        }

        // int removed = data[top];
        // top--;
        return data[top--];
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Data Underflow");
        }

        return data[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
        }

        for (int i = 0; i < top + 1; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }
}

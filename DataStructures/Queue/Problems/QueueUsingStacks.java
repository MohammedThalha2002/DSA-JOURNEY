package DataStructures.Queue.Problems;

import java.util.Stack;

// implement queue using stacks
public class QueueUsingStacks {
    public static void main(String[] args) {
        QueueStack queueStack = new QueueStack();
        queueStack.insert(0);
        queueStack.insert(1);
        queueStack.insert(2);
        queueStack.insert(3);
        queueStack.insert(4);

        queueStack.display();
        
        queueStack.remove();
        queueStack.remove();
        
        queueStack.display();
    }

}

class QueueStack {
    Stack<Integer> main = new Stack<>();
    Stack<Integer> helper = new Stack<>();

    public boolean insert(int value) {
        main.add(value);
        return true;
    }

    public int remove() {

        while (!main.isEmpty()) {
            helper.push(main.pop());
        }

        int removed = helper.pop();

        while (!helper.isEmpty()) {
            main.push(helper.pop());
        }

        return removed;
    }

    public int peek() {

        while (!main.isEmpty()) {
            helper.push(main.pop());
        }

        int peeked = helper.pop();

        while (!helper.isEmpty()) {
            main.push(helper.pop());
        }

        return peeked;
    }

    public boolean isEmpty() {

        return main.isEmpty();
    }

    public void display() {
        System.out.println(main);
    }

}

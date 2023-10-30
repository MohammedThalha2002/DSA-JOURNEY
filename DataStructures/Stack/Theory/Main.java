package DataStructures.Stack.Theory;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Static size Stack");
        CustomStack stack = new CustomStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.display();
        
        System.out.println("\nDynamic size Stack");
        CustomStack dynStack = new DynamicStack(5);
        dynStack.push(1);
        dynStack.push(2);
        dynStack.push(3);
        dynStack.push(4);
        dynStack.push(5);
        dynStack.display();
        dynStack.push(6);
        dynStack.display();
    }
}

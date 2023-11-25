package DataStructures.Trees.Theory.Traversals.IterativeApproach;

import java.util.Stack;

import DataStructures.Trees.Theory.BST;
import DataStructures.Trees.Theory.BST.Node;

public class InOrder {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = { 4, 2, 1, 6, 3, 7 };
        for (int val : arr) {
            bst.insert(val);
        }

        bst.display();
        System.out.println("INORDER TRAVERSAL");
        printInOrderTraversal(bst.root);
    }

    private static void printInOrderTraversal(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.print(pop.value + ", ");
            if (pop.right != null)
                stack.push(pop.right);
            if (pop.left != null)
                stack.push(pop.left);
        }

    }
}

package DataStructures.Trees.Theory.Traversals;

import DataStructures.Trees.Theory.BST;
import DataStructures.Trees.Theory.BST.Node;

// NODE => LEFT => RIGHT
// USES
// 1) Evaluating Mathematical expressions
// 2) Creating a Copy
// 3) Serialization (conversion of arr to tree or vice versa)
public class PreOrderTraversal {
    public static void main(String[] args) {

        BST bst = new BST();
        int[] arr = { 4, 2, 1, 6, 3, 7 };
        for (int val : arr) {
            bst.insert(val);
        }

        bst.display();
        System.out.println("PREORDER TRAVERSAL");
        printPreOrderTraversal(bst.root);
    }

    public static void printPreOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + ",");
        printPreOrderTraversal(node.left);
        printPreOrderTraversal(node.right);
    }
}

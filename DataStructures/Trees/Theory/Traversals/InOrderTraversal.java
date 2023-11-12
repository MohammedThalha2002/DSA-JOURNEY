package DataStructures.Trees.Theory.Traversals;

import DataStructures.Trees.Theory.BST;
import DataStructures.Trees.Theory.BST.Node;

// LEFT => NODE => RIGHT
// USES
// 1) In BST, it visit the nodes in sorted Manner
public class InOrderTraversal {
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

    public static void printInOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        printInOrderTraversal(node.left);
        System.out.print(node.value + ",");
        printInOrderTraversal(node.right);
    }
}

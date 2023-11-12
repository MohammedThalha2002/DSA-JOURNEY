package DataStructures.Trees.Theory;

import DataStructures.Trees.Theory.BST.Node;

// LEFT => RIGHT => NODE
// USES
// 1) Deleting a binary tree
// 2) Bottom-Up Calculation
public class PostOrderTraversal {
    public static void main(String[] args) {

        BST bst = new BST();
        int[] arr = { 4, 2, 1, 6, 3, 7 };
        for (int val : arr) {
            bst.insert(val);
        }

        bst.display();
        System.out.println("POSTORDER TRAVERSAL");
        printPostOrderTraversal(bst.root);
    }

    public static void printPostOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        printPostOrderTraversal(node.left);
        printPostOrderTraversal(node.right);
        System.out.print(node.value + ",");
    }
}

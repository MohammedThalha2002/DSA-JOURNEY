package DataStructures.Trees.Problems.DFS;

import DataStructures.Trees.Theory.BST;
import DataStructures.Trees.Theory.BST.Node;

// find the Kth smallest element in a BST
public class KthSmallestBST {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = { 5, 3, 6, 2, 4, 1 };
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }
        bst.display();
        int k = 3;
        Node node = kthSmallestElement(bst.root, k);
        System.out.println("The max depth of the tree is " + node.value);
    }

    static int count = 0;

    private static Node kthSmallestElement(Node node, int k) {
        if (node == null)
            return null;

        Node left = kthSmallestElement(node.left, k);
        if (left != null) {
            return left;
        }
        count++;
        if (count == k) {
            return node;
        }

        return kthSmallestElement(node.right, k);
    }
}

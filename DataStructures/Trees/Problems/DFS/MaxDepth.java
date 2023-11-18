package DataStructures.Trees.Problems.DFS;

import DataStructures.Trees.Theory.BST;
import DataStructures.Trees.Theory.BST.Node;

public class MaxDepth {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = { 4, 2, 6, 1, 3, 7, 5, 20 };
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }
        bst.display();
        int res1 = maximumDepthBT(bst.root);
        int res2 = minimumDepthBT(bst.root);
        System.out.println("The max depth of the tree is " + res1);
        System.out.println("The min depth of the tree is " + res2);
    }

    private static int maximumDepthBT(Node node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = maximumDepthBT(node.left);
        int rightDepth = maximumDepthBT(node.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    private static int minimumDepthBT(Node node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = minimumDepthBT(node.left);
        int rightDepth = minimumDepthBT(node.right);

        return Math.min(leftDepth, rightDepth) + 1;
    }
}

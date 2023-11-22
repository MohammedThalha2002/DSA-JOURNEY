package DataStructures.Trees.Problems.DFS;

import DataStructures.Trees.Theory.BST;
import DataStructures.Trees.Theory.BST.Node;

public class PathSum {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = { 5, 3, 6, 2, 4, 1 };
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }
        bst.display();
        int targetSum = 12;
        boolean res = checkPathSum(bst.root, targetSum);
        System.out.println("The path sum " + targetSum + (res ? " exits" : " not exists"));
    }

    private static boolean checkPathSum(Node node, int targetSum) {

        if (node == null) {
            return false;
        }

        if (targetSum == node.value && node.left == null && node.right == null) {
            return true;
        }

        targetSum = targetSum - node.value;

        Boolean left = checkPathSum(node.left, targetSum);
        Boolean right = checkPathSum(node.right, targetSum);

        return left || right;
    }
}

package DataStructures.Trees.Problems.DFS;

import DataStructures.Trees.Theory.Trees;
import DataStructures.Trees.Theory.Trees.Node;

public class MaxPathSum {
    public static void main(String[] args) {
        Trees tree = new Trees();
        tree.root = tree.createNode(-10);
        tree.root.left = tree.createNode(9);
        tree.root.right = tree.createNode(20);
        tree.root.right.left = tree.createNode(15);
        tree.root.right.right = tree.createNode(7);
        tree.display();
        calculateMaxPathSum(tree.root);
        System.out.println("Max Path sum " + max);
    }

    static int max = Integer.MIN_VALUE;

    private static int calculateMaxPathSum(Node node) {
        System.out.println(max);
        if (node == null) {
            return 0;
        }

        int sum = node.value;

        int left = calculateMaxPathSum(node.left);
        int right = calculateMaxPathSum(node.right);
        sum += left + right;

        max = Math.max(sum, max);

        return node.value + Math.max(left, right);
    }
}

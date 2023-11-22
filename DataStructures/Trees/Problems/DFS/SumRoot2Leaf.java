package DataStructures.Trees.Problems.DFS;

import DataStructures.Trees.Theory.Trees;
import DataStructures.Trees.Theory.Trees.Node;

public class SumRoot2Leaf {
    public static void main(String[] args) {
        Trees tree = new Trees();
        tree.root = tree.createNode(4);
        tree.root.left = tree.createNode(9);
        tree.root.right = tree.createNode(0);
        tree.root.left.left = tree.createNode(5);
        tree.root.left.right = tree.createNode(1);
        tree.display();
        int targetSum = 1026;
        int res = rootToLeafSum(tree.root, 0);
        System.out.println(res);
        System.out
                .println("The root sum from leaf to node " + targetSum
                        + (res == targetSum ? " exits" : " not exists"));
    }

    private static int rootToLeafSum(Node node, int sum) {
        if (node == null) {
            return 0;
        }

        sum = (sum * 10) + node.value;

        if (node.left == null && node.right == null) {
            return sum;
        }

        int left = rootToLeafSum(node.left, sum);
        int right = rootToLeafSum(node.right, sum);

        return left + right;
    }
}

package DataStructures.Trees.Problems.DFS;

import DataStructures.Trees.Theory.Trees;
import DataStructures.Trees.Theory.Trees.Node;

public class DoesPathExists {
    public static void main(String[] args) {
        Trees tree = new Trees();
        tree.root = tree.createNode(3);
        tree.root.left = tree.createNode(5);
        tree.root.right = tree.createNode(9);
        tree.root.right.left = tree.createNode(10);
        tree.root.right.right = tree.createNode(12);
        tree.root.right.right.left = tree.createNode(2);

        int[] path = { 3, 9, 12, 8 };
        tree.display();
        boolean res = doesPathSumExists(tree.root, path);
        System.out.println(res);
    }

    private static boolean doesPathSumExists(Node node, int[] path) {

        if (node == null) {
            return path.length == 0;
        }

        return helper(node, path, 0);
    }

    private static boolean helper(Node node, int[] path, int i) {
        if (node == null) {
            return false;
        }

        if (i > path.length || path[i] != node.value) {
            return false;
        }

        if (node.left == null && node.right == null && i == path.length - 1) {
            return true;
        }

        boolean left = helper(node.left, path, i + 1);
        boolean right = helper(node.right, path, i + 1);

        return left || right;
    }
}

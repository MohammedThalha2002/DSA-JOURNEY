package DataStructures.Trees.Problems.DFS;

import DataStructures.Trees.Theory.Trees;
import DataStructures.Trees.Theory.Trees.Node;

public class ValidBST {
    public static void main(String[] args) {
        Trees tree = new Trees();
        tree.root = tree.createNode(6);
        tree.root.left = tree.createNode(4);
        tree.root.right = tree.createNode(10);
        tree.root.left.left = tree.createNode(2);
        tree.root.left.right = tree.createNode(5);
        tree.root.right.left = tree.createNode(8);
        tree.root.right.right = tree.createNode(9);
        tree.display();
        boolean res = isValidBST(tree.root);
        System.out.println("The given tree is " + (res ? "a valid BST " : "not a valid BST"));
    }

    // using preorder
    private static boolean isValidBST(Node node) {
        if (node == null)
            return true;

        // checking current node
        if (node.left != null && node.value <= node.left.value) {
            return false;
        }
        if (node.right != null && node.value >= node.right.value) {
            return false;
        }

        return isValidBST(node.left) && isValidBST(node.right);
    }
}

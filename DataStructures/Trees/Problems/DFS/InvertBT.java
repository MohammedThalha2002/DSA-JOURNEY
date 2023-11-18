package DataStructures.Trees.Problems.DFS;

import DataStructures.Trees.Theory.Trees;
import DataStructures.Trees.Theory.Trees.Node;

public class InvertBT {
    public static void main(String[] args) {
        Trees tree = new Trees();
        tree.root = tree.createNode(4);
        tree.root.left = tree.createNode(2);
        tree.root.right = tree.createNode(7);
        tree.root.left.left = tree.createNode(1);
        tree.root.left.right = tree.createNode(3);
        tree.root.right.left = tree.createNode(6);
        tree.root.right.right = tree.createNode(9);
        System.out.println("Before inverting");
        tree.display();
        invertBinaryTree(tree.root);
        System.out.println("After inverting");
        tree.display();
    }

    private static void invertBinaryTree(Node node) {
        if (node == null) {
            return;
        }

        invertBinaryTree(node.left);
        invertBinaryTree(node.right);
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}

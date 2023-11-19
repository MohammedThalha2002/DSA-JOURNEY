package DataStructures.Trees.Problems.DFS;

import java.util.LinkedList;

import DataStructures.Trees.Theory.Trees;
import DataStructures.Trees.Theory.Trees.Node;

public class FlattenBTtoLL {
    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        Trees tree = new Trees();
        tree.root = tree.createNode(1);
        tree.root.left = tree.createNode(2);
        tree.root.right = tree.createNode(5);
        tree.root.left.left = tree.createNode(3);
        tree.root.left.right = tree.createNode(4);
        tree.root.right.left = null;
        tree.root.right.right = tree.createNode(6);
        System.out.println("Binary Tree");
        tree.display();
        flattenBTtoLL(tree.root);
        flattenBT(tree.root, tree);
        flattenBinaryTreeToLL(tree.root, tree);
        System.out.println("Flatten Binary tree");
        tree.display();
        System.out.println(list);
    }

    // worst method
    private static void flattenBTtoLL(Node node) {
        if (node == null) {
            return;
        }
        list.add(node.value);
        flattenBTtoLL(node.left);
        flattenBTtoLL(node.right);
    }

    // normal method
    private static void flattenBT(Node node, Trees tree) {
        if (node == null) {
            return;
        }

        if (node.left == null) {
            flattenBT(node.right, tree);
        }

        Node temp = node.right;
        Node emptyRight = checkFirstEmptyRightInLeftSubTree(node.left);
        if (emptyRight != null) {
            emptyRight.right = temp;
            node.right = node.left;
            node.left = null;
        }
        flattenBT(node.right, tree);
    }

    private static Node checkFirstEmptyRightInLeftSubTree(Node node) {
        if (node == null) {
            return node;
        }

        if (node.right == null) {
            return node;
        }

        return checkFirstEmptyRightInLeftSubTree(node.right);
    }

    // best method
    private static void flattenBinaryTreeToLL(Node node, Trees tree) {
        if (node == null) {
            return;
        }

        Node current = node;
        while (current != null) {
            // tree.display();
            Node rightEmpty = current.left;
            if (rightEmpty != null) {
                Node right = current.right;
                while (rightEmpty != null && rightEmpty.right != null) {
                    rightEmpty = rightEmpty.right;
                }
                rightEmpty.right = right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

}

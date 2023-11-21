package DataStructures.Trees.Problems.DFS;

import DataStructures.Trees.Theory.Trees;
import DataStructures.Trees.Theory.Trees.Node;

// Lowest Common Ansector
public class LCA {
    public static void main(String[] args) {
        Trees tree = new Trees();
        tree.root = tree.createNode(4);
        tree.root.left = tree.createNode(2);
        tree.root.right = tree.createNode(7);
        tree.root.left.left = tree.createNode(1);
        tree.root.left.right = tree.createNode(3);
        tree.root.right.left = tree.createNode(6);
        tree.root.right.right = tree.createNode(9);
        tree.display();
        Node p = tree.root.right.left;
        Node q = tree.root.right.right;
        Node res = lowestCommonAnsector(tree.root, p, q);
        System.out.println("The LCA of " + p.value + " " + q.value + " is " + res.value);
    }

    private static Node lowestCommonAnsector(Node node, Node p, Node q) {
        if (node == null)
            return null;

        if (node == p || node == q) {
            return node;
        }

        Node left = lowestCommonAnsector(node.left, p, q);
        Node right = lowestCommonAnsector(node.right, p, q);

        if (left != null && right != null) {
            return node;
        }

        if (left == null)
            return right;
        else
            return left;
    }

}

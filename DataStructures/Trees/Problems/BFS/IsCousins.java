package DataStructures.Trees.Problems.BFS;

import DataStructures.Trees.Theory.BST;
import DataStructures.Trees.Theory.BST.Node;

public class IsCousins {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = { 4, 2, 6, 1, 3, 7, 5 };
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }
        bst.display();
        int x = 3;
        int y = 5;
        boolean res = isCousins(bst.root, x, y);
        System.out.println(res);
    }

    private static boolean isCousins(Node root, int x, int y) {
        // 1) check the existence of the node
        Node xx = check(root, x);
        Node yy = check(root, y);
        // if either one of the node is null then false
        // and if either one of the node is root then it cannot be cousins
        if (xx == null || yy == null || xx.value == root.value || yy.value == root.value) {
            return false;
        }
        // 2) find the level of both the nodes
        // if they are in same node then they may be cousins
        int levelX = level(root, xx, 0);
        int levelY = level(root, yy, 0);
        // 3) Check both the nodes are siblings(having same parent)
        Node parentX = findParent(root, xx);
        Node parentY = findParent(root, yy);
        // if no they must be cousins

        System.out
                .println(xx != null ? (xx.value + " level size is " + levelX + " and their parent is " + parentX.value)
                        : "NULL");
        System.out
                .println(yy != null ? (yy.value + " level size is " + levelY + " and their parent is " + parentY.value)
                        : "NULL");

        return (levelX == levelY) && (!isSiblings(root, xx, yy));
    }

    private static Node findParent(Node node, Node z) {
        if (node == null) {
            return node;
        }

        if (node.left != null && node.left.value == z.value) {
            return node;
        }

        if (node.right != null && node.right.value == z.value) {
            return node;
        }

        Node left = findParent(node.left, z);
        Node right = findParent(node.right, z);

        return (left != null) ? left : right;
    }

    private static boolean isSiblings(Node node, Node x, Node y) {
        if (node == null) {
            return false;
        }

        return ((node.left == x && node.right == y)
                || (node.left == y && node.right == x) ||
                isSiblings(node.left, x, y) || isSiblings(node.right, x, y));
    }

    private static int level(Node node, Node z, int lvl) {
        if (node == null) {
            return 0;
        }

        if (node == z) {
            return lvl;
        }

        int left = level(node.left, z, lvl + 1);
        if (left != 0)
            return left;
        return level(node.right, z, lvl + 1);
    }

    private static Node check(Node node, int z) {
        if (node == null) {
            return node;
        }

        if (node.value == z) {
            return node;
        }

        Node left = check(node.left, z);
        Node right = check(node.right, z);

        return (left != null) ? left : right;
    }
}

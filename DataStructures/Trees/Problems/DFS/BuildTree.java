package DataStructures.Trees.Problems.DFS;

import java.util.Arrays;

import DataStructures.Trees.Theory.Node;

public class BuildTree {
    public static void main(String[] args) {
        int[] preOrder = { 3, 8, 9, 20, 15, 7 };
        int[] inOrder = { 8, 9, 3, 15, 20, 7 };
        Node root = buildTree(preOrder, inOrder);
        prettyDisplay(root, 0);
    }

    public static Node buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder.length == 0 || inOrder.length == 0) {
            return null;
        }

        int nodeVal = preOrder[0];
        int index = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (nodeVal == inOrder[i]) {
                index = i;
                break;
            }

        }

        Node node = new Node(nodeVal);

        int[] leftPreOrder = Arrays.copyOfRange(preOrder, 1, index + 1);
        int[] leftInOrder = Arrays.copyOfRange(inOrder, 0, index);
        node.left = buildTree(leftPreOrder, leftInOrder);
        //
        int[] rightPreOrder = Arrays.copyOfRange(preOrder, index + 1, preOrder.length);
        int[] rightInOrder = Arrays.copyOfRange(inOrder, index + 1, inOrder.length);
        node.right = buildTree(rightPreOrder, rightInOrder);

        return node;
    }

    private static void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level == 0) {
            // root node
            System.out.println(node.value);
        } else {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("     ");
            }
            System.out.println("|--->" + node.value);
        }

        prettyDisplay(node.left, level + 1);
    }
}

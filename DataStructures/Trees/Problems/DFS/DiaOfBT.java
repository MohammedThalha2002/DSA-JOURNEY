package DataStructures.Trees.Problems.DFS;

import DataStructures.Trees.Theory.BST;
import DataStructures.Trees.Theory.BST.Node;

public class DiaOfBT {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = { 4, 2, 6, 1, 3, 7, 5 };
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }
        bst.display();
        int res = findDiameter(bst.root);
        System.out.println(res);
    }

    static int diameter = 0;

    private static int findDiameter(Node node) {
        findHeight(node);
        return diameter - 1;
    }

    private static int findHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        int dia = leftHeight + rightHeight;
        diameter = Math.max(diameter, dia);

        int height = Math.max(leftHeight, rightHeight) + 1;

        return height;
    }

}

package DataStructures.Trees.Problems.DFS;

import DataStructures.Trees.Theory.BST;
import DataStructures.Trees.Theory.BST.Node;

public class SumRoot2Leaf {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = { 5, 3, 6, 2, 4, 1 };
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }
        bst.display();
        int targetSum = 12;
        boolean res = rootToLeafSum(bst.root, targetSum);
        System.out.println("The path sum " + targetSum + (res ? " exits" : " not exists"));
    }

    private static boolean rootToLeafSum(Node root, int targetSum) {
        return false;
    }
}

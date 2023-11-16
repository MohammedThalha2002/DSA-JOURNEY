package DataStructures.Trees.Problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import DataStructures.Trees.Theory.BST;
import DataStructures.Trees.Theory.BST.Node;

public class IsSymmteric {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = { 4, 2, 6, 1, 3, 7, 5 };
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }
        bst.display();
        boolean res = isSymmetric(bst.root);
        System.out.println(res);
    }

    private static boolean isSymmetric(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int lvlSize = queue.size();

            for (int i = 0; i < lvlSize; i++) {

            }
        }

        return false;
    }
}

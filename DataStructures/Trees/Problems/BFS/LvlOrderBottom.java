package DataStructures.Trees.Problems.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import DataStructures.Trees.Theory.BST;
import DataStructures.Trees.Theory.BST.Node;

public class LvlOrderBottom {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = { 4, 2, 6, 1, 3, 7, 5 };
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }
        bst.display();
        List<List<Integer>> res = lvlOrderBottom(bst.root);
        System.out.println(res);
    }

    public static List<List<Integer>> lvlOrderBottom(Node node) {
        List<List<Integer>> outer = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int innerListSize = queue.size();
            List<Integer> inner = new ArrayList<>();

            for (int i = 0; i < innerListSize; i++) {
                Node popped = queue.poll();
                inner.add(popped.value);

                if (popped.left != null) {
                    queue.add(popped.left);
                }
                if (popped.right != null) {
                    queue.add(popped.right);
                }
            }
            outer.add(0, inner);

        }

        return outer;
    }
}

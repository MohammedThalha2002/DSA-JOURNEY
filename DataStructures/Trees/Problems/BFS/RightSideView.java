package DataStructures.Trees.Problems.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import DataStructures.Trees.Theory.BST;
import DataStructures.Trees.Theory.BST.Node;

public class RightSideView {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = { 4, 2, 6, 1, 3, 7, 5 };
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }
        bst.display();

        List<Integer> res = printRightSideView(bst.root);
        System.out.println(res);
    }

    private static List<Integer> printRightSideView(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node popNode = queue.poll();
                //
                if (i == levelSize - 1) {
                    list.add(popNode.value);
                }

                if (popNode.left != null) {
                    queue.offer(popNode.left);
                }

                if (popNode.right != null) {
                    queue.offer(popNode.right);
                }
            }
        }

        return list;
    }
}

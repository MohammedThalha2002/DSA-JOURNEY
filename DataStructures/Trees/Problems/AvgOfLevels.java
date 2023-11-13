package DataStructures.Trees.Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import DataStructures.Trees.Theory.BST;
import DataStructures.Trees.Theory.BST.Node;

public class AvgOfLevels {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = { 4, 2, 6, 1, 3, 7, 5 };
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }
        bst.display();

        List<Double> res = calculateAverageOfLevels(bst.root);
        System.out.println(res);
    }

    private static List<Double> calculateAverageOfLevels(Node node) {

        if (node == null) {
            return new ArrayList<>();
        }

        List<Double> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double avg = 0;
            for (int i = 0; i < levelSize; i++) {
                Node popped = queue.poll();
                avg += popped.value;

                if(popped.left != null){
                    queue.offer(popped.left);
                }

                if(popped.right != null){
                    queue.offer(popped.right);
                }
            }
            avg = avg/levelSize;
            list.add(avg);
        }

        return list;
    }
}

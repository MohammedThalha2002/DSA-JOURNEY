package DataStructures.Trees.Problems.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import DataStructures.Trees.Theory.BST;
import DataStructures.Trees.Theory.BST.Node;

public class PossiblePathSum {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = { 4, 3, 6, 2, 3, 10, 5 };
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }
        bst.display();
        int sum = 10;
        int res = possiblePathSums(bst.root, sum);
        System.out.println("The total possibilities of the given path sum are " + res);
        System.out.println(paths);
    }

    static List<Integer> list = new ArrayList<>();
    static List<List<Integer>> paths = new ArrayList<>();

    private static int possiblePathSums(Node node, int sum) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            list.add(node.value);
            int poss = checkTotalPossibility(sum);
            list.remove(list.size() - 1);
            return poss;
        }

        list.add(node.value);
        int left = possiblePathSums(node.left, sum);
        int right = possiblePathSums(node.right, sum);

        int poss = checkTotalPossibility(sum);
        list.remove(list.size() - 1);

        return poss + left + right;
    }

    private static int checkTotalPossibility(int sum) {
        int count = 0;
        int s = 0;
        ListIterator<Integer> itr = list.listIterator(list.size());
        List<Integer> path = new ArrayList<>();
        while (itr.hasPrevious()) {
            int p = itr.previous();
            s += p;

            if (s > sum) {
                break;
            }

            if (s == sum) {
                count++;
            }
            path.add(p);
        }
        if (count != 0) {
            paths.add(path);
        }
        // System.out.println(list + " | with sum => " + count);
        return count;
    }
}

package DataStructures.Trees.Problems.BFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import DataStructures.Trees.Theory.BST;
import DataStructures.Trees.Theory.BST.Node;

public class ZigZagTraversal {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = { 4, 2, 6, 1, 3, 7, 5 };
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }
        bst.display();
        // normal method
        List<List<Integer>> res = zigagTraversal(bst.root);
        System.out.println(res);
        // using DEQUE
        List<List<Integer>> res1 = zigagTraversalUsingDequeu(bst.root);
        System.out.println(res1);
    }

    private static List<List<Integer>> zigagTraversal(Node node) {
        List<List<Integer>> ouList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        boolean isRev = false;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> inner = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node popped = queue.poll();
                inner.add(popped.value);

                if (popped.left != null) {
                    queue.offer(popped.left);
                }
                if (popped.right != null) {
                    queue.offer(popped.right);
                }
            }

            if (isRev == true) {
                int i = 0, j = inner.size() - 1;
                while (j > i) {
                    int temp = inner.get(i);
                    inner.set(i, inner.get(j));
                    inner.set(j, temp);
                    i++;
                    j--;
                }
                ouList.add(inner);
            } else {
                ouList.add(inner);
            }
            isRev = !isRev;

        }

        return ouList;
    }

    private static List<List<Integer>> zigagTraversalUsingDequeu(Node node) {
        List<List<Integer>> ouList = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        deque.offer(node);

        boolean isRev = false;
        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> inner = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                if (isRev) {
                    // remove from last and add at front
                    Node popped = deque.pollLast();
                    inner.add(popped.value);

                    if (popped.right != null) {
                        deque.addFirst(popped.right);
                    }
                    if (popped.left != null) {
                        deque.addFirst(popped.left);
                    }
                } else {
                    // remove from front add at last => normal queue
                    Node popped = deque.pollFirst();
                    inner.add(popped.value);

                    if (popped.left != null) {
                        deque.addLast(popped.left);
                    }
                    if (popped.right != null) {
                        deque.addLast(popped.right);
                    }
                }
            }
            isRev = !isRev;
            ouList.add(inner);

        }

        return ouList;
    }

}

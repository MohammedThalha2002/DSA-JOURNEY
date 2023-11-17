package DataStructures.Trees.Problems.BFS;

import java.util.LinkedList;
import java.util.Queue;

import DataStructures.Trees.Theory.BST;
import DataStructures.Trees.Theory.BST.Node;

public class LvlOrderSuccessor {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = { 4, 2, 6, 1, 3, 7, 5 };
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }
        bst.display();

        int key = 6;
        Node successor = findLevelOrderSuccessor(bst.root, key);
        System.out.println(
                "The level order successor of " + key + " is " + (successor != null ? successor.value : "null"));
    }

    public static Node findLevelOrderSuccessor(Node node, int key) {

        if (node == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node popped = queue.poll();

            if (popped.left != null) {
                queue.offer(popped.left);
            }
            if (popped.right != null) {
                queue.offer(popped.right);
            }

            if (key == popped.value) {
                if (queue.peek() != null)
                    return queue.peek();
            }
        }

        return null;
    }
}

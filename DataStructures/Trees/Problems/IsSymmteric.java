package DataStructures.Trees.Problems;

import java.util.LinkedList;
import java.util.Queue;

import DataStructures.Trees.Theory.Trees;
import DataStructures.Trees.Theory.Trees.Node;

public class IsSymmteric {
    public static void main(String[] args) {
        Trees tree = new Trees();
        tree.root = tree.createNode(1);
        tree.root.left = tree.createNode(2);
        tree.root.right = tree.createNode(2);
        tree.root.left.left = null;
        tree.root.left.right = tree.createNode(3);
        tree.root.right.left = tree.createNode(3);
        tree.root.right.right = null;

        tree.display();

        boolean res = isSymmetric(tree.root);
        System.out.println(res);
    }

    private static boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            Node popLeft = queue.poll();
            Node popRight = queue.poll();

            if (popLeft == null && popRight == null) {
                continue;
            }

            if (popLeft == null || popRight == null) {
                return false;
            }

            System.out.println(popLeft.value + " " + popRight.value);

            if (popLeft.value != popRight.value) {
                return false;
            }

            queue.add(popLeft.left);
            queue.add(popRight.right);
            queue.add(popLeft.right);
            queue.add(popRight.left);
        }

        return true;
    }
}

package DataStructures.Trees.Theory;

import java.util.Scanner;

public class Trees {

    private Node root;

    public Trees() {

    }

    private class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public void populate(Scanner sc) {
        System.out.println("Enter the root node value : ");
        int value = sc.nextInt();
        root = new Node(value);

        populate(sc, root);
    }

    public void populate(Scanner sc, Node node) {
        System.out.println("Do you want to add a Left Node for " + node.value);
        boolean addLeft = sc.nextBoolean();

        if (addLeft) {
            System.out.println("Enter the left node value : ");
            int left = sc.nextInt();
            node.left = new Node(left);
            // recursion
            populate(sc, node.left);
        }

        System.out.println("Do you want to add a Right Node for " + node.value);
        boolean addRight = sc.nextBoolean();

        if (addRight) {
            System.out.println("Enter the right node value : ");
            int right = sc.nextInt();
            node.right = new Node(right);
            // recursion
            populate(sc, node.right);
        }
    }

    public void display() {
        // display(root, "");
        prettyDisplay(root, 0);
    }

    private void display(Node node, String intend) {
        if (node == null) {
            return;
        }
        System.out.println(intend + node.value);
        display(node.left, intend + "\t");
        display(node.right, intend + "\t");
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level == 0) {
            // root node
            System.out.println(node.value);
        } else {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("     ");
            }
            System.out.println("|--->" + node.value);
        }

        prettyDisplay(node.left, level + 1);
    }
}

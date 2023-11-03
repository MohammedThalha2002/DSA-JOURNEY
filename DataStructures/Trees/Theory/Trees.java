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


    public void populate(Scanner sc){
        System.out.println("Enter the root node value : ");
        int value = sc.nextInt();
        root = new Node(value);

        populate(sc, root);
    }

    public void populate(Scanner sc, Node node){
        System.out.println("Do you want to add a Left Node for " + node.value);
        boolean addLeft = sc.nextBoolean();

        if(addLeft){
            System.out.println("Enter the left node value : ");
            int left = sc.nextInt();
            node.left = new Node(left);
            // recursion
            populate(sc, node.left);
        }

        System.out.println("Do you want to add a Right Node for " + node.value);
        boolean addRight = sc.nextBoolean();

        if(addRight){
            System.out.println("Enter the right node value : ");
            int right = sc.nextInt();
            node.right = new Node(right);
            // recursion
            populate(sc, node.right);
        }
    }

    public void display(){
        display(root, "");
    }

    private void display(Node node, String intend) {
        System.out.println(node.value + intend );
        display(node.left, intend + "\t");
        display(node.right, intend + "\t");
    }
}

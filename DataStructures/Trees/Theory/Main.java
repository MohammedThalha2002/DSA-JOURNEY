package DataStructures.Trees.Theory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // Trees tree = new Trees();
        // tree.populate(sc);
        // tree.display();
        // sc.close();

        BST bst = new BST();
        int[] arr = { 10, 5, 15, 20, 2, 7, 12, 15 };
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }
        System.out.println("Root Height : " + bst.printRootHeight());
        System.out.println(bst.isBalanced());
        bst.display();
    }
}

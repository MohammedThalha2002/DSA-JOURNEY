package DataStructures.Trees.Theory;

public class Main {
    public static void main(String[] args) {
        System.out.println("Binary Search Tree");
        BST bst = new BST();
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }
        System.out.println("Root Height : " + bst.printRootHeight());
        System.out.println(bst.isBalanced() ? "Tree is balanced" : "Tree is Unbalanced");
        bst.display();
        
        System.out.println("Avial Tree");
        AVL avl = new AVL();
        for (int i = 0; i < arr.length; i++) {
            avl.insert(arr[i]);
        }
        System.out.println("Root Height : " + avl.printRootHeight());
        System.out.println(avl.isBalanced() ? "Tree is balanced" : "Tree is Unbalanced");
        avl.display();
    }
}

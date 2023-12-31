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

        System.out.println("Segment Tree");
        int[] data = { 1, 2, 3, 4, 5 };
        SegmentTree segmentTree = new SegmentTree(data);
        segmentTree.createTree();
        segmentTree.display();
        System.out.println("Sum between 2,4 is " + segmentTree.query(2, 4));
        System.out.println();
        // updating a value
        segmentTree.update(2, 4);
        segmentTree.display();
        System.out.println("Sum between 2,4 is " + segmentTree.query(2, 4));
    }
}

package DataStructures.Trees.Theory;

public class BST {
    private Node root;

    public BST() {
    }

    private class Node {
        Node left;
        Node right;
        int value;
        int height;

        public Node(int value) {
            this.value = value;
        }
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }

        return node.height;
    }

    public int printRootHeight() {
        if (root == null) {
            return -1;
        }

        return root.height;
    }

    public void insert(int val) {
        insert(root, val);
    }

    public void insert(Node node, int val) {
        // adding the first root node
        if (root == null) {
            root = new Node(val);
            return;
        }

        if (node == null) {
            return;
        }

        if (val < node.value) {
            insert(node.left, val);
            if (node.left == null)
                node.left = new Node(val);
        } else {
            insert(node.right, val);
            if (node.right == null)
                node.right = new Node(val);
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    public void display() {
        // display(root, "");
        prettyDisplay(root, 0);
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
                System.out.print("|    ");
            }
            System.out.println("|--->" + node.value);
        }

        prettyDisplay(node.left, level + 1);
    }
}

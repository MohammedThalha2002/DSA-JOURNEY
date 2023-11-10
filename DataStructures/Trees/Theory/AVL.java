package DataStructures.Trees.Theory;

public class AVL {
    public Node root;

    public AVL() {
    }

    public class Node {
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
        root.height = Math.max(height(root.left), height(root.right)) + 1;
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

        // insert left
        if (val < node.value) {
            insert(node.left, val);
            if (node.left == null)
                node.left = new Node(val);
        } else {
            // insert right
            insert(node.right, val);
            if (node.right == null)
                node.right = new Node(val);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        rotate(node);
    }

    private void rotate(Node node) {
        // left heavy
        if (height(node.left) - height(node.right) > 1) {
            // left-left-case
            if (height(node.left.left) > height(node.left.right)) {
                rotateRight(node);
            }
            // left-right-case
            if (height(node.left.right) > height(node.left.left)) {
                rotateLeft(node.left);
                rotateRight(node);
            }
        }

        // right heavy
        if (height(node.right) - height(node.left) > 1) {
            // right-right-case
            if (height(node.right.right) > height(node.right.left)) {
                rotateLeft(node);
            }
            // right-left-case
            if (height(node.right.left) > height(node.right.right)) {
                rotateRight(node.right);
                rotateLeft(node);
            }
        }
    }

    private void rotateLeft(Node left) {
    }

    private void rotateRight(Node node) {
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        return Math.abs(height(node.right) - height(node.left)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
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

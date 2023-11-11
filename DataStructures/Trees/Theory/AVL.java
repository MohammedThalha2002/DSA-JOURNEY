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
        root = insert(root, val);
    }

    public Node insert(Node node, int val) {
        if (node == null) {
            Node newNode = new Node(val);
            return newNode;
        }

        // insert left
        if (val < node.value) {
            node.left = insert(node.left, val);
        } else {
            // insert right
            node.right = insert(node.right, val);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    private Node rotate(Node node) {
        // left heavy
        if (height(node.left) - height(node.right) > 1) {
            // left-left-case
            if (height(node.left.left) > height(node.left.right)) {
                return rotateRight(node);
            }
            // left-right-case
            if (height(node.left.right) > height(node.left.left)) {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }

        // right heavy
        if (height(node.right) - height(node.left) > 1) {
            // right-right-case
            if (height(node.right.right) > height(node.right.left)) {
                return rotateLeft(node);
            }
            // right-left-case
            if (height(node.right.left) > height(node.right.right)) {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }
        return node;
    }

    private Node rotateLeft(Node p) {
        // rotate left
        Node c = p.right;
        Node t = c.left;

        c.left = p;
        p.right = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

    private Node rotateRight(Node p) {
        // rotate right
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
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

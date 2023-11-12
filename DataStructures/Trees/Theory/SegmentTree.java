package DataStructures.Trees.Theory;

public class SegmentTree {

    Node root;
    int[] arr;

    class Node {
        int data;
        int leftInterval;
        int rightInterval;
        Node left;
        Node right;

        public Node(int leftInterval, int rightInterval) {
            this.leftInterval = leftInterval;
            this.rightInterval = rightInterval;
            this.left = null;
            this.right = null;
        }
    }

    public SegmentTree(int[] arr) {
        this.arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            this.arr[i] = arr[i];
        }
    }

    public void createTree() {
        root = constructTree(this.arr, 0, this.arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        // base case
        if (start == end) {
            int data = arr[start]; // arr[end]
            Node node = new Node(start, end);
            node.data = data;
            return node;
        }

        Node node = new Node(start, end);

        int mid = (start + end) / 2;

        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);
        node.data = node.left.data + node.right.data;

        return node;
    }

    public int query(int start, int end) {
        return query(root, start, end);
    }

    private int query(Node node, int start, int end) {
        // base

        if (start > node.rightInterval || end < node.leftInterval) {
            return 0;
        }

        if (start <= node.leftInterval && end >= node.rightInterval) {
            return node.data;
        }

        int sum = 0;

        sum += query(node.left, start, end);
        sum += query(node.right, start, end);

        return sum;
    }

    public void update(int index, int value) {
        update(root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.leftInterval && index <= node.rightInterval) {
            if (index == node.leftInterval && index == node.rightInterval) {
                node.data = value;
                return node.data;
            }

            int leftVal = update(node.left, index, value);
            int rightVal = update(node.right, index, value);

            node.data = leftVal + rightVal;
        }

        return node.data;
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
            System.out.println(node.data + "(" + node.leftInterval + "," + node.rightInterval + ")");
        } else {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|         ");
            }
            System.out.println("|-------->" + node.data + "(" + node.leftInterval + "," + node.rightInterval + ")");
        }

        prettyDisplay(node.left, level + 1);
    }
}

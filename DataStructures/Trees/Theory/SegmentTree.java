package DataStructures.Trees.Theory;

public class SegmentTree {

    Node root;

    class Node {
        int data;
        int leftInterval;
        int rightInterval;
        Node left;
        Node right;

        public Node(int data, int leftInterval, int rightInterval) {
            this.data = data;
            this.leftInterval = leftInterval;
            this.rightInterval = rightInterval;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(int[] arr) {
        root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int leftInterval, int rightInterval) {
        // base case
        if (leftInterval == rightInterval) {
            return createNode(arr, leftInterval, rightInterval);
        }

        Node node = createNode(arr, leftInterval, rightInterval);

        int mid = (leftInterval + rightInterval) / 2;
        node.left = constructTree(arr, leftInterval, mid);
        node.right = constructTree(arr, mid + 1, rightInterval);

        return node;
    }

    public Node createNode(int[] arr, int leftInterval, int rightInterval) {
        int sum = 0;
        for (int k = leftInterval; k < rightInterval + 1; k++) {
            sum += arr[k];
        }

        Node node = new Node(sum, leftInterval, rightInterval);
        return node;
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
            System.out.println(node.data);
        } else {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|    ");
            }
            System.out.println("|--->" + node.data);
        }

        prettyDisplay(node.left, level + 1);
    }
}

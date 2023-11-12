package DataStructures.Trees.Theory;

public class SegmentTree {

    Node root;

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

    public void createTree(int[] arr) {
        root = constructTree(arr, 0, arr.length - 1);
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

    public int query(int start, int end){
        return query(root, start, end);
    }

    public int query(Node node, int start, int end){
        // base

        if(start > node.rightInterval || end < node.leftInterval){
            return 0;
        }

        if(start >= node.leftInterval && end <= node.rightInterval){
            return node.data;
        }
        
        int sum = 0;

        if(start >= node.leftInterval){
            return node.data;
        }



        return sum;
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

package DataStructures.Trees.Theory;

public class Node {
    public Node left;
    public Node right;
    public int value;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    public static void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level == 0) {
            // root node
            System.out.println(node.value);
        } else {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("     ");
            }
            System.out.println("|--->" + node.value);
        }

        prettyDisplay(node.left, level + 1);
    }
}
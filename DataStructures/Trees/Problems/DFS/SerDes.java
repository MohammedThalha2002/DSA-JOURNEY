package DataStructures.Trees.Problems.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import DataStructures.Trees.Theory.Node;

public class SerDes {
    Node root;
    static List<String> inOrder = new ArrayList<>();

    public SerDes() {
        this.root = null;
    }

    public static void main(String[] args) {
        SerDes tree = new SerDes();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(5);
        Node.prettyDisplay(tree.root, 0);
        System.out.println("Serialization\n----------------------");
        serializeTree(tree.root);
        System.out.println("----------------------\nDeserialization");
        deSerializeTree();
    }

    public static void serializeTree(Node node) {
        inOrder(node, inOrder);
        System.out.println(inOrder);
    }

    private static void inOrder(Node node, List<String> inOrderStr) {
        if (node == null) {
            inOrderStr.add("null");
            return;
        }

        inOrderStr.add(String.valueOf(node.value));
        inOrder(node.left, inOrderStr);
        inOrder(node.right, inOrderStr);
    }

    public static void deSerializeTree() {
        if (inOrder.size() == 0) {
            return;
        }

        Collections.reverse(inOrder);

        Node node = constructTree(inOrder);
        Node.prettyDisplay(node, 0);
    }

    private static Node constructTree(List<String> inOrderStr) {
        if (inOrderStr.size() == 0) {
            return null;
        }

        if (inOrderStr.get(inOrderStr.size() - 1) == "null") {
            inOrderStr.remove(inOrderStr.size() - 1);
            return null;
        }

        Node node = new Node(Integer.parseInt(inOrderStr.remove(inOrderStr.size() - 1)));
        node.left = constructTree(inOrderStr);
        node.right = constructTree(inOrderStr);
        return node;
    }

}

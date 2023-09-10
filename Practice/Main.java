package Practice;

import java.util.*;

class TreeNode {
    int value;
    List<TreeNode> children;

    public TreeNode(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
}

public class Main {
    public static void main(String[] args) {
        // Construct your tree here
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);

        node1.children.add(node4);
        node1.children.add(node5);
        node2.children.add(node6);

        int count = countNonLeafNodesWithThreeLeafChildren(root);
        System.out.println("Number of non-leaf nodes with at least three leaf children: " + count);
    }

    public static int countNonLeafNodesWithThreeLeafChildren(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Check if the node is a non-leaf node and has at least three leaf children
        if (!node.children.isEmpty()) {
            int leafChildCount = 0;

            for (TreeNode child : node.children) {
                if (child.children.isEmpty()) {
                    leafChildCount++;
                }
            }

            if (leafChildCount >= 3) {
                return 1 + countNonLeafNodesWithThreeLeafChildren(node); // Count this node
            }
        }

        int count = 0;

        // Recursively count non-leaf nodes with at least three leaf children in
        // children
        for (TreeNode child : node.children) {
            count += countNonLeafNodesWithThreeLeafChildren(child);
        }

        return count;
    }
}

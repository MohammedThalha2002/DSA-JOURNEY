package DataStructures.LinkedList.Problems;

import DataStructures.LinkedList.Problems.LL.Node;

public class ReverseLL {
    public static void main(String[] args) {
        LL list = new LL();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.display();
        // reverseLL(list.head, list);
        inPlaceReversal(list);
        list.display();
    }

    // reversal using recursion
    private static Node reverseLL(Node node, LL list) {
        if (node.next == null) {
            list.head = node;
            return node;
        }

        Node tail = reverseLL(node.next, list);
        tail.next = node;
        tail = node;
        tail.next = null;

        return tail;
    }

    // in-place reversal
    public static void inPlaceReversal(LL list) {
        if (list.head == null || list.head.next == null) {
            return;
        }
        Node prev = null;
        Node first = list.head;
        Node next = first.next;

        while (first.next != null) {
            first.next = prev;
            prev = first;
            first = next;
            if (next != null)
                next = next.next;
            list.head = prev;
        }
    }
}

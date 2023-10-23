package DataStructures.LinkedList.Problems;

import DataStructures.LinkedList.Problems.LL.Node;

public class ReverseSubLL {
    public static void main(String[] args) {
        LL list = new LL();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.display();
        int left = 3;
        int right = 1;
        reverseSubLL(list, left, right);
        list.display();
    }

    public static void reverseSubLL(LL list, int left, int right) {
        if (list.head == null || list.head.next == null || left < 1 || right > list.size() || right < left || left == right) {
            return;
        }

        Node before = null;
        Node newEnd = list.head;
        // traversing until we reach the left and marking it as a new End
        for (int i = 1; newEnd != null && i < left; i++) {
            before = newEnd;
            newEnd = newEnd.next;
        }

        // now reverse from the new end till right
        Node prev = null;
        Node curr = newEnd;
        Node next = curr.next;

        for (int j = left; curr != null && j < right + 1; j++) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (before != null)
            before.next = prev;
        else {
            list.head = prev;
        }

        newEnd.next = curr;

    }
}

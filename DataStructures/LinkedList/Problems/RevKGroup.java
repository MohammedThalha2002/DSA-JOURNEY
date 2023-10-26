package DataStructures.LinkedList.Problems;

import DataStructures.LinkedList.Problems.LL.Node;

public class RevKGroup {
    public static void main(String[] args) {
        LL list = new LL();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.display();
        int k = 2;
        reverseKGroups(list, k);
    }

    public static void reverseKGroups(LL list, int k) {
        if (list.head == null || k == 1) {
            return;
        }

        Node head = list.head;

        Node prev = null;
        Node curr = head;
        Node next = curr.next;
        Node prevLast = curr;
        Node newFirst = curr;
        Node endLast = curr;

        for (int j = 0; j < k; j++) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null)
                next = next.next;
        }

        head = prev;
        list.display(prev);

        while (next != null) {
            //
            endLast = curr;
            prev = null;
            for (int j = 0; j < k; j++) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null)
                    next = next.next;
            }

            newFirst = prev;
            prevLast.next = newFirst;
            prevLast = endLast;
            list.display(prev);
            list.display(head);
        }

        if (curr != null) {
            endLast.next = curr;
        }

        list.display(head);
    }
}

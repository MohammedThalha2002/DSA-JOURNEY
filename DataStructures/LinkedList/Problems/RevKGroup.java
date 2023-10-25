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
        list.display();
        int k = 2;
        reverseKGroups(list, k);
        // list.display();
    }

    public static void reverseKGroups(LL list, int k) {
        int size = list.size();
        Node head = list.head;

        Node prev = null;
        Node curr = head;
        Node next = curr.next;

        for (int i = 1; i < size; i += k) {
            //
            Node start = curr;
            for (int j = 0; j < k; j++) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null)
                    next = next.next;
            }

            head = curr;
            list.display(prev);
        }
    }
}

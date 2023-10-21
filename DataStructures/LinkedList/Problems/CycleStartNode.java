package DataStructures.LinkedList.Problems;

import DataStructures.LinkedList.Problems.LL.Node;

public class CycleStartNode {
    public static void main(String[] args) {
        LL list = new LL();

        list.insert(1);
        list.insert(1);
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(4);
        list.display();
        detectCycle(list.head);
        System.out.println();
    }

    public static Node detectCycle(Node head) {
        Node fast = head;
        Node slow = head;
        int size = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                do {
                    slow = slow.next;
                    size++;
                } while (slow != fast);

                break;
            }
        }

        System.out.println(size);
        if (size == 0) {
            return null;
        }

        fast = head;
        slow = head;
        for (int i = 1; i <= size; i++) {
            slow = slow.next;
        }

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}

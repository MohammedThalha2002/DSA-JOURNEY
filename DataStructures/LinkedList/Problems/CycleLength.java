package DataStructures.LinkedList.Problems;

import DataStructures.LinkedList.Problems.LL.Node;

public class CycleLength {
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
        int length = cycleLength(list);
        System.out.println(length);
    }

    private static int cycleLength(LL list) {
        int size = 0;
        Node fast = list.head;
        Node slow = list.head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                do {
                    slow = slow.next;
                    size++;
                } while (slow != fast);
                return size;
            }
        }
        return size;
    }
}

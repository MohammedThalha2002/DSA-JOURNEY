package DataStructures.LinkedList.Problems;

import DataStructures.LinkedList.Problems.LL.Node;

public class MiddleNode {
    public static void main(String[] args) {
        LL list = new LL();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.display();
        int middle = findMiddleNode(list.head);
        System.out.println(middle);
    }

    private static int findMiddleNode(Node head) {
        if (head == null) {
            return -1;
        }
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // when the fast reaches the end the slow will be half of the value of the fast
        // which is the middle node of the list
        return slow.value;
    }
}

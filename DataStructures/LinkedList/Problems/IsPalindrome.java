package DataStructures.LinkedList.Problems;

import DataStructures.LinkedList.Problems.LL.Node;

public class IsPalindrome {
    public static void main(String[] args) {
        LL list = new LL();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(2);
        list.insert(1);
        list.display();
        boolean res = isPalindrome(list);
        System.out.println(res);
    }

    private static boolean isPalindrome(LL list) {
        if (list.head == null || list.head.next == null || list.head.next.next == null) {
            return true;
        }

        // find the mid
        Node slow = list.head;
        Node fast = list.head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // mid val
        Node mid = slow;
        // System.out.println(mid.value);

        Node prev = null;
        Node curr = mid;
        Node next = mid.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }
        mid = prev;
        Node head = list.head;
        list.display(head);
        list.display(mid);

        while (head != null && mid != null) {
            if (head.value != mid.value)
                return false;
            head = head.next;
            mid = mid.next;
        }

        return true;
    }
}

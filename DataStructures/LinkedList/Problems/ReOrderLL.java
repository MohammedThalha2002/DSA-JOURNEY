package DataStructures.LinkedList.Problems;

import DataStructures.LinkedList.Problems.LL.Node;

public class ReOrderLL {
    public static void main(String[] args) {
        LL list = new LL();

        list.insert(1);
        list.insert(2);
        list.insert(4);
        list.insert(5);
        list.display();
        reorderLL(list);
        list.display();
    }

    private static void reorderLL(LL list) {
        if (list.head == null || list.head.next == null || list.head.next.next == null) {
            return;
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

        while(head != null && head.next != null && mid != null && mid.next != null){
            Node headNext = head.next;
            Node midNext = mid.next;
            // 
            head.next = mid;
            mid.next = headNext;
            // 
            head = headNext;
            mid = midNext;
        }
        
    }
}

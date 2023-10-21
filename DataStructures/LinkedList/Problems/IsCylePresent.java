package DataStructures.LinkedList.Problems;

import DataStructures.LinkedList.Problems.LL.Node;

public class IsCylePresent {
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
        System.out.println(isCyclePresent(list));
    }

    private static boolean isCyclePresent(LL list) {
        Node fast = list.head;
        Node slow = list.head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}

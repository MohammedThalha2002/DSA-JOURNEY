package DataStructures.LinkedList.Problems;

import DataStructures.LinkedList.Problems.LL.Node;

public class RotateRight {
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
        reverseRight(list, k);
        list.display();
    }

    public static void reverseRight(LL list, int k) {
        Node prev = null;
        Node curr = list.head;
        for (int i = 0; i < (k % list.size()); i++) {
            //
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            //
            prev.next = null;
            curr.next = list.head;
            list.head = curr;
        }
    }
}

package DataStructures.LinkedList.Problems;

import DataStructures.LinkedList.Problems.LL.Node;

public class RemoveDuplicates {
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
        removeDuplicates(list);
        list.display();
    }

    public static void removeDuplicates(LL list) {
        Node head = list.head;
        if (head == null) {
            return;
        }
        Node currNode = head;

        while (currNode.next != null) {
            if (currNode.value == currNode.next.value) {
                currNode.next = currNode.next.next;
            } else {
                currNode = currNode.next;
            }
        }
    }
}

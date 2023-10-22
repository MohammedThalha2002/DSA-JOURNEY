package DataStructures.LinkedList.Problems;

import DataStructures.LinkedList.Problems.LL.Node;

public class MergeSort {
    public static void main(String[] args) {
        LL list = new LL();

        list.insert(2);
        list.insert(5);
        list.insert(1);
        list.insert(4);
        list.insert(3);
        list.insert(-1);
        list.display();

        Node ansHead = mergerSort(list.head);
        System.out.println("The sorted list is ");
        System.out.println("---------------------------------");
        display(ansHead);
        System.out.println("---------------------------------");
    }

    public static Node mergerSort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node mid = findMiddleNode(node);
        // System.out.println(mid.value);
        Node nextToMid = mid.next;
        mid.next = null;
        //
        Node left = mergerSort(node);
        display(left);
        Node right = mergerSort(nextToMid);
        display(right);

        return merge(left, right);

    }

    public static Node merge(Node first, Node second) {
        LL ans = new LL();
        while (first != null && second != null) {
            if (first.value < second.value) {
                ans.insert(first.value);
                first = first.next;
            } else {
                ans.insert(second.value);
                second = second.next;
            }
        }

        while (first != null) {
            ans.insert(first.value);
            first = first.next;
        }
        while (second != null) {
            ans.insert(second.value);
            second = second.next;
        }

        return ans.head;
    }

    public static Node findMiddleNode(Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // when the fast reaches the end the slow will be half of the value of the fast
        // which is the middle node of the list
        return slow;
    }

    // display the linked list
    public static void display(Node head) {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        // get the first node
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value);
            if (temp.next != null) {
                System.out.print("->");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}

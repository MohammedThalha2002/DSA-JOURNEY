package DataStructures.LinkedList.Problems;

import DataStructures.LinkedList.Problems.LL.Node;

public class BubbleSort {
    public static void main(String[] args) {
        LL list = new LL();

        list.insert(2);
        list.insert(5);
        list.insert(1);
        list.insert(4);
        list.insert(3);
        list.insert(-1);
        list.display();

        bubbleSort(list);
        bubbleSortRec(list, list.size() - 1, 0);
        System.out.println("The sorted list is ");
        System.out.println("---------------------------------");
        list.display();
        System.out.println("---------------------------------");
    }

    public static void bubbleSort(LL list) {
        Node outer = list.head;
        while (outer.next != null) {
            Node inner = list.head;
            while (inner.next != null) {
                if (inner.value > inner.next.value) {
                    // swap
                    int temp = inner.value;
                    inner.value = inner.next.value;
                    inner.next.value = temp;
                }
                inner = inner.next;
            }
            outer = outer.next;
        }
    }

    // using recursion
    public static void bubbleSortRec(LL list, int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            Node first = list.get(col);
            Node sec = list.get(col + 1);

            // swapping
            if (first.value > sec.value) {
                if (first == list.head) {
                    first.next = sec.next;
                    sec.next = first;
                    list.head = sec;
                } else {
                    Node prev = list.get(col - 1);
                    prev.next = first.next;
                    first.next = sec.next;
                    sec.next = first;
                }
            }
            bubbleSortRec(list, row, col + 1);
        }
        bubbleSortRec(list, row - 1, 0);
    }
}

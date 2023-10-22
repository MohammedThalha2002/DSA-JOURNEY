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
}

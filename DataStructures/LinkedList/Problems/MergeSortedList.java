package DataStructures.LinkedList.Problems;

import DataStructures.LinkedList.Problems.LL.Node;

public class MergeSortedList {
    public static void main(String[] args) {
        LL list1 = new LL();
        LL list2 = new LL();
        LL ans = new LL();

        list1.insert(1);
        list1.insert(2);
        list1.insert(4);
        list1.display();

        list2.insert(1);
        list2.insert(3);
        list2.insert(4);
        list2.display();

        mergeSortedList(list1.head, list2.head, ans);
        ans.display();
    }

    private static void mergeSortedList(Node first, Node second, LL ans) {
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
    }
}

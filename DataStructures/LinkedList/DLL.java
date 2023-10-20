package DataStructures.LinkedList;

public class DLL {
    private Node head;
    private Node tail;
    private int size;

    public DLL() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int val) {
            this.value = val;
        }
    }

    // insert a node
    public void insert(int val) {
        // 1) creating a nw node
        Node newNode = new Node(val);

        // 2) checking for inserting a node at very first time
        if (head == null && tail == null || size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            // 3) if already an existing DL is present
            // --- inserting at the last
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    // insert node at first
    public void insertFirst(int val) {
        Node node = new Node(val);
        // if insertFirst was called before the insert function
        if (head == null && tail == null || size == 0) {
            head = node;
            tail = node;
        } else {
            // if already an existing LL is present - insert at first
            node.next = head;
            head = node;
        }

        size++;
    }

    // display the linked list
    public void display() {
        System.out.println();
        if (size == 0) {
            System.out.println("LinkedList is Empty");
        }
        // get the first node
        // front to back traversal
        Node start = head;
        while (start != null) {
            System.out.print(start.value);
            if (start.next != null) {
                System.out.print("->");
            }
            start = start.next;
        }
        System.out.println();

        // get the last node
        // front to back traversal
        Node last = tail;
        while (last != null) {
            System.out.print(last.value);
            if (last.prev != null) {
                System.out.print("->");
            }
            last = last.prev;
        }
        System.out.println();
    }
}

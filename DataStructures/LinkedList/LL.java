package DataStructures.LinkedList;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        size = 0;
    }

    private class Node {
        private int value;
        private Node next;

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
            // 3) if already an existing LL is present
            // --- inserting at the last
            Node lastNode = tail;
            lastNode.next = newNode;
            tail = newNode;
        }

        size++;
    }

    // insert at first
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

    public void insert(int val, int index) {
        Node node = new Node(val);
        if ((index < 0 || index > size)) {
            System.out.println("Cannot be inserted at the given index " + index);
            return;
        }
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insert(val);
            return;
        }
        Node temp = head;
        // traversing to the before node
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    // get the element at specific index
    public int get(int index) {
        if (index >= size || index < 0) {
            System.out.println("Not found");
            return -1;
        }
        // get the first node
        Node temp = head;
        System.out.println();

        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }

        return temp.value;
    }

    // update an element at the specific index
    public void update(int val, int index) {
        if (size == 0) {
            System.out.println("Element not found");
        }

        Node temp = head;

        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }
        temp.value = val;
    }

    // display the linked list
    public void display() {
        System.out.println();
        if (size == 0) {
            System.out.println("LinkedList is Empty");
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

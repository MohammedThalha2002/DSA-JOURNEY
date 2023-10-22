package DataStructures.LinkedList.Thoery;

public class CircularLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public CircularLinkedList() {
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
            tail.next = newNode;
            tail = newNode;
            newNode.next = head;
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
            tail.next = head;
        }

        size++;
    }

    // insert at specific index
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

    // get the node value at specific index
    public Node get(int index) {
        if (index >= size || index < 0) {
            System.out.println("Not found");
            return null;
        }
        // get the first node
        Node temp = head;
        System.out.println();

        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    // update node value at the specific index
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

    // deleting a node
    public void delete() {
        if (size == 0) {
            System.out.println("No item is present");
            return;
        }

        Node temp = head;
        for (int i = 1; i < size - 1; i++) {
            temp = temp.next;
        }
        // found the last before element
        temp.next = head;
        tail = temp;
        size--;
    }

    // deleting a node at specific index
    public void delete(int index) {
        // deleting the starting node
        if (index == 0) {
            head = head.next;
            // if we have only one node in LL
            if (head == null) {
                tail = null;
            }
            size--;
            return;
        }
        // deleting the last node
        if (index == size - 1) {
            delete();
            return;
        }
        // deleting at other index
        Node temp = get(index - 1);
        Node delNode = temp.next;
        temp.next = delNode.next;
        delNode.next = null;
        size--;
    }

    // find a node present
    public int find(int val) {
        if (size == 0) {
            return -1;
        }

        Node temp = head;
        for (int i = 1; i < size + 1; i++) {
            if (temp.value == val) {
                return i - 1;
            }
            temp = temp.next;
        }

        return -1;
    }

    // display the linked list
    public void display() {
        System.out.println();
        if (size == 0) {
            System.out.println("LinkedList is Empty");
        }
        // get the first node
        Node temp = head;
        do {
            System.out.print(temp.value + "->");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}

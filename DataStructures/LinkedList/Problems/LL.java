package DataStructures.LinkedList.Problems;

public class LL {
    public Node head;

    public LL() {
    }

    public class Node {
        public int value;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.value = val;
        }
    }

    // insert a node
    public void insert(int val) {
        // 1) creating a nw node
        Node newNode = new Node(val);

        // 2) checking for inserting a node at very first time
        if (head == null) {
            head = newNode;
        } else {
            // 3) if already an existing LL is present
            // --- inserting at the last
            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            // now currNode = tail node
            currNode.next = newNode;
        }
    }

    // get the node value at specific index
    public Node get(int index) {
        if (index < 0) {
            System.out.println("Not found");
            return null;
        }
        // get the first node
        Node temp = head;
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    // display the linked list
    public void display() {
        System.out.println();
        if (head == null) {
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

    // display the linked list
    public void display(Node head) {
        System.out.println();
        if (head == null) {
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

    // size of the linked list
    public int size() {
        int size = 0;
        if (head == null) {
            return size;
        }
        // get the first node
        Node temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }
}

package Linked_List_Stuff;

public class SLL {
    private Node head;
    private Node tail, sorted;
    private int size;

    public SLL() {
        this.size = 0;
    }

    private class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    //    INSERTING FIRST NODE
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    //    INSERT
    public void insert(int val) {
        Node thenode = new Node(val);
        thenode.val = val;
        thenode.next = null;
        if (head == null) {
            head = thenode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
                temp.next = thenode;
            }
        }
    }

    //    DETECT LOOP
    public boolean detectloop(Node head) {
        Node fastptr = head, slowptr = head;

        while (fastptr != null && fastptr.next != null) {
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
            if (slowptr == fastptr) {
                return true;
            }
        }
        return false;
    }

    //    CREATE A LOOP IN SLL
    public void createloop() {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = third;
    }

    //    INSERTING LAST NODE
    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    //      INSERTING NODE AT A DESIRED POSITION
    public void insert_Position(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) { //because the head is at zero that's why starting from 1
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    //      DELETING THE FIRST NODE
    public int deleteFirst() {
        int val = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    //    DELETING THE LAST NODE
    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        Node secondLastnode = getnode(size - 2);
        int val = tail.val;
        tail = secondLastnode;
        tail.next = null;
        size--;
        return val;
    }

    //    DELETING NODE AT A DESIRED POSITION
    public int deletePosition(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node prev = getnode(index - 1);
        int val = prev.next.val;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    //    GETTING THE NODE
    public Node getnode(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    //      DISPLAY FUNCTION
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("END");
//        System.out.println(size);
    }

    //    ALL OCCURENCE DELETE
    public static Node AllOccurenceDelete(Node head, int key) {
        Node prev = null, temp = head;
        while (temp != null) {
//            If we found the key update to previous node
            if (temp.val == key) {
                prev = temp;
            }
            temp = temp.next;
        }
//        Kye occurs atleast once
        if (prev != null) {
//            Copy key of next node to prev
            prev.val = prev.next.val;
//            store and unlink next
            temp = prev.next;
            prev.next = prev.next.next;
        }
        return head;
    }

    //    SORTED LL MERGE
    public static Node SortedMerge(Node A, Node B) {
        if (A == null) return B;
        if (B == null) return A;

        if (A.val < B.val) {
            A.next = SortedMerge(A.next, B);
            return A;
        } else {
            B.next = SortedMerge(A, B.next);
            return B;
        }
    }

    //    GETTING THE MIDDLE NODE
    public Node getMiddleNode() {
        if (head == null) {
            return null;
        }
        Node slowptr = head, fastptr = head;
        while (fastptr != null && fastptr.next != null) {
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
        }
        return slowptr;
    }

    //    REMOVE DUPLICATES FROM SORTED LIST
    public Node deleteDuplicates(Node head) {
        Node temp = head;
        if (head == null || head.next == null)
            return head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    // function to sort a singly linked list using insertion sort
    void insertionSort(Node headref) {
        // Initialize sorted linked list
        sorted = null;
        Node current = headref;
        // Traverse the given linked list and insert every node to sorted
        while (current != null) {
            // Store next for next iteration
            Node next = current.next;
            // insert current in sorted linked list
            sortedInsert(current);
            // Update current
            current = next;
        }
        // Update head_ref to point to sorted linked list
        head = sorted;
    }

    /*
     * function to insert a new_node in a list. Note that this function expects a pointer to head_ref as this
     * can modify the head of the input linked list (similar to push())*/
    void sortedInsert(Node newnode) {
        /* Special case for the head end */
        if (sorted == null || sorted.val >= newnode.val) {
            newnode.next = sorted;
            sorted = newnode;
        } else {
            Node current = sorted;
            /* Locate the node before the point of insertion */
            while (current.next != null && current.next.val < newnode.val) {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
    }
}
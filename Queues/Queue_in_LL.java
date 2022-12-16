package Queues;

public class Queue_in_LL {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node front, rear;
    int length;

    public Queue_in_LL() {
        this.front = front;
        this.rear = rear;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void enqueue(int data) {
        Node temp = new Node(data);
        // If queue is empty, then new node is front and rear both
        if (rear == null) {
            front = rear = temp;
            return;
        }
        // Add the new node at the end of queue and change rear
        rear.next = temp;
        rear = temp;
        length++;
    }

    // Store previous front and move front one node ahead
    public void dequeue() {
        if (front == null) {
            return;
        }
        Node temp = front;
        front = front.next;
        // If front becomes NULL, then change rear also as NULL
        if (front == null) {
            rear = null;
        }
    }

    public void Print() {
        if (isEmpty()) {
            return;
        }
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue_in_LL q = new Queue_in_LL();
        for (int i = 0; i < 3; i++) {
            q.enqueue(i);
        }
        q.Print();
        q.dequeue();
        q.Print();
    }
}
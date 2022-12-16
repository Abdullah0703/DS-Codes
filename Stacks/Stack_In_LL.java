package Stacks;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class Stack_In_LL {
    private Node top;
    private int length;

    public Stack_In_LL() {
        top = null;
        length = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        Node temp = new Node(data);
        if (temp == null) {
            System.out.println("Heap overflow");
        }
        temp.next = top;
        top = temp;
    }

    public int pop() {
        if (!isEmpty()) {
            int a = top.data;
            top = top.next;
            return a;
        } else {
            System.out.println("Stack is Empty");
            return -1;
        }
    }


    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        } else {
            Node temp = top;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
        }
    }

    public void Interval(Stack_In_LL s1) {
        Stack_In_LL s2 = new Stack_In_LL();
        Stack_In_LL s3 = new Stack_In_LL();
        Stack_In_LL s4 = new Stack_In_LL();

        int n = s1.TotalElements(s1);
        int count = 0;
        boolean flag = true;
        while (count != n - 2) {
            int a = s1.pop();
            while (!s1.isEmpty()) {
                int b = s1.pop();
                if ((a % 10) == (b % 10) || (a / 10) == (b / 10)) {
                    s3.push(b);
                    flag = false;
                } else {
                    s2.push(b);
                }
            }
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            if (flag == true) {
                s4.push(a);
            } else {
                s3.push(a);
                flag = true;
            }
            count++;
        }
        System.out.println("\nCompatible Timings:");
        s4.display();
        System.out.println("\n\nCollapsing Timings");
        s3.display();
    }

    private int TotalElements(Stack_In_LL s1) {

        int count = 0;
        Stack_In_LL temp = new Stack_In_LL();
        while (!s1.isEmpty()) {
            temp.push(s1.pop());
            count++;
        }
        while (!temp.isEmpty()) {
            s1.push(temp.pop());
        }
        return count;
    }

    public static void main(String[] args) {
        Stack_In_LL sll = new Stack_In_LL();
        sll.push(1);
        sll.push(2);
        sll.push(3);
        sll.display();
        System.out.println();
        System.out.println("Top element is: " + sll.peek());
        sll.Interval(sll);
    }
}

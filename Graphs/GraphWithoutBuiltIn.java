package Graphs;

import java.util.EmptyStackException;

class Queue {
    private int front;
    private int rear;
    private int size;
    private int[] arr;

    public Queue(int size) {
        this.size = size;
        this.arr = new int[size];
        this.rear = 0;
        this.front = 0;
    }

    public boolean isEmpty() {
        if (front == rear)
            return true;
        return false;
    }

    public boolean isFull() {
        if (rear == size)
            return true;
        return false;
    }

    public void enqueue(int data) {
        if (rear == size) {
            System.out.println("queue is full");
        }
        arr[rear] = data;
        rear++;
    }

    public int dequeue() {
        if (rear == front) {
            System.out.println("queue is empty");
        }
        int ans = arr[0];
        for (int i = 0; i < rear - 1; i++) {
            arr[i] = arr[i + 1];
        }
        if (rear < size)
            arr[rear] = 0;
        rear--;

        return ans;
    }

    public void display() {
        for (int i = front; i < rear; i++) {
            System.out.printf(" %d <-- ", arr[i]);
        }
    }
}

class Stack {
    private int top;
    private int size;
    private int[] arr;

    public Stack(int size) {
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }

    public boolean isFull() {
        if (top == size) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    public void push(int data) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        arr[++top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top--];
    }
}

public class GraphWithoutBuiltIn {
    private int Vertices;
    Stack s1;
    Queue q1;
    private int[][] arr;

    public GraphWithoutBuiltIn(int v) {
        s1 = new Stack(v);
        q1 = new Queue(v);
        this.Vertices = v;
        this.arr = new int[v][v];
    }

    public void init() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 0;
            }
        }
    }

    public void addEdge(int u, int v) {
        u--;
        v--;
        arr[u][v] = 1;
        arr[v][u] = 1;
    }

    public void print() {
        System.out.println("   1 2 3 4 5");
        for (int i = 0; i < arr.length; i++) {
            int v = i + 1;
            System.out.print(v + ": ");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void dfs(int v) {
        boolean visited[] = new boolean[Vertices];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        s1.push(v);
        while (!s1.isEmpty()) {
            int u = s1.pop();
            if (visited[u] == false) {
                System.out.print(u + 1 + " ");
                visited[u] = true;
            }
            for (int i = 0; i < Vertices; i++) {
                if (arr[u][i] == 1 && visited[i] == false) {
                    s1.push(i);
                }
            }
        }
    }

    public void bfs(int v) {
        boolean visited1[] = new boolean[Vertices];
        for (int i = 0; i < visited1.length; i++) {
            visited1[i] = false;
        }
        q1.enqueue(v);
        while (!q1.isEmpty()) {
            int u = q1.dequeue();
            if (visited1[u] == false) {
                System.out.print(u + 1 + " ");
                visited1[u] = true;
            }
            for (int i = 0; i < Vertices; i++) {
                if (arr[u][i] == 1 && visited1[i] == false) {
                    q1.enqueue(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphWithoutBuiltIn obj = new GraphWithoutBuiltIn(5);
        obj.init();
        obj.addEdge(1, 4);
        obj.addEdge(2, 4);
        obj.addEdge(2, 5);
        obj.addEdge(3, 5);
        obj.addEdge(4, 5);
        obj.print();
        System.out.println("The DFS of the Graph is:");
        obj.dfs(0);
        System.out.println("\nThe BFS of the Graph is:");
        obj.bfs(0);
    }
}
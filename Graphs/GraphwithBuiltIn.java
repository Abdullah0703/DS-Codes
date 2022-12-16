package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphwithBuiltIn {
    int vertices, edges;
    LinkedList<Integer> adjlist[];
    int[][] arr;

    public GraphwithBuiltIn(int noOfNodes) {
        this.vertices = noOfNodes;
        this.edges = 0;
        adjlist = new LinkedList[noOfNodes];
        this.arr = new int[noOfNodes][noOfNodes];
        for (int i = 0; i < noOfNodes; i++) {
            adjlist[i] = new LinkedList<>();
        }
    }

    public void addNode(int n1, int n2) {
        adjlist[n1].add(n2);
        adjlist[n2].add(n1);
    }


    public String toString() {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < vertices; i++) {
            s1.append(i + 1 + ": ");
            for (int j : adjlist[i]) {
                s1.append(j + 1 + "->");
            }
            s1.append("\n");
        }
        return s1.toString();
    }

    public void addEdge(int i, int j) {
        arr[i][j] = 1;
        arr[j][i] = 1;
        edges++;
    }

    public void print() {
        System.out.println("    1" + " " + "2" + " " + "3" + " " + "4" + " " + "5");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + 1 + " : ");
            for (int j = 0; j < vertices; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void BFS(int src) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> q = new LinkedList<>();
        visited[src] = true;
        q.offer(src);
        while (!q.isEmpty()) {
            int visit = q.poll();
            System.out.print(visit + " ");
            for (int i : adjlist[visit]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    public void DFS(int src) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> s = new Stack<>();
        s.push(src);
        while (!s.isEmpty()) {
            int visitnode = s.pop();
            if (!visited[visitnode]) {
                visited[visitnode] = true;
                System.out.print(visitnode + " ");
                for (int i : adjlist[visitnode]) {
                    if (!visited[i]) {
                        s.push(i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphwithBuiltIn g = new GraphwithBuiltIn(5);
        System.out.println("In Adjacency Matrix");
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addNode(0, 3);
        g.addNode(1, 3);
        g.addNode(1, 4);
        g.addNode(2, 4);
        g.addNode(3, 4);
        g.print();
        System.out.println("\n");
        System.out.println("In Adjacency List");
        System.out.println(g);
        System.out.println("Depth first Search");
        g.DFS(0);
        System.out.println("\nBreadth First Search");
        g.BFS(0);
    }
}

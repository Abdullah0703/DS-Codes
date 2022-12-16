package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class GraphNodeAdjMatrix {
    char data;

    public GraphNodeAdjMatrix(char data) {
        this.data = data;
    }
}

public class Graph_Adj_Matrix {
    int[][] Adjmatrix;
    ArrayList<GraphNodeAdjMatrix> nodes;

    public Graph_Adj_Matrix(int noOfNodes) {
        nodes = new ArrayList<>();
        Adjmatrix = new int[noOfNodes][noOfNodes];
    }

    public void addNode(GraphNodeAdjMatrix Node) {
        nodes.add(Node);
    }

    public void addEdge(int src, int dst) { //src=source(row), dst=destination(column)
        Adjmatrix[src][dst] = 1;
    }

    public boolean checkEdge(int src, int dst) {
        if (Adjmatrix[src][dst] == 1) {
            return true; //there exists an edge
        }
        return false;
    }

    public void Print() {
        System.out.print("   ");
        for (GraphNodeAdjMatrix node : nodes) {
            System.out.print(node.data + "  ");
        }
        System.out.println();

        for (int row = 0; row < Adjmatrix.length; row++) {
            System.out.print(nodes.get(row).data + ": ");
            for (int col = 0; col < Adjmatrix[row].length; col++) {
                System.out.print(Adjmatrix[row][col] + "  ");
            }
            System.out.println();
        }
    }

    public void BreadthFirstSearch(int src) {
        Queue<Integer> q = new LinkedList<>();
        //Queue is actually an interface, so we use a DataStructure that utilizes the Queue interface one of which is LL
        boolean[] visited = new boolean[Adjmatrix.length];
        q.offer(src);
        //adding the source node in Queue u can use offer() also same but add is used for restricted queue size.
        visited[src] = true;
        while (q.size() != 0) {
            src = q.poll();
//       u can also use poll() is same as peek but throws an exception if queue is empty while peek return null if empty
            System.out.println(nodes.get(src).data + " = visited");

            for (int i = 0; i < Adjmatrix[src].length; i++) {
                if (Adjmatrix[src][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public void DepthFirstSearch(int src) {
        boolean[] visited = new boolean[Adjmatrix.length];
        DFSHelper(src, visited);
    }

    private void DFSHelper(int src, boolean[] visited) {
        if (visited[src]) {
            return;
        } else {
            visited[src] = true;
            System.out.println(nodes.get(src).data + " = visited");
        }

        for (int i = 0; i < Adjmatrix[src].length; i++) {
            //Adjmatrix[src].length = row
            if (Adjmatrix[src][i] == 1) {
//                Adjmatrix[src] is the row and i is the column we are working with
                DFSHelper(i, visited);
            }
        }
        return;
    }

    public static void main(String[] args) {
        Graph_Adj_Matrix g = new Graph_Adj_Matrix(5);
        g.addNode(new GraphNodeAdjMatrix('A')); //index:0
        g.addNode(new GraphNodeAdjMatrix('B')); //index:1
        g.addNode(new GraphNodeAdjMatrix('C')); //index:2
        g.addNode(new GraphNodeAdjMatrix('D')); //index:3
        g.addNode(new GraphNodeAdjMatrix('E')); //index:4

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 0);
        g.addEdge(4, 2);
        g.Print();

        System.out.println("Checking Edge b/w D and C: " + g.checkEdge(3, 2));
        System.out.println("Checking Edge b/w A and B: " + g.checkEdge(0, 1));
        System.out.println("DFS starting from (B) Node");
        g.DepthFirstSearch(1);
        System.out.println("BFS staring from (A) Node");
        g.BreadthFirstSearch(0);

    }
}


package Graphs;

import java.util.*;

public class PrimsAndKruskalsAlgorithm {
    int vertices;
    ArrayList<Edge> allEdges = new ArrayList<>();

    public PrimsAndKruskalsAlgorithm(int vertices) {
        this.vertices = vertices;
    }

    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public void add(int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        allEdges.add(edge);
    }

    public void kruskalAlgorithm() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(o -> o.weight));
        for (int i = 0; i < allEdges.size(); i++) {
            pq.add(allEdges.get(i));
        }
        int[] parent = new int[vertices];
        makeSet(parent);
        ArrayList<Edge> mst = new ArrayList<>();
        int index = 0;
        while (index < vertices - 1) {
            Edge edge = pq.remove();
            int x_set = find(parent, edge.source);
            int y_set = find(parent, edge.destination);
            if (x_set == y_set) {
            } else {
                mst.add(edge);
                index++;
                union(parent, x_set, y_set);
            }
        }
        System.out.println("Minimum Spanning Tree: ");
        printGraph(mst);
    }

    public void makeSet(int[] parent) {
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }
    }

    public int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex)
            return find(parent, parent[vertex]);
        ;
        return vertex;
    }

    public void union(int[] parent, int x, int y) {
        int x_set_parent = find(parent, x);
        int y_set_parent = find(parent, y);
        parent[y_set_parent] = x_set_parent;
    }

    public void printGraph(ArrayList<Edge> edgeList) {
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            System.out.println(" source: " + edge.source + " destination: " + edge.destination + " weight: " + edge.weight);
        }
    }

    public void PrimAlgorithm(int[][] graph, int vertices) {
        int INF = Integer.MAX_VALUE, sum = 0;
        int no_edges; // number of edge

        // create an array to track selected vertex selected will become true otherwise false
        boolean[] selected = new boolean[vertices];

        // set selected false initially
        Arrays.fill(selected, false);

        // set number of edge to 0
        no_edges = 0;

        // the number of edge in minimum spanning tree will be
        // always less than (V -1), where V is number of vertices in graph

        // choose 0th vertex and make it true
        selected[0] = true;
        // print for edge and weight
        System.out.println("Edge : Weight");
        while (no_edges < vertices - 1) {
            /* For every vertex in the set S, find the all adjacent vertices
             calculate the distance from the vertex selected at step 1
             if the vertex is already in the set S, discard it otherwise
            choose another vertex nearest to selected vertex at step 1.*/

            int min = INF;
            int row = 0; // row number
            int col = 0; // col number
            for (int i = 0; i < vertices; i++) {
                if (selected[i] == true) {
                    for (int j = 0; j < vertices; j++) {
                        // not in selected[] and there is an edge
                        if (!selected[j] && graph[i][j] != 0) {
                            if (min > graph[i][j]) {
                                min = graph[i][j];
                                row = i;
                                col = j;
                            }
                        }
                    }
                }
            }
            sum = sum + graph[row][col];
            System.out.println(row + " - " + col + " :  " + graph[row][col]);
            selected[col] = true;
            no_edges++;
        }
        System.out.println("The sum is: " + sum);
    }


    public static void main(String[] args) {
        PrimsAndKruskalsAlgorithm p = new PrimsAndKruskalsAlgorithm(6);
        int vertices = 6;
        int[][] graphmatrix = {
                {0, 6, 7, 0, 2, 3},
                {6, 0, 5, 0, 0, 0},
                {7, 5, 0, 0, 5, 0},
                {0, 0, 0, 0, 4, 1},
                {2, 0, 5, 4, 0, 2},
                {3, 0, 0, 1, 2, 0}};
        System.out.println("Prims output \n");
        p.PrimAlgorithm(graphmatrix, vertices);
        p.add(0, 1, 6);
        p.add(0, 2, 7);
        p.add(0, 4, 2);
        p.add(0, 5, 3);
        p.add(1, 0, 6);
        p.add(1, 2, 5);
        p.add(2, 0, 7);
        p.add(2, 1, 5);
        p.add(2, 4, 5);
        p.add(3, 4, 4);
        p.add(3, 5, 1);
        p.add(4, 0, 2);
        p.add(4, 2, 5);
        p.add(4, 3, 4);
        p.add(4, 5, 2);
        p.add(5, 0, 3);
        p.add(5, 3, 1);
        p.add(5, 4, 2);
        System.out.println("\nKruskal output \n");
        p.kruskalAlgorithm();
    }
}


package Graphs;

public class Dijkstras_Algorithm {
    int V;

    public Dijkstras_Algorithm(int v) {
        V = v;
    }

    // Function that implements Dijkstra's single source
    // the shortest path algorithm for a graph represented using adjacency matrix representation
    public void dijkstraAlgo(int[][] graph, int src) {
        //visited[i] will true if vertex i is included in
        // the shortest path tree or shortest distance from src
        // to i is finalized
        boolean[] visited = new boolean[V];
        // The output array. dist[i] will hold the shortest distance from src to i
        int[] distance = new int[V];
        // Initialize all distances as INFINITE and visited[] as false
        for (int i = 0; i < V; i++) {
            visited[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        // Distance of source vertex from itself is always 0
        distance[src] = 0;
        // Find the shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices not yet processed. u is always
            // equal to src in first iteration.
            int u = minDistance(distance, visited);
            // Mark the picked vertex as processed
            visited[u] = true;
            // Update dist value of the adjacent vertices of the picked vertex.
            for (int v = 0; v < V; v++) {
                // Update dist[v] only if is not in visited[] there is an edge from u to v, and total
                // weight of path from src to v through u is smaller than current value of dist[v]
                if (!visited[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE
                        && distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
        Print(distance);
    }

    private void Print(int[] distance) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < distance.length; i++) {
            System.out.println(i + " \t\t " + distance[i]);
        }
    }

    // A utility function to find the vertex with minimum
    // distance value, from the set of vertices not yet included in the shortest path tree
    private int minDistance(int[] distance, boolean[] visited) {
        // Initialize min value
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int v = 0; v < V; v++) {
            if (visited[v] == false && distance[v] <= min) {
                min = distance[v];
                min_index = v;
            }
        }
        return min_index;
    }

    public static void main(String[] args) {
        Dijkstras_Algorithm da = new Dijkstras_Algorithm(5);
        int graph[][] = new int[][]{
                {0, 4, 0, 8, 0, 0},
                {4, 0, 9, 0, 0, 0},
                {0, 9, 0, 6, 14, 0},
                {8, 0, 6, 0, 0, 4},
                {0, 0, 0, 4, 3, 0}};
        System.out.println("The shortest path using Dijkstra's algorithm is:");
        da.dijkstraAlgo(graph, 1);
    }
}

package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

class GraphNodeAdjList {
    char data;

    public GraphNodeAdjList(char data) {
        this.data = data;
    }
}

public class Graph_Adj_LinkedList {
    ArrayList<LinkedList<GraphNodeAdjList>> AdjList;

    public Graph_Adj_LinkedList() {
        AdjList = new ArrayList<>();
    }

    public void addNode(GraphNodeAdjList Node) {
        LinkedList<GraphNodeAdjList> currentList = new LinkedList<>();
        currentList.add(Node);
        AdjList.add(currentList);
    }

    public void addEdge(int src, int dst) {
        LinkedList<GraphNodeAdjList> currentList = AdjList.get(src);
        GraphNodeAdjList dstNode = AdjList.get(dst).get(0); // this is the address of the LL we would like to link to.
        //Adding dstNode to the tail of the currentList
        currentList.add(dstNode);
    }

    public boolean checkEdge(int src, int dst) {
        LinkedList<GraphNodeAdjList> currentList = AdjList.get(src);
        GraphNodeAdjList dstNode = AdjList.get(dst).get(0);
        for (GraphNodeAdjList Node : currentList) {
            if (Node == dstNode) {
                return true;
            }
        }
        return false;
    }

    public void Print() {
        for (LinkedList<GraphNodeAdjList> currentList : AdjList) {
            for (GraphNodeAdjList Node : currentList) {
                System.out.print(Node.data + "->");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph_Adj_LinkedList g = new Graph_Adj_LinkedList();
        g.addNode(new GraphNodeAdjList('A')); //index:0
        g.addNode(new GraphNodeAdjList('B')); //index:1
        g.addNode(new GraphNodeAdjList('C')); //index:2
        g.addNode(new GraphNodeAdjList('D')); //index:3
        g.addNode(new GraphNodeAdjList('E')); //index:4

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 0);
        g.addEdge(4, 2);
        g.Print();

    }
}

package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private final int id;
    private final List<Edge> adjacencyList = new ArrayList<>();

    public Vertex(int id) {
        this.id = id;
    } // end of constructor

    public void addEdge(Edge edge) {
        if (!adjacencyList.contains(edge)) {
            System.out.println("Added " + edge + " to the adjacency list");
            adjacencyList.add(edge);
        } else {
            System.out.println("This edge is already in the adjacency list for " + edge.getStart().getId());
        }
    } // end of addEdge

    public int getId() {
        return id;
    } // end of getId

    public List<Edge> getAdjacencyList() {
        return adjacencyList;
    } // end of getAdjacencyList

    @Override
    public String toString() {
        return  id + "";
    } // end of toString

    @Override
    public boolean equals(Object object) {
        if (object instanceof Vertex otherVertex) {
            return otherVertex.getId() == id;
        }
        return false;
    } // end of equals

    //----------------------------------------------< For Testing >-----------------------------------------------------
    public void printEdges() {
        System.out.print("LIST for (" + id + "): ");
        for (Edge edge : adjacencyList) {
            System.out.print(edge.getEnd() + " ");
        }
    }

    public void displayEdges() {
        System.out.println("\nList of all edges that node " + id + " has:");
        System.out.println("===========================================");
        for (Edge edge : adjacencyList) {
            System.out.println("ID of Edge: " + edge.getId() +
                    "\nID of the first node: " + edge.getStart().getId() +
                    "\nID of the second node: " + edge.getEnd().getId());
        }
        System.out.println(adjacencyList);
    } // end of displayEdges
} // end of Vertex class

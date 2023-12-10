package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a vertex in a graph with a unique identifier and an adjacency list containing edges connected
 * to this vertex.
 */
public class Vertex {
    private final int id;
    private final List<Edge> adjacencyList = new ArrayList<>();

    /**
     * Constructs a new instance of Vertex with the specified identifier.
     *
     * @param id The unique identifier of the vertex.
     */
    public Vertex(int id) {
        this.id = id;
    } // end of constructor

    /**
     * Adds an edge to the adjacency list of this vertex, preventing duplicate entries.
     *
     * @param edge The edge to be added to the adjacency list.
     */
    public void addEdge(Edge edge) {
        if (!adjacencyList.contains(edge)) {
            System.out.println("Added " + edge + " to the adjacency list");
            adjacencyList.add(edge);
        } else {
            System.out.println("This edge is already in the adjacency list for " + edge.getStart().getId());
        }
    } // end of addEdge

    /**
     * Gets the unique identifier of the vertex.
     *
     * @return The identifier of the vertex.
     */
    public int getId() {
        return id;
    } // end of getId

    /**
     * Gets the adjacency list of edges connected to this vertex.
     *
     * @return The adjacency list of edges.
     */
    public List<Edge> getAdjacencyList() {
        return adjacencyList;
    } // end of getAdjacencyList

    /**
     * Returns a string representation of the vertex using its unique identifier.
     *
     * @return The string representation of the vertex.
     */
    @Override
    public String toString() {
        return  id + "";
    } // end of toString

    /**
     * Checks if this vertex is equal to another object by comparing their unique identifiers.
     *
     * @param object The object to compare with this vertex.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Vertex otherVertex) {
            return otherVertex.getId() == id;
        }
        return false;
    } // end of equals
} // end of Vertex class

package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a graph with vertices.
 */
public class Graph {
    private final List<Vertex> vertexList;
    private int numberOfVertices = 0;

    /**
     * Constructs an empty graph.
     */
    public Graph() {
        vertexList = new ArrayList<>();
    } // end of constructor

    /**
     * Adds a vertex to the graph if it does not already exist.
     *
     * @param vertex The vertex to be added to the graph.
     */
    public void addVertex(Vertex vertex) {
        if (!vertexList.contains(vertex)) {
            vertexList.add(vertex);
            numberOfVertices++;
        }
    } // end of addVertex

    /**
     * Gets the number of vertices in the graph.
     *
     * @return The number of vertices in the graph.
     */
    public int getNumberOfVertices() {
        return numberOfVertices;
    } // end of getNumberOfVertices

    /**
     * Gets the list of vertices in the graph.
     *
     * @return The list of vertices in the graph.
     */
    public List<Vertex> getVertexList() {
        return vertexList;
    } // end of getVertexList
} // end of Graph class

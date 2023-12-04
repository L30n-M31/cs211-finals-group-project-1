package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final List<Vertex> vertexList;
    private int numberOfVertices = 0;

    public Graph() {
        vertexList = new ArrayList<>();
    } // end of constructor

    public void addVertex(Vertex vertex) {
        if (!vertexList.contains(vertex)) {
            vertexList.add(vertex);
            numberOfVertices++;
        }
    } // end of addVertex

    public int getNumberOfVertices() {
        return numberOfVertices;
    } // end of getNumberOfVertices

    public List<Vertex> getVertexList() {
        return vertexList;
    } // end of getVertexList
} // end of Graph class

package graph;

import reader.DataFileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles the creation of a graph from data read from a file.
 */
public class GraphCreation {
    private final Graph graph;
    private final DataFileReader reader;
    private final List<Vertex> vertexList;

    /**
     * Constructs a new instance of GraphCreation with an empty graph,
     * a data file reader, and an empty vertex list.
     */
    public GraphCreation() {
        graph = new Graph();
        reader = new DataFileReader();
        vertexList = new ArrayList<>();
    } // end of constructor

    /**
     * Creates a graph by reading data from the specified file and populates the graph
     * with vertices and edges.
     *
     * @param filename The name of the file containing the graph data.
     */
    public void createGraph(String filename) {
        List<String> data = reader.readFile(filename);

        for (String line : data) {
            String[] values = line.split(",");

            int startId = Integer.parseInt(values[0]);
            int endId = Integer.parseInt(values[1]);
            double weight = Double.parseDouble(values[2]);
            int id = Integer.parseInt(values[3]);

            Vertex start = createVertex(startId);
            Vertex end = createVertex(endId);

            Edge edge = new Edge(start, end, weight, id);
            start.addEdge(edge);

            // makes the edge two-directional
            if (start.getId() != end.getId()) {
                Edge invertedEdge = new Edge(end, start, weight, id);
                end.addEdge(invertedEdge);
            }
        }
    } // end of createGraph

    /**
     * Creates a vertex with the specified identifier or retrieves an existing
     * vertex from the vertex list.
     *
     * @param id The identifier of the vertex to be created or retrieved.
     * @return The created or retrieved vertex.
     */
    public Vertex createVertex(int id) {
        return vertexList.stream()
                .filter(vertex -> vertex.getId() == id)
                .findFirst()
                .orElseGet(() -> {
                    Vertex newVertex = new Vertex(id);
                    vertexList.add(newVertex);
                    graph.addVertex(newVertex);
                    return newVertex;
                });
    } // end of createVertex;

    /**
     * Gets the graph created and populated.
     *
     * @return The created graph.
     */
    public Graph getGraph() {
        return graph;
    } // end of getGraph
} // end of GraphCreation class

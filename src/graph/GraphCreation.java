package graph;

import reader.DataFileReader;
import java.util.ArrayList;
import java.util.List;

public class GraphCreation {
    private final Graph graph;
    private final DataFileReader reader;
    private final List<Vertex> vertexList;

    public GraphCreation() {
        graph = new Graph();
        reader = new DataFileReader();
        vertexList = new ArrayList<>();
    } // end of constructor

    public void createGraph(String filename) {
        List<String> data = reader.readFile(filename);

        for (String line : data) {
            String[] values = line.split(" ");

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

    public Graph getGraph() {
        return graph;
    } // end of getGraph
} // end of GraphCreation class

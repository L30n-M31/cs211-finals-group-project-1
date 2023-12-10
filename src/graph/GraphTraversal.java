package graph;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Handles various graph traversal operations such as Breadth-First Search (BFS),
 * Depth-First Search (DFS), and finding the shortest path between two vertices.
 */
public class GraphTraversal {
    private final List<Vertex> vertexList;
    private StringBuilder shortestPathVertices;

    /**
     * Constructs a new instance of GraphTraversal with the specified graph.
     *
     * @param graph The graph to perform traversal operations on.
     */
    public GraphTraversal(Graph graph) {
        vertexList = graph.getVertexList();
    } // end of constructor

    /**
     * Performs Breadth-First Search (BFS) traversal starting from the vertex with the given identifier.
     *
     * @param id The identifier of the starting vertex.
     * @return A string representation of the BFS traversal.
     */
    public String BFSTraversal(int id) {
        StringBuilder result = new StringBuilder();

        Vertex vertex = getVertex(id);

        Set<Vertex> verticesVisited = new HashSet<>();

        LinkedList<Vertex> queue = new LinkedList<>();

        queue.add(vertex);
        verticesVisited.add(vertex);

        while (!queue.isEmpty()) {
            vertex = queue.poll();
            result.append(vertex).append(" ");

            for (Edge edge : vertex.getAdjacencyList()) {
                if (!verticesVisited.contains(edge.getEnd())) {
                    verticesVisited.add(edge.getEnd());
                    queue.add(edge.getEnd());
                }
            }
        }
        return result.toString();
    } // end of BFSTraversal

    /**
     * Performs Depth-First Search (DFS) traversal starting from the vertex with the given identifier.
     *
     * @param id The identifier of the starting vertex.
     * @return A string representation of the DFS traversal.
     */
    public String DFSTraversal(int id) {
        StringBuilder result = new StringBuilder();

        Vertex vertex = getVertex(id);

        Set<Vertex> verticesVisited = new HashSet<>();

        Stack<Vertex> stack = new Stack<>();

        stack.push(vertex);

        while (!stack.isEmpty()) {
            vertex = stack.pop();

            if (!verticesVisited.contains(vertex)) {
                verticesVisited.add(vertex);
                result.append(vertex).append(" ");
            }

            for (Edge edge : vertex.getAdjacencyList()) {
                if (!verticesVisited.contains(edge.getEnd())) {
                    stack.push(edge.getEnd());
                }
            }
        }
        return result.toString();
    } // end of DFSTraversal

    /**
     * Finds the shortest path from a source vertex to a destination vertex using Dijkstra's algorithm.
     *
     * @param sourceId      The identifier of the starting vertex
     * @param destinationId The identifier of the destination vertex
     * @return A string representation of the shortest path length, or a message indicating that no path exists
     */
    public String shortestPath(int sourceId, int destinationId) {
        Vertex root = getVertex(sourceId);
        Vertex destination = getVertex(destinationId);

        Map<Vertex, Double> distanceMap = new HashMap<>();
        Map<Vertex, Vertex> previousVertexMap = new HashMap<>();
        Set<Vertex> verticesVisited = new HashSet<>();
        LinkedList<Vertex> queue = new LinkedList<>();

        queue.add(root);
        distanceMap.put(root, 0.0);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            verticesVisited.add(currentVertex);

            for (Edge edge : currentVertex.getAdjacencyList()) {
                Vertex endVertex = edge.getEnd();
                if (!verticesVisited.contains(endVertex)) {
                    double newDistance = distanceMap.get(currentVertex) + edge.getWeight();

                    // If the new distance is shorter than the existing distance
                    if (newDistance < distanceMap.getOrDefault(endVertex, Double.MAX_VALUE)) {
                        distanceMap.put(endVertex, newDistance);
                        previousVertexMap.put(endVertex, currentVertex);
                        queue.add(endVertex);
                    }
                }
            }
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double shortestPath = Double.parseDouble(decimalFormat.format(distanceMap.getOrDefault(destination, Double.MAX_VALUE)));

        shortestPathVertices = new StringBuilder();
        if (shortestPath != Double.MAX_VALUE) {
            constructShortestPath(previousVertexMap, destination);
            return shortestPath + "";
        }
        return "There is no path from " + sourceId + " to " + destinationId;
    } // end of shortestPath

    /**
     * Constructs the vertices of the shortest path from a destination vertex to the source vertex.
     *
     * @param previousVertexMap A map of vertices to their predecessors in the shortest path.
     * @param destination       The destination vertex.
     */
    public void constructShortestPath(Map<Vertex, Vertex> previousVertexMap, Vertex destination) {
        Vertex current = destination;

        while (current != null) {
            shortestPathVertices.insert(0, current + " ");
            current = previousVertexMap.get(current);
        }
    } // end of constructShortestPath

    /**
     * Retrieves a vertex with the specified identifier from the list of vertices.
     *
     * @param id The identifier of the vertex to be retrieved.
     * @return The vertex with the specified identifier, or null if not found.
     */
    public Vertex getVertex(int id) {
        return vertexList.stream()
                .filter(vertex -> vertex.getId() == id)
                .findFirst()
                .orElse(null);
    } // end of getVertex

    /**
     * Gets the vertices of the shortest path as a string.
     *
     * @return A string representation of the vertices of the shortest path.
     */
    public String getShortestPathVertices() {
        return shortestPathVertices.toString();
    } // end of getShortestPathVertices
} // end of GraphTraversal class

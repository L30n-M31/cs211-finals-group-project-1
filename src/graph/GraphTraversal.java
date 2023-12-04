package graph;

import java.text.DecimalFormat;
import java.util.*;

public class GraphTraversal {
    private final List<Vertex> vertexList;
    private StringBuilder shortestPathVertices;

    public GraphTraversal(Graph graph) {
        vertexList = graph.getVertexList();
    } // end of constructor

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

    public void constructShortestPath(Map<Vertex, Vertex> previousVertexMap, Vertex destination) {
        Vertex current = destination;

        while (current != null) {
            shortestPathVertices.insert(0, current + " ");
            current = previousVertexMap.get(current);
        }
    } // end of constructShortestPath

    public Vertex getVertex(int id) {
        return vertexList.stream()
                .filter(vertex -> vertex.getId() == id)
                .findFirst()
                .orElse(null);
    } // end of getVertex

    public String getShortestPathVertices() {
        return shortestPathVertices.toString();
    } // end of getShortestPathVertices
} // end of GraphTraversal class

package graph;

/**
 * Represents an edge in a graph connecting two vertices.
 */
public class Edge {
    private final Vertex start;
    private final Vertex end;
    private final double weight;
    private final int id;

    /**
     * Constructs a new edge with the given start and end vertices, weight, and edge identifier.
     *
     * @param start  The starting vertex of the edge.
     * @param end    The ending vertex of the edge.
     * @param weight The weight associated with the edge.
     * @param id     The unique identifier of the edge.
     */
    public Edge(Vertex start, Vertex end, double weight, int id) {
        this.start = start;
        this.end = end;
        this.weight = weight;
        this.id = id;
    } // end of constructor

    /**
     * Gets the starting vertex of the edge.
     *
     * @return The starting vertex.
     */
    public Vertex getStart() {
        return start;
    } // end of getStart

    /**
     * Gets the ending vertex of the edge.
     *
     * @return The ending vertex.
     */
    public Vertex getEnd() {
        return end;
    } // end of getEnd

    /**
     * Gets the weight associated with the edge.
     *
     * @return The weight of the edge.
     */
    public double getWeight() {
        return weight;
    } // end of getWeight

    /**
     * Gets the unique identifier of the edge.
     *
     * @return The identifier of the edge.
     */
    public int getId() {
        return id;
    } // end of getId

    /**
     * Returns a string representation of the edge in the format "(start,end)".
     *
     * @return A string representation of the edge.
     */
    @Override
    public String toString() {
        return "(" + start + "," + end + ")";
    } // end of toString

    /**
     * Checks if this edge is equal to another object.
     * Two edges are equal if their start and end vertices have the same identifiers.
     *
     * @param object The object to compare with.
     * @return True if the edges are equal, false otherwise.
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Edge otherEdge) {
            return otherEdge.getStart().getId() == getStart().getId() && otherEdge.getEnd().getId() == getEnd().getId();
        }
        return false;
    } // end of equals
} // end of Edge

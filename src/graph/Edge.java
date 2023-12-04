package graph;

public class Edge {
    private final Vertex start;
    private final Vertex end;
    private final double weight;
    private final int id;

    public Edge(Vertex start, Vertex end, double weight, int id) {
        this.start = start;
        this.end = end;
        this.weight = weight;
        this.id = id;
    } // end of constructor

    public Vertex getStart() {
        return start;
    } // end of getStart

    public Vertex getEnd() {
        return end;
    } // end of getEnd

    public double getWeight() {
        return weight;
    } // end of getWeight

    public int getId() {
        return id;
    } // end of getId

    @Override
    public String toString() {
        return "(" + start + "," + end + ")";
    } // end of toString

    @Override
    public boolean equals(Object object) {
        if (object instanceof Edge otherEdge) {
            return otherEdge.getStart().getId() == getStart().getId() && otherEdge.getEnd().getId() == getEnd().getId();
        }
        return false;
    } // end of equals
} // end of Edge

package gui;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import graph.Edge;
import graph.Vertex;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class GraphPanel extends JPanel {
    private final Graphics graphics = new Graphics();
    private mxGraphComponent graphComponent;
    private mxStylesheet stylesheet;
    private final List<Vertex> vertexList;

    public GraphPanel(List<Vertex> vertexList) {
        this.vertexList = vertexList;
        initializeComponents();
        setGraphics();
    } // end of constructor

    public void initializeComponents() {
        if (vertexList == null || vertexList.isEmpty()) {
            JLabel messageLB = new JLabel("NO GRAPH DATA");
            add(messageLB, BorderLayout.CENTER);
        } else {
            mxGraph graph = new mxGraph();
            Object parent = graph.getDefaultParent();

            stylesheet = graph.getStylesheet();
            // Create a stylesheet

            graph.getModel().beginUpdate();

            try {
                // Add vertices
                Object[] vertexCells = new Object[vertexList.size()];
                int i = 0;

                int totalWidth = 0;
                int totalHeight = 0;

                for (Vertex vertex : vertexList) {
                    // Adjust x and y coordinates to center the graph
                    int x = 20 + (i % 3) * 100;
                    int y = 20 + (i / 3) * 100;

                    vertexCells[i] = graph.insertVertex(parent, null, vertex.getId(), x, y, 30, 30);

                    totalWidth = Math.max(totalWidth, x + 30);
                    totalHeight = Math.max(totalHeight, y + 30);

                    i++;
                }

                // Add edges
                for (Vertex vertex : vertexList) {
                    for (Edge edge : vertex.getAdjacencyList()) {
                        Object sourceCell = vertexCells[vertex.getId()];
                        Object targetCell = vertexCells[edge.getEnd().getId()];
                        graph.insertEdge(parent, null, "", sourceCell, targetCell);
                    }
                }

                // Apply hierarchical layout
                mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
                layout.execute(parent);
            } finally {
                graph.getModel().endUpdate();
            }

            graphComponent = new mxGraphComponent(graph);
            graphComponent.setBorder(new EmptyBorder(10, 10, 10, 10));
            setPreferredSize(new Dimension(600, 500));
            setLayout(new GridBagLayout());
            add(graphComponent);
        }
    } // end of initializeComponents

    public void setGraphics() {
        setBackground(graphics.getLightOlive());
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        graphComponent.setBackground(graphics.getLightOlive());
        graphComponent.getViewport().setBackground(graphics.getLightOlive());

        // Define styles for vertices
        stylesheet.getDefaultVertexStyle().put(mxConstants.STYLE_FILLCOLOR, "#B85042");
        stylesheet.getDefaultVertexStyle().put(mxConstants.STYLE_STROKECOLOR, "#B85042");
        stylesheet.getDefaultVertexStyle().put(mxConstants.STYLE_FONTCOLOR, "#A7BEAE");
    } // end of setGraphics
} // end of GraphPanel class

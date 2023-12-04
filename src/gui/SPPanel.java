package gui;

import graph.Graph;
import graph.GraphTraversal;

import javax.swing.*;

public class SPPanel extends JPanel {
    private final Graphics graphics = new Graphics();
    private JComboBox<Integer> jComboBox1, jComboBox2;
    private JTextPane resultTP;
    private JScrollPane resultScrollPane;
    private JButton traverseBT;
    private JLabel titleLB, menuItem1LB, menuItem2LB, resultLB;
    private Graph graph = null;

    public SPPanel() { }

    public void initializePanel() {
        setLayout(null);
        initializeComponents();
        setBounds();
        setGraphics();
    } // end of initializePanel

    public void initializeComponents() {
        jComboBox1 = new JComboBox<>();
        jComboBox2 = new JComboBox<>();
        resultTP = new JTextPane();
        resultScrollPane = new JScrollPane(resultTP);

        titleLB = new JLabel("PATH");
        menuItem1LB = new JLabel("ROOT");
        menuItem2LB = new JLabel("DESTINATION");
        resultLB = new JLabel("RESULT");
        traverseBT = new JButton("TRAVERSE");

        graph.getVertexList().forEach(vertex -> {
            jComboBox1.addItem(vertex.getId());
            jComboBox2.addItem(vertex.getId());
        });

        traverseBT.addActionListener(e -> {
            GraphTraversal graphTraversal = new GraphTraversal(graph);
            int rootId = Integer.parseInt(String.valueOf(jComboBox1.getSelectedItem()));
            int destinationId = Integer.parseInt(String.valueOf(jComboBox2.getSelectedItem()));

            String result = graphTraversal.shortestPath(rootId, destinationId);
            resultTP.setText("DISTANCE\n" + result + "\n\n" + "VERTICES\n" + graphTraversal.getShortestPathVertices());
        });

        add(titleLB);
        add(jComboBox1);
        add(menuItem1LB);
        add(jComboBox2);
        add(menuItem2LB);
        add(resultScrollPane);
        add(resultLB);
        add(traverseBT);
    } // end of initializeComponents

    public void setBounds() {
        int width = getWidth();
        int height = getHeight();

        titleLB.setBounds(0, 0, width, 100);
        jComboBox1.setBounds(10, 90, width - 20, 50);
        menuItem1LB.setBounds(0, 140, width, 50);
        jComboBox2.setBounds(10, 190, width - 20, 50);
        menuItem2LB.setBounds(0, 240, width, 50);
        resultScrollPane.setBounds(10, 290, width - 20, 100);
        resultLB.setBounds(0, 390, width, 50);
        traverseBT.setBounds(10, height - 60, width - 20, 50);
    } // end of setBounds

    public void setGraphics() {
        setBackground(graphics.getScarlet());

        graphics.setTitleLabelFormat(titleLB);
        graphics.setJComboBoxFormat(jComboBox1);
        graphics.setLabelFormat(menuItem1LB);
        graphics.setJComboBoxFormat(jComboBox2);
        graphics.setLabelFormat(menuItem2LB);
        graphics.setTextPaneFormat(resultTP);
        graphics.setLabelFormat(resultLB);
        graphics.setButtonFormat(traverseBT);
    } // end of setGraphics

    public void setGraph(Graph graph) {
        this.graph = graph;
    } // end of setGraph
} // end of SPPanel class

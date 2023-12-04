package gui;

import graph.Graph;
import graph.GraphTraversal;
import javax.swing.*;

public class DFSPanel extends JPanel {
    private final Graphics graphics = new Graphics();
    private JComboBox<Integer> jComboBox;
    private JTextPane resultTP;
    private JScrollPane resultScrollPane;
    private JButton traverseBT;
    private JLabel titleLB, menuItemLB, resultLB;
    private Graph graph = null;

    public DFSPanel() { }

    public void initializePanel() {
        setLayout(null);
        initializeComponents();
        setBounds();
        setGraphics();
    } // end of initializePanel

    public void initializeComponents() {
        jComboBox = new JComboBox<>();
        resultTP = new JTextPane();
        resultScrollPane = new JScrollPane(resultTP);

        titleLB = new JLabel("DFS");
        menuItemLB = new JLabel("SELECT VERTEX");
        resultLB = new JLabel("RESULT");
        traverseBT = new JButton("TRAVERSE");

        graph.getVertexList().forEach(vertex -> jComboBox.addItem(vertex.getId()));

        traverseBT.addActionListener(e -> {
            GraphTraversal graphTraversal = new GraphTraversal(graph);
            String result = graphTraversal.DFSTraversal(Integer.parseInt(String.valueOf(jComboBox.getSelectedItem())));
            resultTP.setText(result.trim());
        });

        add(titleLB);
        add(jComboBox);
        add(menuItemLB);
        add(resultScrollPane);
        add(resultLB);
        add(traverseBT);
    } // end of initializeComponents

    public void setBounds() {
        int width = getWidth();
        int height = getHeight();

        titleLB.setBounds(0, 0, width, 100);
        jComboBox.setBounds(10, 130, width - 20, 50);
        menuItemLB.setBounds(0, 180, width, 50);
        resultScrollPane.setBounds(10, 270, width - 20, 100);
        resultLB.setBounds(0, 370, width, 50);
        traverseBT.setBounds(10, height - 60, width - 20, 50);
    } // end of setBounds

    public void setGraphics() {
        setBackground(graphics.getScarlet());

        graphics.setTitleLabelFormat(titleLB);
        graphics.setJComboBoxFormat(jComboBox);
        graphics.setLabelFormat(menuItemLB);
        graphics.setTextPaneFormat(resultTP);
        graphics.setLabelFormat(resultLB);
        graphics.setButtonFormat(traverseBT);
    } // end of setGraphics

    public void setGraph(Graph graph) {
        this.graph = graph;
    } // end of setGraph
} // end of DFSPanel

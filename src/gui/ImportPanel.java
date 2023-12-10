package gui;

import graph.Graph;
import graph.GraphCreation;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ImportPanel extends JPanel {
    private final Graphics graphics = new Graphics();
    private final GUI gui;
    private JLabel titleLB;
    private JTextField filenameTF;
    private JButton importBT;
    private boolean graphLoaded;
    private GraphCreation graph;
    private GraphPanel graphPanel;

    public ImportPanel(GUI gui) {
        graphLoaded = false;
        this.gui = gui;
        initializePanel();
        initializeComponents();
        addTextFieldHint();
        setGraphics();
    } // end of constructor

    public void initializePanel() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());
    } // end of initializePanel

    public void initializeComponents() {
        filenameTF = new JTextField();
        titleLB = new JLabel("IMPORT");
        importBT = new JButton("IMPORT");

        importBT.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            graph = new GraphCreation();

            if (!filenameTF.getText().equals("Enter Filename")) {
                graph.createGraph(filenameTF.getText());

                if (graphPanel != null) {
                    gui.getContentPane().remove(graphPanel);
                }

                graphPanel = new GraphPanel(graph.getGraph().getVertexList());
                gui.getContentPane().add(graphPanel, BorderLayout.EAST);

                gui.revalidate();
                gui.repaint();

                graphLoaded = true;
            } else {
                JOptionPane.showMessageDialog(null, "You have not specified a file yet");
            }
        }));

        add(titleLB, BorderLayout.NORTH);
        add(filenameTF, BorderLayout.CENTER);
        add(importBT, BorderLayout.SOUTH);
    } // end of initializeComponents

    public void addTextFieldHint() {
        String filenameHint = "Enter Filename";
        filenameTF.setText(filenameHint);
        filenameTF.setForeground(Color.GRAY);

        filenameTF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (filenameTF.getText().equals(filenameHint)) {
                    filenameTF.setText("");
                    filenameTF.setForeground(graphics.getScarlet());
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (filenameTF.getText().isEmpty()) {
                    filenameTF.setText(filenameHint);
                    filenameTF.setForeground(graphics.getScarlet());
                }
            }
        });
    } // end of addTextFieldHint

    public void setGraphics() {
        setBackground(graphics.getScarlet());
        graphics.setImportTextField(filenameTF);
        graphics.setTitleLabelFormat(titleLB);
        graphics.setButtonFormat(importBT);

        filenameTF.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    } // end of setGraphics

    public Graph getGraph() {
        return graph.getGraph();
    } // end of getGraph

    public boolean isGraphLoaded() {
        return graphLoaded;
    } // end of isGraphLoaded
} // end of ImportPanel

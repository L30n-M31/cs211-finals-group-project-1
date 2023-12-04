package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    private final Graphics graphics = new Graphics();
    private JButton importGraphBT, breadthFirstSearchBT, depthFirstSearchBT, shortestPathBT, exitBT;

    public MenuPanel() {
        initializePanel();
        initializeComponents();
        setGraphics();
    } // end of constructor

    public void initializePanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 15));
    } // end of initializePanel

    public void initializeComponents() {
        importGraphBT = new JButton("Import Graph Data");
        breadthFirstSearchBT = new JButton("Breadth First Search");
        depthFirstSearchBT = new JButton("Depth First Search");
        shortestPathBT = new JButton("Shortest Path");
        exitBT = new JButton("Exit");

        add(importGraphBT);
        add(breadthFirstSearchBT);
        add(depthFirstSearchBT);
        add(shortestPathBT);
        add(exitBT);
    } // end of initializeComponents

    public void addButtonActionListener(ActionListener listener) {
        importGraphBT.addActionListener(listener);
        breadthFirstSearchBT.addActionListener(listener);
        depthFirstSearchBT.addActionListener(listener);
        shortestPathBT.addActionListener(listener);
        exitBT.addActionListener(listener);
    } // end of addButtonActionListener

    public void setGraphics() {
        setBackground(graphics.getLightTeal());

        graphics.setMenuButtonFormat(importGraphBT);
        graphics.setMenuButtonFormat(breadthFirstSearchBT);
        graphics.setMenuButtonFormat(depthFirstSearchBT);
        graphics.setMenuButtonFormat(shortestPathBT);
        graphics.setMenuButtonFormat(exitBT);

    }
} // end of MenuPanel class

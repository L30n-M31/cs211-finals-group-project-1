package gui;

import javax.swing.*;
import java.awt.*;

public class HomepageContent extends JPanel {
    private final Graphics graphics = new Graphics();
    private JLabel message;

    public HomepageContent() {
        initializePanel();
        initializeComponents();
        setGraphics();
    } // end of constructor

    public void initializePanel() {
        setLayout(new GridBagLayout());
    } // end of initializePanel

    public void initializeComponents() {
        message = new JLabel("<html><div style='text-align: center;'>" +
                "Welcome to this program!<br><br>" +
                "Before loading your graph, take note that the program <br>" +
                "automatically makes your graph an undirected graph.<br>" +
                "This means that you only have to specify an edge once<br>" +
                "and need not to include the inverted edge.<br><br>" +
                "Please ensure that the file contains the following format:<br>" +
                "(starting id),(ending id),(edge weight),(edge id)<br><br>" +
                "omit the () in the real data of the graph");
        add(message);
    } // end of initializeComponents

    public void setGraphics() {
        setBackground(graphics.getLightOlive());
        graphics.setMessageFormat(message);
    }
} // end of HomepageContent class

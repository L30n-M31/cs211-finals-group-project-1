package gui;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    public GUI() {
        initializeFrame();
        initializeComponents();
        setVisible(true);
    } // end of constructor

    public void initializeFrame() {
        setTitle("Graph Traversals");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
    } // end of initializeFrame

    public void initializeComponents() {
        MenuPanel menuPanel = new MenuPanel();
        ContentPanel contentPanel = new ContentPanel(menuPanel, this);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        getContentPane().add(menuPanel, BorderLayout.SOUTH);
    } // end of initializeComponents
} // end of GUI class

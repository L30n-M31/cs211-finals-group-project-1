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
        message = new JLabel("WELCOME TO THIS PROGRAM (TO DO)");
        add(message);
    } // end of initializeComponents

    public void setGraphics() {
        setBackground(graphics.getLightOlive());

        message.setForeground(graphics.getScarlet());
    }
} // end of HomepageContent class

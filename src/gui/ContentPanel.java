package gui;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private final MenuPanel menuPanel;
    private final GUI gui;
    private ImportPanel importPanel;
    private BFSPanel bfsPanel;
    private DFSPanel dfsPanel;
    private SPPanel spPanel;
    private boolean graphLoaded = false, initBFS = false, initDFS = false, initSP = false;

    public ContentPanel(MenuPanel menuPanel, GUI gui) {
        this.menuPanel = menuPanel;
        this.gui = gui;
        initializePanel();
        initializeComponents();
        setButtonActions();
    } // end of constructor

    public void initializePanel() {
        setLayout(new BorderLayout());
    } // end of initializePanel

    public void initializeComponents() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        HomepageContent homepageContent = new HomepageContent();
        importPanel = new ImportPanel(gui);
        bfsPanel = new BFSPanel();
        dfsPanel = new DFSPanel();
        spPanel = new SPPanel();

        cardPanel.add(homepageContent, "HOMEPAGE");
        cardPanel.add(importPanel, "IMPORT");
        cardPanel.add(bfsPanel, "BFS");
        cardPanel.add(dfsPanel, "DFS");
        cardPanel.add(spPanel, "SP");
        add(cardPanel, BorderLayout.CENTER);
    } // end of initializeComponents

    public void setButtonActions() {
        menuPanel.addButtonActionListener(e -> {
            String command = e.getActionCommand();
            switch (command) {
                case "Import Graph Data":
                    showPanel("IMPORT");
                    break;
                case "Breadth First Search":
                    graphLoaded = importPanel.isGraphLoaded();
                    if (graphLoaded) {
                        bfsPanel.setGraph(importPanel.getGraph());
                        if (!initBFS) {
                            bfsPanel.initializePanel();
                            initBFS = true;
                        }
                        showPanel("BFS");
                    } else {
                        JOptionPane.showMessageDialog(null, "You need to import a graph first");
                    }
                    break;
                case "Depth First Search":
                    graphLoaded = importPanel.isGraphLoaded();
                    if (graphLoaded) {
                        dfsPanel.setGraph(importPanel.getGraph());
                        if (!initDFS) {
                            dfsPanel.initializePanel();
                            initDFS = true;
                        }
                        showPanel("DFS");
                    } else {
                        JOptionPane.showMessageDialog(null, "You need to import a graph first");
                    }
                    break;
                case "Shortest Path":
                    graphLoaded = importPanel.isGraphLoaded();
                    if (graphLoaded) {
                        spPanel.setGraph(importPanel.getGraph());
                        if (!initSP) {
                            spPanel.initializePanel();
                            initSP = true;
                        }
                        showPanel("SP");
                    } else {
                        JOptionPane.showMessageDialog(null, "You need to import a graph first");
                    }
                    break;
                case "Exit":
                    System.exit(0);
                    break;
            }
        });
    } // end of setButtonActions

    public void showPanel(String panelName) {
        cardLayout.show(cardPanel, panelName);
    } // end of showPanel
} // end of ContentPanel class

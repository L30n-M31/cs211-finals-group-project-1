package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class Graphics {
    private final Color scarlet = new Color(184, 80, 66);
    private final Color lightOlive = new Color(231, 232, 209);
    private final Color lightTeal = new Color(167, 190, 174);

    //--------------------------< Import Panel Components >---------------
    public void setImportTextField(JTextField textField) {
        textField.setFont(new Font("Monospaced", Font.PLAIN, 18));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBackground(lightOlive);
        textField.setForeground(scarlet);
    }

    //---------------------------< Traversal Panel Components >--------------------------------------
    public void setTitleLabelFormat(JLabel label) {
        label.setFont(new Font("Monospaced", Font.BOLD, 40));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(lightOlive);
    } // end of setTitleLabelFormat

    public void setJComboBoxFormat(JComboBox<Integer> jComboBox) {
        DefaultListCellRenderer listCellRenderer = new DefaultListCellRenderer();
        listCellRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        jComboBox.setRenderer(listCellRenderer);
        jComboBox.setFont(new Font("Monospaced", Font.PLAIN, 20));

        jComboBox.setBackground(lightOlive);
        jComboBox.setForeground(scarlet);
    } // end of setJComboBoxFormat

    public void setLabelFormat(JLabel label) {
        label.setFont(new Font("Monospaced", Font.PLAIN, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(lightOlive);
    } // end of setLabelFormat

    public void setTextPaneFormat(JTextPane textPane) {
        textPane.setFont(new Font("Monospaced", Font.PLAIN, 20));
        textPane.setEnabled(false);
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        textPane.setBackground(lightOlive);
        textPane.setDisabledTextColor(scarlet);
    } // end of setTextPaneFormat

    public void setButtonFormat(JButton button) {
        button.setFont(new Font("Monospaced", Font.BOLD, 18));
        button.setBackground(lightTeal);
        button.setForeground(scarlet);
    } // end of setButtonFormat

    //---------------------------< Menu Panel Components >----------------------------
    public void setMenuButtonFormat(JButton button) {
        Border lineBorder = new LineBorder(Color.BLACK, 2);
        Border emptyBorder = new EmptyBorder(5, 15, 5, 15);
        Border compoundBorder = new CompoundBorder(lineBorder, emptyBorder);

        button.setBackground(scarlet);
        button.setForeground(lightOlive);
        button.setBorder(compoundBorder);
    } // end of setMenuButtonFormat

    //---------------------------------------------< Color Getters >----------------------------------------------------
    public Color getScarlet() {
        return scarlet;
    }
    public Color getLightOlive() {
        return lightOlive;
    }
    public Color getLightTeal() {
        return lightTeal;
    }
} // end of Graphics class

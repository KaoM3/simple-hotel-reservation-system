package view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SubFrame extends JFrame {
        JPanel currentPanel;

    public SubFrame() {
        this.setTitle("Subframe");
        this.setLayout(new GridLayout(3, 1));
        this.setVisible(true);
        this.setSize(360, 80);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.currentPanel = null;
    }

    public SubFrame(JPanel panel) {
        this();
        this.setPanel(panel);
    }

    public void setPanel(JPanel panel) {
        this.setTitle(panel.getName());
        if(currentPanel != null) {
            this.remove(currentPanel);
        }
        this.add(panel);
        pack();
        this.currentPanel = panel;
    }
}

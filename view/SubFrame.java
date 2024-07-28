package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SubFrame extends JFrame {
    JPanel mainPanel;

    public SubFrame(JPanel mainPanel) {
        this.mainPanel = mainPanel;
        initComponents();
    }

    private void initComponents() {
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        getContentPane().setPreferredSize(mainPanel.getPreferredSize());
        getContentPane().setLayout(null);

        mainPanel.setBounds(0, 0, (int)mainPanel.getPreferredSize().getWidth(), (int)mainPanel.getPreferredSize().getHeight());

        add(mainPanel);
        pack();
    }

}

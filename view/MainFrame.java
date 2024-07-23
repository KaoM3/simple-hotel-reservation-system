package view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.HotelReservationSystemController;

public class MainFrame extends JFrame {
    HotelReservationSystemController controller;
    JPanel currentPanel;

    public MainFrame() {
        this.setTitle("Hotel Reservation System");
        this.setLayout(new GridLayout(1, 1));
        this.setSize(400, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.currentPanel = null;
    }
    
    public MainFrame(JPanel panel) {
        this();
        this.currentPanel = panel;
    }

    public void setController(HotelReservationSystemController controller) {
        this.controller = controller;
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.HotelReservationSystemController;

/**
 *
 * @author Rafael
 */
public class MainFrame extends JFrame {
    public static final int MAINPANEL_WIDTH = 570;
    public static final int MAINPANEL_HEIGHT = 480;

    private static final int MAINPANEL_X = 150;
    private static final int MAINPANEL_Y = 0;

    private final HotelReservationSystemController controller;
    private JPanel mainPanel;
    private SideButtonPanel sideButtons1;

    /**
     * Creates new form MainFrame
     */
    public MainFrame(HotelReservationSystemController controller) {
        this.controller = controller;
        initComponents();
    }

    /**
     * Initializes the components of this MainFrame
     */
    private void initComponents() {

        sideButtons1 = new view.main.SideButtonPanel(controller, this);
        mainPanel = new javax.swing.JPanel();

        sideButtons1.setBounds(0, 0, 150, 480);
        mainPanel.setBounds(MAINPANEL_X, MAINPANEL_Y, MAINPANEL_WIDTH, MAINPANEL_HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        getContentPane().setPreferredSize(new Dimension(720, 480));
        getContentPane().setLayout(null);

        getContentPane().add(sideButtons1);
        getContentPane().add(mainPanel);

        pack();
    }

    /**
     * Removes the current mainPanel of this MainFrame, displays and sets it to {@code panel}
     * @param panel is the new mainPanel
     */
    public void setMainPanel(JPanel panel) {

        setTitle(panel.getName());

        getContentPane().remove(mainPanel);
        mainPanel = panel;
        getContentPane().add(mainPanel);
        mainPanel.setBounds(MAINPANEL_X, MAINPANEL_Y, MAINPANEL_WIDTH, MAINPANEL_HEIGHT);
        
        pack();
    }

}

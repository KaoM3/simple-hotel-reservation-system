/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.HotelReservationSystemController;
/**
 *
 * @author Rafael
 */
public class SideButtonPanel extends javax.swing.JPanel implements ActionListener {
    private final HotelReservationSystemController controller;
    private final MainFrame frame;
    private JButton bookButton;
    private JButton createButton;
    private JButton manageButton;
    private JButton viewButton;

    /**
     * Creates new form SideButtons
     */
    public SideButtonPanel(HotelReservationSystemController controller, MainFrame frame) {
        this.controller = controller;
        this.frame = frame;
        this.setPreferredSize(new Dimension(150, 480));
        initComponents();
    }

    /**
     * Initializes panel components
     */
    private void initComponents() {

        createButton = new JButton();
        viewButton = new JButton();
        manageButton = new JButton();
        bookButton = new JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new Dimension(150, 480));
        setLayout(null);

        createButton.setText("Create");
        createButton.addActionListener(this);
        add(createButton);
        createButton.setBounds(20, 40, 110, 60);

        viewButton.setText("View");
        viewButton.addActionListener(this);
        add(viewButton);
        viewButton.setBounds(20, 150, 110, 60);

        manageButton.setText("Manage");
        manageButton.addActionListener(this);
        add(manageButton);
        manageButton.setBounds(20, 260, 110, 60);
        
        bookButton.setText("Book");
        bookButton.addActionListener(this);
        add(bookButton);
        bookButton.setBounds(20, 370, 110, 60);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == createButton) {
            frame.setMainPanel(new CreatePanel(controller));
        }
        else if(event.getSource() == viewButton) {
            frame.setMainPanel(new ViewPanel(controller));
        }
        else if(event.getSource() == manageButton) {
            // TODO: Add Manage
            frame.setMainPanel(new ManagePanel());
        }
        else if(event.getSource() == bookButton) {
            // TODO: Add book
            frame.setMainPanel(new BookingPanel());
        }
    }
}

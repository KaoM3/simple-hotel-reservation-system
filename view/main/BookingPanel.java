/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.HotelReservationSystemController;

/**
 *
 * @author Rafael
 */
public class BookingPanel extends JPanel implements ActionListener {
    private HotelReservationSystemController controller;
    private JLabel checkInLabel;
    private JTextField checkInTextField;
    private JLabel checkOutLabel;
    private JTextField checkOutTextField;
    private JButton confirmReservationButton;
    private JLabel discountCodeLabel;
    private JTextField discountCodeTextField;
    private JLabel guestNameLabel;
    private JTextField guestNameTextField;
    private JLabel hotelHeading;
    private JScrollPane hotelScrollPane;
    private JTable hotelTable;
    private JLabel reservationHeading;
    private JScrollPane roomScrollPane;
    private JTable roomTable;
    private JButton roomTableButton;
    private JLabel selectedRoomLabel;
    private JTextField selectedRoomTextField;
    private JTextField totalPriceField;
    private JLabel totalPriceLabel;

    /**
     * Creates new form BookingPanel
     */
    public BookingPanel(HotelReservationSystemController controller) {
        this.controller = controller;
        initComponents();
    }
                  
    private void initComponents() {

        roomScrollPane = new JScrollPane();
        roomTable = new JTable();
        reservationHeading = new JLabel();
        totalPriceLabel = new JLabel();
        totalPriceField = new JTextField();
        roomTableButton = new JButton();
        hotelScrollPane = new JScrollPane();
        hotelTable = new JTable();
        guestNameLabel = new JLabel();
        guestNameTextField = new JTextField();
        checkInLabel = new JLabel();
        checkInTextField = new JTextField();
        checkOutLabel = new JLabel();
        checkOutTextField = new JTextField();
        discountCodeLabel = new JLabel();
        discountCodeTextField = new JTextField();
        confirmReservationButton = new JButton();
        hotelHeading = new JLabel();
        selectedRoomLabel = new JLabel();
        selectedRoomTextField = new JTextField();

        setLayout(null);

        // TODO: Add Room Table Data
        roomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Available Rooms"
            }
        ));
        roomScrollPane.setViewportView(roomTable);

        add(roomScrollPane);
        roomScrollPane.setBounds(20, 160, 220, 300);

        reservationHeading.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reservationHeading.setText("Reservation Information");
        add(reservationHeading);
        reservationHeading.setBounds(260, 300, 280, 20);

        totalPriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalPriceLabel.setText("Total Price:");
        add(totalPriceLabel);
        totalPriceLabel.setBounds(260, 370, 100, 30);

        totalPriceField.setText("Total Price");
        add(totalPriceField);
        totalPriceField.setBounds(370, 370, 170, 30);

        roomTableButton.addActionListener(this);
        roomTableButton.setText("Find Available Rooms");
        add(roomTableButton);
        roomTableButton.setBounds(370, 260, 170, 23);

        // TODO: Add Hotel Table Data
        hotelTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Selected Hotel"
            }
        ));
        hotelScrollPane.setViewportView(hotelTable);

        add(hotelScrollPane);
        hotelScrollPane.setBounds(20, 30, 220, 110);

        guestNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        guestNameLabel.setText("Guest Name:");
        add(guestNameLabel);
        guestNameLabel.setBounds(260, 90, 100, 30);

        guestNameTextField.setText("Name");
        add(guestNameTextField);
        guestNameTextField.setBounds(370, 90, 170, 30);

        checkInLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkInLabel.setText("Check In:");
        add(checkInLabel);
        checkInLabel.setBounds(260, 130, 100, 30);

        checkInTextField.setText("Date");
        add(checkInTextField);
        checkInTextField.setBounds(370, 130, 170, 30);

        checkOutLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkOutLabel.setText("Check Out:");
        add(checkOutLabel);
        checkOutLabel.setBounds(260, 170, 100, 30);

        checkOutTextField.setText("Date");
        add(checkOutTextField);
        checkOutTextField.setBounds(370, 170, 170, 30);

        discountCodeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        discountCodeLabel.setText("Discount Code:");
        add(discountCodeLabel);
        discountCodeLabel.setBounds(260, 210, 100, 30);

        discountCodeTextField.setText("Code");
        add(discountCodeTextField);
        discountCodeTextField.setBounds(370, 210, 170, 30);

        confirmReservationButton.addActionListener(this);
        confirmReservationButton.setText("Confirm Reservation");
        add(confirmReservationButton);
        confirmReservationButton.setBounds(370, 430, 170, 23);

        hotelHeading.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hotelHeading.setText("Selected Hotel: [Hotel Name]");
        add(hotelHeading);
        hotelHeading.setBounds(260, 40, 280, 20);

        selectedRoomLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectedRoomLabel.setText("Selected Room:");
        add(selectedRoomLabel);
        selectedRoomLabel.setBounds(260, 330, 100, 30);

        selectedRoomTextField.setText("Room Name");
        add(selectedRoomTextField);
        selectedRoomTextField.setBounds(370, 330, 170, 30);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == roomTableButton) {
            // TODO: Add Implementation
            System.out.println("Refresh room table");
        }
        else if(event.getSource() == confirmReservationButton) {
            // TODO: Add Implementation
            System.out.println("Confirm Booking");
        }
    }

    @Override
    public String getName() {
        return "Book New Reservation";
    }
}

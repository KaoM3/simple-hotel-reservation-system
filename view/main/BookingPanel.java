/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.main;

import controller.HotelReservationSystemController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.hotel.Hotel;
import model.hotel.room.DeluxeRoom;
import model.hotel.room.ExecutiveRoom;
import model.hotel.room.Room;
import model.hotel.room.StandardRoom;

/**
 *
 * @author Rafael
 */
public class BookingPanel extends JPanel implements ActionListener, ListSelectionListener {
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
    private JLabel availableRoomsLabel;
    private DefaultTableModel roomTableModel;
    private ListSelectionModel roomSelectionModel, hotelSelectionModel;
    private int hotelIndex, roomIndex;
    private int checkIn, checkOut;

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
        availableRoomsLabel = new JLabel();
        roomTableModel = new DefaultTableModel(0, 0);

        roomIndex = -1;
        hotelIndex = -1;

        setLayout(null);

        // Initializing Empty Room Table
        String roomTableHeader[] = {"Room", "Room Type"};
        roomTableModel.setColumnIdentifiers(roomTableHeader);
        roomTable.setModel(roomTableModel);

        // Adding a selection model to room table (updates every time the selection is changed)
        roomSelectionModel = roomTable.getSelectionModel();
        roomSelectionModel.addListSelectionListener(this);

        roomScrollPane.setViewportView(roomTable);
        add(roomScrollPane);
        roomScrollPane.setBounds(20, 190, 220, 270);

        reservationHeading.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reservationHeading.setText("Reservation Information");
        add(reservationHeading);
        reservationHeading.setBounds(260, 300, 280, 20);

        totalPriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalPriceLabel.setText("Total Price:");
        add(totalPriceLabel);
        totalPriceLabel.setBounds(260, 370, 100, 30);

        totalPriceField.setText("");
        add(totalPriceField);
        totalPriceField.setBounds(370, 370, 170, 30);
        totalPriceField.setEditable(false);

        roomTableButton.addActionListener(this);
        roomTableButton.setText("Find Available Rooms");
        add(roomTableButton);
        roomTableButton.setBounds(370, 260, 170, 23);

        // Initializing Empty Hotel Table
        String hotelNameHeader[] = {"Select a Hotel"};
        DefaultTableModel hotelListModel = new DefaultTableModel(0, 1);

        hotelListModel.setColumnIdentifiers(hotelNameHeader);
        hotelTable.setModel(hotelListModel);
        hotelTable.setEnabled(true);

        // Add Objects to Table
        for (int i = 0; i < controller.getHotelObjects().size(); i++) {
            hotelListModel.addRow(new Object[] {controller.getHotelObjects().get(i).getName()});
        }

        hotelTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        hotelSelectionModel = hotelTable.getSelectionModel();
        hotelSelectionModel.addListSelectionListener(this);

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
        hotelHeading.setText("No Selected Hotel");
        add(hotelHeading);
        hotelHeading.setBounds(260, 40, 280, 20);

        selectedRoomLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectedRoomLabel.setText("Selected Room:");
        add(selectedRoomLabel);
        selectedRoomLabel.setBounds(260, 330, 100, 30);

        selectedRoomTextField.setText("");
        add(selectedRoomTextField);
        selectedRoomTextField.setBounds(370, 330, 170, 30);
        selectedRoomTextField.setEditable(false);

        availableRoomsLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        availableRoomsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        availableRoomsLabel.setText("Available Rooms");
        add(availableRoomsLabel);
        availableRoomsLabel.setBounds(20, 156, 220, 30);
    }

    /**
     * Updates the labels whenever a new row is selected in roomTable
     */
    public void handleRoomSelection(ListSelectionEvent event) {
        if(hotelIndex == -1) {
            return;
        } else if(roomIndex == -1) {
            selectedRoomTextField.setText("");
            totalPriceField.setText("");
            return;
        }
        
        // Display room selected
        Hotel hotel = controller.getHotel(hotelIndex);
        Room room = hotel.getRoomList().get(roomIndex);
        selectedRoomTextField.setText(room.getName());

        // Display total price
        String discountCode;

        if(isDateInt()) {
            discountCode = discountCodeTextField.getText();
            double totalPrice = controller.getTotalReservationPrice(hotel, room, checkIn, checkOut, discountCode);
            totalPriceField.setText(Double.toString(totalPrice));
        }
    }

    /**
     * Updates the labels whenever a new row is selected in hotelTable
     */
    public void handleHotelSelection(ListSelectionEvent event) {
        if(isDateInt()) {
            updateRoomList(this.controller.getHotel(hotelIndex), checkIn, checkOut);
        } else {
            roomTableModel.setRowCount(0);
        }
        hotelHeading.setText("Selected Hotel: " + this.controller.getHotel(hotelIndex).getName());
    }

    public void updateRoomList(Hotel hotel, int checkIn, int checkOut) {
        System.out.println("UPDATEROOMLIST RUN");
        List<Room> availableRooms = hotel.filterRooms(checkIn, checkOut);

        roomTableModel.setRowCount(0);

        for (Room r : availableRooms) {
            String roomType = "ERROR";

            if (r instanceof StandardRoom) {
                roomType = "STANDARD";
            } else if (r instanceof DeluxeRoom) {
                roomType = "DELUXE";
            } else if (r instanceof ExecutiveRoom) {
                roomType = "EXECUTIVE";
            }

            roomTableModel.addRow(new Object[] {r.getName(),
                                                roomType});

            System.out.println(r.getName() + " " + roomType);
        }

        String roomTableHeader[] = {"Room", "Room Type"};
        roomTableModel.setColumnIdentifiers(roomTableHeader);
        roomTable.setModel(roomTableModel);
    }

    private boolean isDateInt() {
        try {
            checkIn = Integer.parseInt(checkInTextField.getText());
            checkOut = Integer.parseInt(checkOutTextField.getText());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid date!");
            return false;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if(event.getValueIsAdjusting()) {
            return;
        }

        if(event.getSource() == hotelSelectionModel) {
            hotelIndex = hotelTable.getSelectedRow();
            System.out.printf("h:%d",hotelIndex);
            handleHotelSelection(event);
        }
        else if(event.getSource() == roomSelectionModel) {
            roomIndex = roomTable.getSelectedRow();
            System.out.printf("r:%d",roomIndex);
            handleRoomSelection(event);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if (hotelIndex == -1) {
            JOptionPane.showMessageDialog(null, "No hotel selected!");
            return;
        }

        if (event.getSource() == roomTableButton) {
            Hotel hotel = controller.getHotel(hotelIndex);

            if(isDateInt()) {
                updateRoomList(hotel, checkIn, checkOut);
                System.out.println("Refresh room table");
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid date!");
            }
            
        }
        else if (event.getSource() == confirmReservationButton) {
            // TODO: Add Implementation
            System.out.println("Confirm Booking");
        }
    }

    @Override
    public String getName() {
        return "Book New Reservation";
    }
}

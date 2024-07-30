/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.main;

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

import controller.HotelReservationSystemController;
import model.hotel.Hotel;
import model.hotel.room.DeluxeRoom;
import model.hotel.room.ExecutiveRoom;
import model.hotel.room.Room;
import model.hotel.room.StandardRoom;

public class BookingPanel extends JPanel implements ActionListener, ListSelectionListener {
    private HotelReservationSystemController controller;

    private JLabel checkInLabel;
    private JLabel checkOutLabel;
    private JLabel discountCodeLabel;
    private JLabel guestNameLabel;
    private JLabel hotelHeading;
    private JLabel reservationHeading;
    private JLabel selectedRoomLabel;
    private JLabel totalPriceLabel;
    private JLabel availableRoomsLabel;

    private JTextField checkInTextField;
    private JTextField checkOutTextField;
    private JTextField discountCodeTextField;
    private JTextField guestNameTextField;
    private JTextField selectedRoomTextField;
    private JTextField totalPriceField;

    private JButton confirmReservationButton;
    private JButton roomTableButton;

    private JScrollPane hotelScrollPane;
    private JScrollPane roomScrollPane;

    private JTable hotelTable;
    private JTable roomTable;

    private DefaultTableModel roomTableModel;

    private ListSelectionModel roomSelectionModel;
    private ListSelectionModel hotelSelectionModel;

    private int hotelIndex;
    private int roomIndex;
    private int checkIn;
    private int checkOut;

    public BookingPanel(HotelReservationSystemController controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {
        roomScrollPane = new JScrollPane();
        roomTable = new JTable();
        reservationHeading = new JLabel("Reservation Information");
        totalPriceLabel = new JLabel("Total Price:");
        totalPriceField = new JTextField();
        roomTableButton = new JButton("Find Available Rooms");
        hotelScrollPane = new JScrollPane();
        hotelTable = new JTable();
        guestNameLabel = new JLabel("Guest Name:");
        guestNameTextField = new JTextField("Name");
        checkInLabel = new JLabel("Check In:");
        checkInTextField = new JTextField("Date");
        checkOutLabel = new JLabel("Check Out:");
        checkOutTextField = new JTextField("Date");
        discountCodeLabel = new JLabel("Discount Code:");
        discountCodeTextField = new JTextField("Code");
        confirmReservationButton = new JButton("Confirm Reservation");
        hotelHeading = new JLabel("No Selected Hotel");
        selectedRoomLabel = new JLabel("Selected Room:");
        selectedRoomTextField = new JTextField();
        availableRoomsLabel = new JLabel("Available Rooms");
        roomTableModel = new DefaultTableModel(0, 0);

        roomIndex = -1;
        hotelIndex = -1;

        setLayout(null);

        String[] roomTableHeader = {"Room", "Room Type"};
        roomTableModel.setColumnIdentifiers(roomTableHeader);
        roomTable.setModel(roomTableModel);

        roomSelectionModel = roomTable.getSelectionModel();
        roomSelectionModel.addListSelectionListener(this);

        roomScrollPane.setViewportView(roomTable);
        add(roomScrollPane);
        roomScrollPane.setBounds(20, 190, 220, 270);

        reservationHeading.setFont(new java.awt.Font("Segoe UI", 1, 14));
        add(reservationHeading);
        reservationHeading.setBounds(260, 300, 280, 20);

        totalPriceField.setEditable(false);
        add(totalPriceField);
        totalPriceField.setBounds(370, 370, 170, 30);

        roomTableButton.addActionListener(this);
        add(roomTableButton);
        roomTableButton.setBounds(370, 260, 170, 23);

        String[] hotelNameHeader = {"Select a Hotel"};
        DefaultTableModel hotelListModel = new DefaultTableModel(0, 1);
        hotelListModel.setColumnIdentifiers(hotelNameHeader);
        hotelTable.setModel(hotelListModel);

        for (Hotel hotel : controller.getHotelObjects()) {
            hotelListModel.addRow(new Object[]{hotel.getName()});
        }

        hotelTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        hotelSelectionModel = hotelTable.getSelectionModel();
        hotelSelectionModel.addListSelectionListener(this);

        hotelScrollPane.setViewportView(hotelTable);
        add(hotelScrollPane);
        hotelScrollPane.setBounds(20, 30, 220, 110);

        guestNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        add(guestNameLabel);
        guestNameLabel.setBounds(260, 90, 100, 30);
        add(guestNameTextField);
        guestNameTextField.setBounds(370, 90, 170, 30);

        checkInLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        add(checkInLabel);
        checkInLabel.setBounds(260, 130, 100, 30);
        add(checkInTextField);
        checkInTextField.setBounds(370, 130, 170, 30);

        checkOutLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        add(checkOutLabel);
        checkOutLabel.setBounds(260, 170, 100, 30);
        add(checkOutTextField);
        checkOutTextField.setBounds(370, 170, 170, 30);

        discountCodeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        add(discountCodeLabel);
        discountCodeLabel.setBounds(260, 210, 100, 30);
        add(discountCodeTextField);
        discountCodeTextField.setBounds(370, 210, 170, 30);

        confirmReservationButton.addActionListener(this);
        add(confirmReservationButton);
        confirmReservationButton.setBounds(370, 430, 170, 23);

        hotelHeading.setFont(new java.awt.Font("Segoe UI", 1, 14));
        add(hotelHeading);
        hotelHeading.setBounds(260, 40, 280, 20);

        selectedRoomLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        add(selectedRoomLabel);
        selectedRoomLabel.setBounds(260, 330, 100, 30);
        selectedRoomTextField.setEditable(false);
        add(selectedRoomTextField);
        selectedRoomTextField.setBounds(370, 330, 170, 30);

        availableRoomsLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        availableRoomsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(availableRoomsLabel);
        availableRoomsLabel.setBounds(20, 156, 220, 30);
    }

    public void handleRoomSelection(ListSelectionEvent event) {
        if (hotelIndex == -1 || roomIndex == -1) {
            selectedRoomTextField.setText("");
            totalPriceField.setText("");
            return;
        }

        Hotel hotel = controller.getHotel(hotelIndex);
        Room room = hotel.getRoomList().get(roomIndex);
        selectedRoomTextField.setText(room.getName());

        if (isDateValid()) {
            String discountCode = discountCodeTextField.getText();
            double totalPrice = controller.getTotalReservationPrice(hotel, room, checkIn, checkOut, discountCode);
            totalPriceField.setText(Double.toString(totalPrice));
        }
    }

    public void handleHotelSelection(ListSelectionEvent event) {
        if (isDateValid()) {
            updateRoomList(controller.getHotel(hotelIndex), checkIn, checkOut);
        } else {
            roomTableModel.setRowCount(0);
        }
        hotelHeading.setText("Selected Hotel: " + controller.getHotel(hotelIndex).getName());
    }

    public void updateRoomList(Hotel hotel, int checkIn, int checkOut) {
        List<Room> availableRooms = hotel.filterRooms(checkIn, checkOut);
        roomTableModel.setRowCount(0);

        for (Room room : availableRooms) {
            String roomType = "ERROR";
            if (room instanceof StandardRoom) {
                roomType = "STANDARD";
            } else if (room instanceof DeluxeRoom) {
                roomType = "DELUXE";
            } else if (room instanceof ExecutiveRoom) {
                roomType = "EXECUTIVE";
            }
            roomTableModel.addRow(new Object[]{room.getName(), roomType});
        }

        String[] roomTableHeader = {"Room", "Room Type"};
        roomTableModel.setColumnIdentifiers(roomTableHeader);
        roomTable.setModel(roomTableModel);
    }

    private boolean isDateValid() {
        boolean isDateAnInt = false;

        try {
            checkIn = Integer.parseInt(checkInTextField.getText());
            checkOut = Integer.parseInt(checkOutTextField.getText());
            isDateAnInt = true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid date!");
            return false;
        }

        boolean isDateWithinBounds = checkIn >= 1 && checkIn <= 30 && checkOut >= 2 && checkOut <= 31;
        boolean isTimespanValid = checkIn < checkOut;

        return isDateAnInt && isDateWithinBounds && isTimespanValid;
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (event.getValueIsAdjusting()) {
            return;
        }

        if (event.getSource() == hotelSelectionModel) {
            hotelIndex = hotelTable.getSelectedRow();
            handleHotelSelection(event);
        } else if (event.getSource() == roomSelectionModel) {
            roomIndex = roomTable.getSelectedRow();
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
            if (!isDateValid()) {
                JOptionPane.showMessageDialog(null, "Invalid date!");
                return;
            }

            updateRoomList(controller.getHotel(hotelIndex), checkIn, checkOut);
        } else if (event.getSource() == confirmReservationButton) {
            if (hotelIndex == -1 || roomIndex == -1 || !isDateValid()) {
                JOptionPane.showMessageDialog(null, "No room selected!");
                return;
            }

            Hotel   hotel = controller.getHotel(hotelIndex);
            String  guestName = guestNameTextField.getText();
            Room    room = hotel.getRoomList().get(roomIndex);
            String  discountCode = discountCodeTextField.getText();

            boolean bookingSuccessful = controller.createAndAddReservation(hotel, guestName, room, checkIn, checkOut, discountCode);

            if (bookingSuccessful) {
                JOptionPane.showMessageDialog(null, "Reservation booking successful!");
                refreshPanel();
            } else {
                JOptionPane.showMessageDialog(null, "Reservation booking failed!\nPlease double check your inputs.");
            }
        }
    }

    /**
     * Refreshes this panel.
     */
    private void refreshPanel() {
        System.out.println("Refreshing Panel...");
        this.removeAll();
        this.initComponents();
        this.repaint();
        this.revalidate();
    }

    @Override
    public String getName() {
        return "Book New Reservation";
    }
}
